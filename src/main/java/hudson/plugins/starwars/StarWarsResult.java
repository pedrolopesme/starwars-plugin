package hudson.plugins.starwars;

import hudson.model.Result;

/**
 * Provides a Star Wars result to each Hudson result
 * 
 * @author pedromendes
 *
 */
public enum StarWarsResult {

	/**
	 * When the light side wins.
	 */
	SUCCESS("success"),
	
	/**
	 * Now Yoda become worried.
	 */
	ALERT("alert"),
	
	/**
	 * When there's a disturbing lack of faith.
	 */
	FAIL("fail");

	
	/**
	 * Result's description
	 */
	private String description;
	
	
	/**
	 * Return result's description
	 * 
	 * @return result's name
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Constructor using description
	 * 
	 * @param description
	 */
	StarWarsResult(String description) {
		this.description = description;
	}
	
	
	/**
	 * Gets the style corresponding to the build result.
	 * 
	 * @param the native hudson result
	 * @return the star wars result
	 */
	public static StarWarsResult get(Result result) {
		if (Result.SUCCESS.equals(result)) {
			return SUCCESS;
		} else if (Result.FAILURE.equals(result)) {
			return FAIL;
		}
		return ALERT;
	}

	/**
	 * Gets the style corresponding to its String representation
	 * 
	 * @param the string result presentation
	 * 
	 * @return the star wars result
	 */
	public static StarWarsResult get(String result) {
		if (SUCCESS.getDescription().equals("success")) {
			return SUCCESS;
		} else if (FAIL.getDescription().equals("fail")) {
			return FAIL;
		} else if (ALERT.getDescription().equals("alert")) {
			return ALERT;
		}
		return null;
	}
}