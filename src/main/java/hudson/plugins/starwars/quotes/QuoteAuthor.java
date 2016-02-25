package hudson.plugins.starwars.quotes;

/**
 * Represents a Quote Author
 *
 * @author pedromendes
 */
public enum QuoteAuthor {

	/**
	 * "I am a Jedi, like my father before me" -
	 * http://starwars.wikia.com/wiki/Luke_Skywalker
	 */
	LUKE("Luke Skywalker", "luke.jpg"),

	/**
	 * "Anakin Skywalker was a Force-sensitive Human male who served the Galactic Empire as the Sith Lord Darth Vader"
	 * http://starwars.wikia.com/wiki/Darth_Vader
	 */
	DARTH_VADER("Darth Vader", "darth.jpg"),

	/**
	 * "Yoda was one of the most renowned and powerful Jedi Masters in galactic history"
	 * http://starwars.wikia.com/wiki/Yoda
	 */
	YODA("Yoda", "yoda.jpg"),

	/**
	 * "Han Solo was a male Human smuggler from the manufacturing planet Corellia who achieved galactic fame as a member of the Rebel Alliance"
	 * http://starwars.wikia.com/wiki/Han_Solo/Legends
	 */
	HAN_SOLO("Han Solo", "hansolo.jpg");

	/**
	 * XML identifiers
	 */
	private static final String LUKE_XML_IDENTIFIER = "luke";
	private static final String DARTH_VADER_XML_IDENTIFIER = "darthVader";
	private static final String YODA_XML_IDENTIFIER = "yoda";
	private static final String HAN_SOLO_XML_IDENTIFIER = "hanSolo";

	/**
	 * Author's name
	 */
	private String name;

	/**
	 * Autho's icon - used on build result page.
	 */
	private String icon;

	/**
	 * Constructor using name, and icon
	 * 
	 * @param name
	 * @param icon
	 */
	QuoteAuthor(String name, String icon) {
		this.name = name;
		this.icon = icon;
	}

	/**
	 * Return author's name
	 * 
	 * @return author's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return author's icon
	 * 
	 * @return author's icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * Return author accordingly to his name.
	 */
	public static QuoteAuthor get(String name) {
		if (LUKE_XML_IDENTIFIER.equals(name)) {
			return LUKE;
		} else if (DARTH_VADER_XML_IDENTIFIER.equals(name)) {
			return DARTH_VADER;
		} else if (YODA_XML_IDENTIFIER.equals(name)) {
			return YODA;
		} else if (HAN_SOLO_XML_IDENTIFIER.equals(name)) {
			return HAN_SOLO;
		}
		return null;
	}

}
