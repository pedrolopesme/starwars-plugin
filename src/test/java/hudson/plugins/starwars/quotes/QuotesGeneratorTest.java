package hudson.plugins.starwars.quotes;

import org.junit.Test;

import hudson.plugins.starwars.StarWarsResult;
import junit.framework.TestCase;

public class QuotesGeneratorTest extends TestCase {
	
	@Test
	public void testShouldAddQuotesGroupingByResultType() {
		
		QuotesGenerator generator = new QuotesGenerator(false);
		
		assertEquals(0, generator.getQuotes().size());
		assertNull(generator.getQuotes().get(StarWarsResult.SUCCESS));
		assertNull(generator.getQuotes().get(StarWarsResult.FAIL));
		assertNull(generator.getQuotes().get(StarWarsResult.ALERT));
		
		Quote quote1 = giveMeAQuote(1, StarWarsResult.SUCCESS);
		generator.add(quote1);
		assertEquals(1, generator.getQuotes().size());
		assertEquals(1, generator.getQuotes().get(StarWarsResult.SUCCESS).size());
		assertNull(generator.getQuotes().get(StarWarsResult.FAIL));
		assertNull(generator.getQuotes().get(StarWarsResult.ALERT));
		
		Quote quote2 = giveMeAQuote(2, StarWarsResult.ALERT);
		generator.add(quote2);
		assertEquals(2, generator.getQuotes().size());
		assertEquals(1, generator.getQuotes().get(StarWarsResult.SUCCESS).size());
		assertEquals(1, generator.getQuotes().get(StarWarsResult.ALERT).size());
		assertNull(generator.getQuotes().get(StarWarsResult.FAIL));

		Quote quote3 = giveMeAQuote(1, StarWarsResult.FAIL);
		generator.add(quote3);
		assertEquals(3, generator.getQuotes().size());
		assertEquals(1, generator.getQuotes().get(StarWarsResult.SUCCESS).size());
		assertEquals(1, generator.getQuotes().get(StarWarsResult.ALERT).size());
		assertEquals(1, generator.getQuotes().get(StarWarsResult.FAIL).size());
		
	}
	
	@Test
	public void testRandomShouldGivesDiferentQuotes() {

		QuotesGenerator generator = new QuotesGenerator(false);
		for(int c = 0; c < 10000; c++) {
			Quote quote = giveMeAQuote(c, StarWarsResult.SUCCESS);
			generator.add(quote);
		}
	
		Quote lastQuote = null;
		for (int i = 0; i < 1000000; i++) {
			Quote quote = generator.generate(StarWarsResult.SUCCESS);
			if (lastQuote != null && !lastQuote.equals(quote)) {
				return;
			}
			lastQuote = quote;
		}
		fail("Random should give at least 2 different quotes in 1000000 tries.");
	}

	private Quote giveMeAQuote(int c, StarWarsResult result) {
		Quote quote = new Quote();
		quote.setAuthor(QuoteAuthor.DARTH_VADER);
		quote.setResult(result);
		quote.setQuote("bar - " + c);
		return quote;
	}
}
