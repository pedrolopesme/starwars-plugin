package hudson.plugins.starwars.quotes;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import hudson.plugins.starwars.StarWarsResult;
import junit.framework.TestCase;

public class QuotesParserTest extends TestCase {

	@Test
	public void testParseNonExistentXmlDocument() {
		QuotesParser mockParser = mock(QuotesParser.class);
		when(mockParser.getQuotesPath()).thenReturn(null);
		Set<Quote> expected = new HashSet<Quote>();
		Set<Quote> result = mockParser.getQuotes();
		assertEquals(expected, result);
	}

	@Test
	public void testParseEmptyXmlDocument() {
		QuotesParser mockParser = mock(QuotesParser.class);
		when(mockParser.loadXml()).thenReturn(null);
		Set<Quote> expected = new HashSet<Quote>();
		Set<Quote> result = mockParser.getQuotes();
		assertEquals(expected, result);
	}

	@Test
	public void testParseXmlDocumentWithOneQuote() throws ParserConfigurationException, SAXException, IOException {

		Quote expectedQuote = new Quote();
		expectedQuote.setAuthor(QuoteAuthor.LUKE);
		expectedQuote.setQuote("FailedTest-1");
		expectedQuote.setResult(StarWarsResult.FAIL);
		
		Document dummyDocument = getDocument(expectedQuote, 1);

		Set<Quote> expected = new HashSet<Quote>();
		expected.add(expectedQuote);

		QuotesParser parser = new QuotesParser();
		Set<Quote> result = parser.parseQuotesDocument(dummyDocument);

		assertEquals(expected.size(), 1);
		assertEquals(result.size(), 1);

		Quote firstQuote = result.iterator().next();
		assertFalse(firstQuote.equals(expectedQuote));
		
		expectedQuote = new Quote();
		expectedQuote.setAuthor(QuoteAuthor.LUKE);
		expectedQuote.setQuote("Test-1");
		expectedQuote.setResult(StarWarsResult.SUCCESS);
		dummyDocument = getDocument(expectedQuote, 1);
		result = parser.parseQuotesDocument(dummyDocument);
		
		Iterator<Quote> iterator = result.iterator();
		firstQuote = iterator.next();
		assertEquals(expectedQuote, firstQuote);
	}

	@Test
	public void testParseXmlDocumentWithMultipleQuotes()
			throws ParserConfigurationException, SAXException, IOException {

		Quote expectedQuote = new Quote();
		expectedQuote.setAuthor(QuoteAuthor.LUKE);
		expectedQuote.setQuote("Test");
		expectedQuote.setResult(StarWarsResult.SUCCESS);
		
		Document dummyDocument = getDocument(expectedQuote, 5);

		QuotesParser parser = new QuotesParser();		
		Set<Quote> result = parser.parseQuotesDocument(dummyDocument);

		assertEquals(result.size(), 5);
		Quote firstQuote = result.iterator().next();
		firstQuote.setQuote("Test-1");
		assertFalse(firstQuote.equals(expectedQuote));

		result = parser.parseQuotesDocument(dummyDocument);

		Quote lastQuote = null;
		Iterator<Quote> iterator = result.iterator();
		while(iterator.hasNext()){
			lastQuote=iterator.next();
		}
		expectedQuote.setQuote("Test-5");
		assertEquals(expectedQuote, lastQuote);
	}

	private Document getDocument(Quote quote, int quotesQnt) throws ParserConfigurationException {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();

		Element rootElement = doc.createElement("quotes");
		doc.appendChild(rootElement);

		for (int i = 1; i <= quotesQnt; i++) {
			Element quoteElement = doc.createElement("quote");
			quoteElement.appendChild(doc.createTextNode("Test-" + i));
			quoteElement.setAttribute("author", quote.getAuthor().getXmlName());
			quoteElement.setAttribute("result", quote.getResult().getDescription());
			rootElement.appendChild(quoteElement);
		}

		return doc;

	}
}
