package hudson.plugins.starwars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hudson.plugins.starwars.quotes.Quote;
import hudson.plugins.starwars.quotes.QuoteAuthor;

public class StarWarsActionTest {

	@Test
	public void testAccessors() {
		StarWarsResult result = StarWarsResult.SUCCESS;
		
		Quote quote = new Quote();
		quote.setQuote("Foo bar");
		quote.setAuthor(QuoteAuthor.LUKE);
		quote.setResult(result);

		StarWarsAction action = new StarWarsAction(result, quote);
		assertEquals(StarWarsResult.SUCCESS, action.getResult());
		assertEquals(result, action.getResult());
		assertEquals(quote.getQuote(), action.getQuote());
	}

}
