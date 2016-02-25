package hudson.plugins.starwars;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import hudson.plugins.starwars.quotes.Quote;
import hudson.plugins.starwars.quotes.QuoteAuthor;

public class StarWarsActionTest {

	@Test
	public void testAccessors() {
		StarWarsResult result = StarWarsResult.SUCCESS;
		
		Quote exptectedQuote = new Quote();
		exptectedQuote.setQuote("Foo bar");
		exptectedQuote.setAuthor(QuoteAuthor.LUKE);
		exptectedQuote.setResult(result);

		StarWarsAction action = new StarWarsAction(result, exptectedQuote);
		assertEquals(StarWarsResult.SUCCESS, action.getResult());
		assertEquals(result, action.getResult());
		assertEquals(exptectedQuote, action.getQuote());
		assertEquals(exptectedQuote.getQuote(), action.getQuoteContent());
		
	}

	@Test
	public void testNullQuoteContent() {
		StarWarsAction action = new StarWarsAction(null, null);
		assertNull(action.getQuoteContent());
	}
}
