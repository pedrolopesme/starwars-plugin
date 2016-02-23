package hudson.plugins.starwars.quotes;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
	private static String DEFAULT_QUOTES_PATH = "src/main/resources/quotes.xml";

	/**
	 * Quotes path
	 */
	private String quotesPath = DEFAULT_QUOTES_PATH;

	/**
	 * Load quotes XML and parse it
	 */
	public Set<Quote> parseXml() {
		try {
			Set<Quote> quotes = new HashSet<Quote>();

			Document document = loadXml(quotesPath);
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

		} catch (Exception e) {
			LOGGER.severe("It was not possible to parse quotes XML. Cause : " + e.getStackTrace());
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
	private Document loadXml(String path) throws ParserConfigurationException, SAXException, IOException {
		File fXmlFile = new File(path);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(fXmlFile);

		// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		document.getDocumentElement().normalize();

		return document;
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

}
