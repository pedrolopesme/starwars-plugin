package org.jenkinsci.plugins.starwars.plugin;

import static org.junit.Assert.fail;

import org.junit.Test;

public class QuotesGeneratorTest {

	private QuotesGenerator generator = new QuotesGenerator();

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
