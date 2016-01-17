package org.jenkinsci.plugins.starwars.plugin;

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

}