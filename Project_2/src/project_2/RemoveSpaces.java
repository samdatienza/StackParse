package project_2;

public class RemoveSpaces {
	/**
	 * Removes spaces from a string
	 * @param input: String that needs spaces to be removed
	 * @return: returns a String with no spaces
	 * @author Seth Wolf
	 */
	public static String removeSpaces(String input) {
		String[] exp = input.split(" ");
		String finalExpression = "";
		for (int i = 0; i < exp.length; i++) {
			finalExpression += exp[i];
		}
		return finalExpression;
	}
}
