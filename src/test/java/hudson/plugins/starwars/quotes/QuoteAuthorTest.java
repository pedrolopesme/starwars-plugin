package hudson.plugins.starwars.quotes;

import org.junit.Test;

import junit.framework.TestCase;

public class QuoteAuthorTest extends TestCase {

	@Test
	public void testAuthorStringGivesAckbar() {
		assertEquals(QuoteAuthor.ACKBAR, QuoteAuthor.get("ackbar"));
	}

	@Test
	public void testAuthorStringGivesC3PO() {
		assertEquals(QuoteAuthor.C3PO, QuoteAuthor.get("c3po"));
	}

	@Test
	public void testAuthorStringGivesDarthVader() {
		assertEquals(QuoteAuthor.DARTH_VADER, QuoteAuthor.get("darthVader"));
	}

	@Test
	public void testAuthorStringGivesHanSolo() {
		assertEquals(QuoteAuthor.HAN_SOLO, QuoteAuthor.get("hanSolo"));
	}

	@Test
	public void testAuthorStringGivesLeia() {
		assertEquals(QuoteAuthor.LEIA, QuoteAuthor.get("leia"));
	}

	@Test
	public void testAuthorStringGivesLuke() {
		assertEquals(QuoteAuthor.LUKE, QuoteAuthor.get("luke"));
	}
	
	@Test
	public void testAuthorStringGivesObiWan() {
		assertEquals(QuoteAuthor.OBI_WAN, QuoteAuthor.get("obiWan"));
	}
	
	@Test
	public void testAuthorStringGivesPalpatine() {
		assertEquals(QuoteAuthor.PALPATINE, QuoteAuthor.get("palpatine"));
	}
	
	@Test
	public void testAuthorStringGivesQuiGon() {
		assertEquals(QuoteAuthor.QUI_GON, QuoteAuthor.get("quiGon"));
	}
	
	@Test
	public void testAuthorStringGivesR2D2() {
		assertEquals(QuoteAuthor.R2D2, QuoteAuthor.get("r2d2"));
	}

	@Test
	public void testAuthorStringGivesYoda() {
		assertEquals(QuoteAuthor.YODA, QuoteAuthor.get("yoda"));
	}

}
