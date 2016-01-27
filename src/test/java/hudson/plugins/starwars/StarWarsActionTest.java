package hudson.plugins.starwars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hudson.plugins.starwars.QuotesGenerator;
import hudson.plugins.starwars.StarWarsAction;
import hudson.plugins.starwars.StarWarsResult;

public class StarWarsActionTest {

	@Test
	public void testAccessors() {
		StarWarsResult result = StarWarsResult.SUCCESS;
		QuotesGenerator generator = new QuotesGenerator();
		String quote = generator.generate();

		StarWarsAction action = new StarWarsAction(result, quote);
		assertEquals(StarWarsResult.SUCCESS, action.getResult());
		assertEquals(result, action.getResult());
		assertEquals(quote, action.getQuote());
	}

}
