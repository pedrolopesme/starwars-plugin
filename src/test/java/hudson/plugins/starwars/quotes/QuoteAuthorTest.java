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
	
	@Test
	public void testAuthorStringGivesYoda() {
		assertEquals(QuoteAuthor.YODA, QuoteAuthor.get("yoda"));
	}
	
	@Test
	public void testAuthorStringGivesHanSolo() {
		assertEquals(QuoteAuthor.HAN_SOLO, QuoteAuthor.get("hanSolo"));
	}
}
