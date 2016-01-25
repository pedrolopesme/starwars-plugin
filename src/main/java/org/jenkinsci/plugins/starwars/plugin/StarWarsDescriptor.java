package org.jenkinsci.plugins.starwars.plugin;

import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Publisher;

/**
 * Provides build step description.
 *
 * @author pedromendes
 */
public class StarWarsDescriptor  extends BuildStepDescriptor<Publisher> {

    /**
     * Constructs a a step description passing a Star Wars Recorder!
     */
    public StarWarsDescriptor() {
        super(StarWarsRecorder.class);
    }

    /**
     * Checks whether this descriptor is applicable - ALWAYS TRUE!
     * @param clazz
     * @return true
     */	
	@Override
	public boolean isApplicable(Class<? extends AbstractProject> jobType) {
		return true;
	}

	 /**
     * Gets the descriptor display name, used in the post step checkbox
     * description.
     * @return the descriptor display name
     */
	@Override
	public String getDisplayName() {
		return "Activate Star Wars";
	}

}
