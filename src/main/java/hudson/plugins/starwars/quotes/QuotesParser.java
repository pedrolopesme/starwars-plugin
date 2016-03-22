package hudson.plugins.starwars.quotes;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import hudson.PluginWrapper;
import hudson.model.Hudson;
import hudson.plugins.starwars.StarWarsResult;

/**
 * QuotesParser loads quotes from disc and parse quotes
 *
 * @author pedromendes
 */
public class QuotesParser {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = Logger.getLogger(QuotesParser.class.getName());

	/**
	 * Constant with default quotes path
	 */
	public static String DEFAULT_QUOTES_PATH = "xml" + File.separator + "quotes.xml";

	/**
	 * Quotes path
	 */
	private String quotesPath = DEFAULT_QUOTES_PATH;

	/**
	 * Load quotes XML and parse it
	 */
	public Set<Quote> getQuotes() {
		Document document = loadXml();
		return parseQuotesDocument(document);
	}

	/**
	 * Parse Quotes Document
	 */
	public Set<Quote> parseQuotesDocument(Document document) {
		try {

			Set<Quote> quotes = new HashSet<Quote>();
			NodeList quoteNodes = document.getElementsByTagName("quote");

			for (int temp = 0; temp < quoteNodes.getLength(); temp++) {
				Node node = quoteNodes.item(temp);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element quoteElement = (Element) node;

					String quoteContent = quoteElement.getTextContent().trim();
					String authorName = quoteElement.getAttribute("author");
					String resultString = quoteElement.getAttribute("result");
					StarWarsResult result = StarWarsResult.get(resultString);
					QuoteAuthor author = QuoteAuthor.get(authorName);

					if (result != null && author != null) {
						Quote quote = new Quote();
						quote.setQuote(quoteContent);
						quote.setResult(result);
						quote.setAuthor(author);
						quotes.add(quote);
					}
				}
			}
			return quotes;
		} catch (Exception ex) {
			LOGGER.error("It was not possible to parse quotes XML. Cause : " + ex.getStackTrace());
			return null;
		}
	}

	/**
	 * Loads XML file from DISC
	 * 
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	public Document loadXml() {
		try {

			String quotesXmlFullPath = getPluginRootPath() + getQuotesPath();
			File xmlFile = new File(quotesXmlFullPath);
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document document = docBuilder.parse(xmlFile);

			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			document.getDocumentElement().normalize();

			return document;
		} catch (Exception ex) {
			LOGGER.error("It was not possible to load quotes XML. Cause : " + ex.getStackTrace());
			return null;
		}
	}

	/**
	 * Return quote.xml path
	 */
	public String getQuotesPath() {
		return quotesPath;
	}

	/**
	 * Set quote.xml path
	 */
	public void setQuotesPath(String quotesPath) {
		this.quotesPath = quotesPath;
	}

	/**
	 * Gets plugin's path
	 * 
	 * @return plugin's path
	 */
	public String getPluginRootPath() {
		PluginWrapper wrapper = Hudson.getInstance().getPluginManager().getPlugin("starwars");
		return Hudson.getInstance().getRootPath() + File.separator + "plugins" + File.separator + wrapper.getShortName() + File.separator;
	}

}
