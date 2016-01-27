package hudson.plugins.starwars;

import java.io.IOException;
import java.util.logging.Logger;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.model.Result;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Recorder;

/**
 * This class associates a StarWarsAction to a job or a build.
 * 
 * @author pedromendes
 */
@SuppressWarnings("unchecked")
public class StarWarsRecorder extends Recorder {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = Logger.getLogger(StarWarsRecorder.class.getName());

	/**
	 * Quotes generator.
	 */
	private QuotesGenerator quotesGenerator;

	/**
	 * Constructs a StarWarsRecorder with default QuotesGenerator
	 * 
	 */
	@DataBoundConstructor
	public StarWarsRecorder() {
		this(new QuotesGenerator());
	}

	/**
	 * Constructs a StarWarsRecorder with specified QuotesGenerator.
	 * 
	 * @param quotesGenerator
	 */
	public StarWarsRecorder(QuotesGenerator quotesGenerator) {
		this.quotesGenerator = quotesGenerator;
		LOGGER.info("Star Wars Jenkins Plugin is activated");
	}

	/**
	 * Gets the StarWarsAction as the project action. This is applicable for
	 * each job and only when there's at least one build in the job.
	 * 
	 * @param project
	 * @return the project action
	 */
	@Override
	public final Action getProjectAction(final AbstractProject<?, ?> project) {
		Action action = null;
		if (project.getLastBuild() != null) {
			Result result = project.getLastBuild().getResult();
			StarWarsResult starWarsResult = StarWarsResult.get(result);
			String starWarsQuote = quotesGenerator.generate();
			action = new StarWarsAction(starWarsResult, starWarsQuote);
		}
		return action;
	}

	/**
	 * Adds StarWarsAction to the build actions. This is applicable for each
	 * build
	 * 
	 * @param build
	 * @param launcher
	 * @param listener
	 * @return true
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Override
	public final boolean perform(final AbstractBuild<?, ?> build, final Launcher launcher, final BuildListener listener)
			throws InterruptedException, IOException {
		StarWarsResult result = StarWarsResult.get(build.getResult());
		String fact = quotesGenerator.generate();
		build.getActions().add(new StarWarsAction(result, fact));
		return true;
	}

	/**
	 * Gets the required monitor service.
	 * 
	 * @return the BuildStepMonitor
	 */
	public BuildStepMonitor getRequiredMonitorService() {
		return BuildStepMonitor.NONE;
	}

}
