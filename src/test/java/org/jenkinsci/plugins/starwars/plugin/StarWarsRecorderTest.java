package org.jenkinsci.plugins.starwars.plugin;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.Build;
import hudson.model.BuildListener;
import hudson.model.Result;
import junit.framework.TestCase;

public class StarWarsRecorderTest extends TestCase {

	private static final String EXPECTED_QUOTE = "Do or do not. There is no try - Yoda.";
	private QuotesGenerator mockQuotesGenerator;
	private StarWarsRecorder recorder;

	@Override
	public void setUp() {
		mockQuotesGenerator = mock(QuotesGenerator.class);
		recorder = new StarWarsRecorder(mockQuotesGenerator);
	}

	public void testGetProjectActionWithNoLastBuildGivesNullAction() {
		AbstractProject mockProject = mock(AbstractProject.class);
		when(mockProject.getLastBuild()).thenReturn(null);
		assertNull(recorder.getProjectAction(mockProject));
	}

	public void testGetProjectActionHavingLastBuildGivesStarWarsAction() {
		AbstractProject mockProject = mock(AbstractProject.class);
		Build mockBuild = mock(Build.class);

		when(mockProject.getLastBuild()).thenReturn(mockBuild);
		when(mockBuild.getResult()).thenReturn(Result.SUCCESS);
		when(mockQuotesGenerator.generate()).thenReturn(EXPECTED_QUOTE);

		Action action = recorder.getProjectAction(mockProject);

		assertTrue(action instanceof StarWarsAction);
		assertEquals(StarWarsResult.SUCCESS, ((StarWarsAction) action).getResult());
		assertNotNull(((StarWarsAction) action).getQuote());
	}

	public void testPerformWithFailureResultAddsStarWarsActionWithFailResultAndExpectedQuote() throws Exception {
		List<Action> actions = new ArrayList<Action>();
		AbstractBuild mockBuild = mock(AbstractBuild.class);
		when(mockBuild.getResult()).thenReturn(Result.FAILURE);
		when(mockBuild.getActions()).thenReturn(actions);

		when(mockQuotesGenerator.generate()).thenReturn(EXPECTED_QUOTE);
		assertEquals(0, actions.size());

		Launcher mockLauncher = mock(Launcher.class);
		BuildListener mockBuildListener = mock(BuildListener.class);
		recorder.perform(mockBuild, mockLauncher, mockBuildListener);

		assertEquals(1, actions.size());
		assertTrue(actions.get(0) instanceof StarWarsAction);

		StarWarsAction action = (StarWarsAction) actions.get(0);
		assertEquals(StarWarsResult.FAIL, action.getResult());
		assertEquals(EXPECTED_QUOTE, action.getQuote());
	}

}
