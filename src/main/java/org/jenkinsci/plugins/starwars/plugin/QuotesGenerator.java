package org.jenkinsci.plugins.starwars.plugin;

import java.util.Random;

public class QuotesGenerator {

	/**
	 * Star Wars Quotes. 
	 * TODO: move quotes to a properly configuration file (json, xml, etc).
	 */
	private static final String[] QUOTES = { "PATIENCE YOU MUST HAVE my young padawan - Yoda",
			"Powerful you have become, the dark side I sense in you - Yoda",
			"You must unlearn what you have learned - Yoda", "The fear of loss is a path to the Dark Side - Yoda",
			"Do or do not. There is no try - Yoda", "May the Force be with you - Yoda",
			"Judge me by my size, do you? - Yoda", "I find your lack of faith disturbing - Darth Vader",
			"The Force is strong with this one - Darth Vader",
			"Impressive. Most impressive. Obi-Wan has taught you well. You have controlled your fear. Now, release your anger. Only your hatred can destroy me  - Darth Vader",
			"Great, kid. Don't get cocky - Han Solo" };

	/**
	 * Random instance.
	 */
	private static final Random RANDOM = new Random();

	/**
	 * Retrieves a random quote
	 * 
	 * @return a random quote
	 */
	public String random() {
		return QUOTES[RANDOM.nextInt(QUOTES.length)];
	}
}
