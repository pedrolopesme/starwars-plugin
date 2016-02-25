package hudson.plugins.starwars.quotes;

import org.junit.Test;

import junit.framework.TestCase;

public class QuoteAuthorTest extends TestCase {

	@Test
	public void testAuthorStringGivesLuke() {
		assertEquals(QuoteAuthor.LUKE, QuoteAuthor.get("luke"));
	}
	
	@Test
	public void testAuthorStringGivesDarthVader() {
		assertEquals(QuoteAuthor.DARTH_VADER, QuoteAuthor.get("darthVader"));
	}
}
