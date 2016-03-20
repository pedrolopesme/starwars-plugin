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
	LUKE("Luke Skywalker", "luke.jpg", "luke"),

	/**
	 * "Anakin Skywalker was a Force-sensitive Human male who served the Galactic Empire as the Sith Lord Darth Vader"
	 * http://starwars.wikia.com/wiki/Darth_Vader
	 */
	DARTH_VADER("Darth Vader", "darth.jpg", "darthVader"),

	/**
	 * "Yoda was one of the most renowned and powerful Jedi Masters in galactic history"
	 * http://starwars.wikia.com/wiki/Yoda
	 */
	YODA("Yoda", "yoda.jpg", "yoda"),

	/**
	 * "Han Solo was a male Human smuggler from the manufacturing planet Corellia who achieved galactic fame as a member of the Rebel Alliance"
	 * http://starwars.wikia.com/wiki/Han_Solo/Legends
	 */
	HAN_SOLO("Han Solo", "hansolo.jpg", "hanSolo");

	/**
	 * XML identifiers
	 */

	/**
	 * Author's name
	 */
	private String name;

	/**
	 * Autho's icon - used on build result page.
	 */
	private String icon;

	/**
	 * Plain xml's name
	 */
	private String xmlName;
	
	/**
	 * Constructor using name, icon, xmlName
	 * 
	 * @param name
	 * @param icon
	 * @param xmlName
	 */
	QuoteAuthor(String name, String icon, String xmlName) {
		this.name = name;
		this.icon = icon;
		this.xmlName = xmlName;
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
	 * Return author's xml name
	 * 
	 * @return author's xml name
	 */
	public String getXmlName() {
		return xmlName;
	}
	
	/**
	 * Return author accordingly to his name.
	 */
	public static QuoteAuthor get(String name) {
		if (LUKE.getXmlName().equals(name)) {
			return LUKE;
		} else if (DARTH_VADER.getXmlName().equals(name)) {
			return DARTH_VADER;
		} else if (YODA.getXmlName().equals(name)) {
			return YODA;
		} else if (HAN_SOLO.getXmlName().equals(name)) {
			return HAN_SOLO;
		}
		return null;
	}

}
