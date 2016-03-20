package hudson.plugins.starwars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hudson.model.Result;

public class StarWarsResultTest {

	@Test
	public void testSuccessResultGivesStarWarsSuccess() {
		assertEquals(StarWarsResult.SUCCESS, StarWarsResult.get(Result.SUCCESS));
	}

	@Test
	public void testFailureResultGivesStarWarsFailure() {
		assertEquals(StarWarsResult.FAIL, StarWarsResult.get(Result.FAILURE));
	}

	@Test
	public void testAbortedResultGivesStarWarsAlert() {
		assertEquals(StarWarsResult.ALERT, StarWarsResult.get(Result.ABORTED));
	}

	@Test
	public void testNotBuiltResultGivesStarWarsAlert() {
		assertEquals(StarWarsResult.ALERT, StarWarsResult.get(Result.NOT_BUILT));
	}

	@Test
	public void testUnstableResultGivesStarWarsAlert() {
		assertEquals(StarWarsResult.ALERT, StarWarsResult.get(Result.UNSTABLE));
	}

	@Test
	public void testSuccessStringGivesStarWarsSuccess() {
		assertEquals(StarWarsResult.SUCCESS, StarWarsResult.get("success"));
	}

	@Test
	public void testAlertStringGivesStarWarsAlert() {
		assertEquals(StarWarsResult.ALERT, StarWarsResult.get("alert"));
	}
	
	@Test
	public void testFailStringGivesStarWarsFail() {
		assertEquals(StarWarsResult.FAIL, StarWarsResult.get("fail"));
	}
	
	@Test
	public void testInsertStringGivesNull() {
		assertEquals(null, StarWarsResult.get("foobar"));
	}
}