package hudson.plugins.starwars.quotes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import hudson.plugins.starwars.StarWarsResult;

/**
 * QuotesGenerator generate random famous classic quotes.
 *
 * @author pedromendes
 */
public class QuotesGenerator {

	/**
	 * Store quotes, grouping them by Result (success, fail, alert)
	 */
	private Map<StarWarsResult, ArrayList<Quote>> quotes = new HashMap<StarWarsResult, ArrayList<Quote>>();

	/**
	 * Random instance.
	 */
	private static final Random RANDOM = new Random();

	/**
	 * Random instance.
	 */
	private static final QuotesParser quotesParser = new QuotesParser();

	/**
	 * Default constructor - loads quotes
	 */
	public QuotesGenerator() {
		loadQuotes();
	}

	/**
	 * Alternative constructor - allows start instance without quotes loading.
	 */
	public QuotesGenerator(boolean loadQuotes) {
		if (loadQuotes) {
			loadQuotes();
		}
	}
	
	/**
	 * Load quotes from quotes.xml
	 */
	public void loadQuotes() {
		Set<Quote> quotes = quotesParser.getQuotes();
		if (quotes != null && quotes.size() > 0) {
			for (Quote quote : quotes) {
				add(quote);
			}
		}
	}

	/**
	 * Add a quote accordingly to its result
	 */
	public void add(Quote quote) {
		ArrayList<Quote> resultQuotes = quotes.get(quote.getResult());
		if (resultQuotes == null) {
			resultQuotes = new ArrayList<Quote>();
			quotes.put(quote.getResult(), resultQuotes);
		}
		resultQuotes.add(quote);
	}

	/**
	 * Retrieves a random quote filtering by Result (success, fail, alert)
	 * 
	 * @return a random quote
	 */
	public Quote generate(StarWarsResult result) {
		ArrayList<Quote> resulQuotes = quotes.get(result);
		if (resulQuotes != null && resulQuotes.size() > 0) {
			int maxIndex = resulQuotes.size() - 1;
			int randomIndex = maxIndex > 0 ? RANDOM.nextInt(maxIndex) : 0;
			return resulQuotes.get(randomIndex);
		}
		return null;
	}

	/**
	 * Return loaded quotes
	 * 
	 * @return
	 */
	public Map<StarWarsResult, ArrayList<Quote>> getQuotes() {
		return quotes;
	}

}
