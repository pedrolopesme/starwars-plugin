package hudson.plugins.starwars;

import org.junit.Test;

import hudson.plugins.starwars.QuotesGenerator;
import junit.framework.TestCase;

public class QuotesGeneratorTest extends TestCase {

	private QuotesGenerator generator;

	public void setUp() {
		generator = new QuotesGenerator();
	}
	
	@Test
	public void testRandomShouldGivesDiferentQuotes() {
		int totalAttempts = 100;
		String lastQuote = null;
		for (int i = 0; i < totalAttempts; i++) {
			String currQuote = generator.generate();
			if (lastQuote != null && !lastQuote.equals(currQuote)) {
				return;
			}
			lastQuote = currQuote;
		}
		fail("Random should give at least 2 different facts in " + totalAttempts + " tries.");
	}
}
