package hudson.plugins.starwars;

import org.apache.log4j.Logger;

import hudson.model.Action;
import hudson.plugins.starwars.quotes.Quote;

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
	private Quote quote;

	/**
	 * Constructs a StarWarsAction with specified result and quote.
	 * 
	 * @param result
	 * @param quote
	 */
	public StarWarsAction(StarWarsResult result, Quote quote) {
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

	public Quote getQuote() {
		return quote;
	}

	/**
	 * Returning quote content
	 * 
	 * @return quote text
	 */
	public String getQuoteContent() {
		if (quote != null) {
			return quote.getQuote();
		}
		return null;
	}
}