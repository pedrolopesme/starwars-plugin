package hudson.plugins.starwars.quotes;

import org.junit.Test;

import hudson.plugins.starwars.StarWarsResult;
import junit.framework.TestCase;

public class QuotesTest extends TestCase {

	@Test
	public void testQuotesEquality() {
		Quote quote1 = new Quote();
		quote1.setAuthor(QuoteAuthor.DARTH_VADER);
		quote1.setResult(StarWarsResult.SUCCESS);
		quote1.setQuote("foo");
		
		Quote quote2 = new Quote();
		quote2.setAuthor(QuoteAuthor.LUKE);
		quote2.setResult(StarWarsResult.FAIL);
		quote2.setQuote("far");
		
		Quote quote3 = new Quote();
		quote3.setAuthor(QuoteAuthor.DARTH_VADER);
		quote3.setResult(StarWarsResult.SUCCESS);
		quote3.setQuote("foo");
		
		assertTrue(quote1.equals(quote1));
		assertFalse(quote1.equals(quote2));
		assertTrue(quote1.equals(quote3));
	}
	
}
