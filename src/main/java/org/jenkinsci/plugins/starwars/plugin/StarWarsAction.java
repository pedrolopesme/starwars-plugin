package org.jenkinsci.plugins.starwars.plugin;

import hudson.model.Action;

/**
 * StarWarsAction keeps the result and quote associated with a action.
 *
 * @author pedromendes
 */
public class StarWarsAction implements Action {

	/**
	 * The result
	 */
	private StarWarsResult result;

	/**
	 * The quote
	 */
	private String quote;

	/**
	 * Constructs a StarWarsAction with specified result and quote.
	 * 
	 * @param result
	 * @param quote
	 */
	public StarWarsAction(StarWarsResult result, String quote) {
		super();
		this.result = result;
		this.quote = quote;
	}

	public String getIconFileName() {
		return null;
	}

	public String getDisplayName() {
		return "Star Wars Jenkins Plugin";
	}

	public String getUrlName() {
		return "starwars";
	}

	public StarWarsResult getResult() {
		return result;
	}

	public String getQuote() {
		return quote;
	}

}