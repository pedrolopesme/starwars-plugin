package hudson.plugins.starwars.quotes;

/**
 * Represents a Quote Author
 *
 * @author pedromendes
 */
public enum QuoteAuthor {

	/**
	 * "Admiral Ackbar was a Victory I-class Star Destroyer that served as the flagship of Admiral Nek Bwua'tu of the Galactic Alliance Defense Force following the Yuuzhan Vong War."
	 * - http://starwars.wikia.com/wiki/Admiral_Ackbar
	 */
	ACKBAR("Admiral Ackbar", "ackbar.png", "ackbar"),

	/**
	 * "C-3PO, sometimes spelled See-Threepio and often referred to as Threepio, was a bipedal, humanoid protocol droid designed to interact with organics, programmed primarily for etiquette and protocol."
	 * - http://starwars.wikia.com/wiki/C3PO
	 */
	C3PO("C3PO", "c3po.png", "c3po"),

	/**
	 * "Anakin Skywalker was a Force-sensitive Human male who served the Galactic Empire as the Sith Lord Darth Vader"
	 * http://starwars.wikia.com/wiki/Darth_Vader
	 */
	DARTH_VADER("Darth Vader", "darthvader.png", "darthVader"),

	/**
	 * "Han Solo was a male Human smuggler from the manufacturing planet Corellia who achieved galactic fame as a member of the Rebel Alliance"
	 * http://starwars.wikia.com/wiki/Han_Solo
	 */
	HAN_SOLO("Han Solo", "hansolo.png", "hanSolo"),

	/**
	 * "Leia Organa was a Force-sensitive human female who served as the princess of Alderaan, a member of the Imperial Senate, a leader in the Alliance to Restore the Republic and New Republic"
	 * http://starwars.wikia.com/wiki/Leia
	 */
	LEIA("Leia Organa", "leia.png", "leia"),

	/**
	 * "I am a Jedi, like my father before me" -
	 * http://starwars.wikia.com/wiki/Luke_Skywalker
	 */
	LUKE("Luke Skywalker", "luke.png", "luke"),

	/**
	 * "Obi-Wan Kenobi, later known as Ben Kenobi during his exile, was a Force-sensitive human male Jedi Master who served the Galactic Republic"
	 * - http://starwars.wikia.com/wiki/Obi-Wan_Kenobi
	 */
	OBI_WAN("Obi-Wan Kenobi", "obiWan.png", "obiWan"),

	/**
	 * "A Dark Lord of the Sith in the Order of the Sith Lords, recorded by history as the most powerful who had ever lived"
	 * - http://starwars.wikia.com/wiki/Palpatine
	 */
	PALPATINE("Palpatine", "palpatine.png", "palpatine"),

	/**
	 * "Trained by Count Dooku, Jinn was considered a maverick within the Jedi Order, one who did not always follow the Jedi Code"
	 * - http://starwars.wikia.com/wiki/Qui-Gon_Jinn
	 */
	QUI_GON("Qui-Gon Jinn", "quiGon.png", "quiGon"),

	/**
	 * "R2-D2, pronounced Artoo-Detoo and often referred to as Artoo, was an R2-series astromech droid manufactured by Industrial Automaton prior to 32 BBY"
	 * - http://starwars.wikia.com/wiki/R2d2
	 */
	R2D2("R2D2", "r2d2.png", "r2d2"),

	/**
	 * "Yoda was one of the most renowned and powerful Jedi Masters in galactic history"
	 * http://starwars.wikia.com/wiki/Yoda
	 */
	YODA("Yoda", "yoda.png", "yoda");

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
		if (ACKBAR.getXmlName().equals(name)) {
			return ACKBAR;
		} else if (C3PO.getXmlName().equals(name)) {
			return C3PO;
		} else if (DARTH_VADER.getXmlName().equals(name)) {
			return DARTH_VADER;
		} else if (HAN_SOLO.getXmlName().equals(name)) {
			return HAN_SOLO;
		} else if (LEIA.getXmlName().equals(name)) {
			return LEIA;
		} else if (LUKE.getXmlName().equals(name)) {
			return LUKE;
		} else if (OBI_WAN.getXmlName().equals(name)) {
			return OBI_WAN;
		} else if (PALPATINE.getXmlName().equals(name)) {
			return PALPATINE;
		} else if (QUI_GON.getXmlName().equals(name)) {
			return QUI_GON;
		} else if (R2D2.getXmlName().equals(name)) {
			return R2D2;
		} else if (YODA.getXmlName().equals(name)) {
			return YODA;
		}
		return null;
	}

}
