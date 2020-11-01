package project_2;

public class AddSpaces {
	/**
	 * Will add spaces to the expression if need to.
	 * @param exp: the expression
	 * @return: an expression with spaces in between
	 * @author Seth Wolf
	 * Using https://stackoverflow.com/questions/7189293/add-spaces-between-the-characters-of-a-string-in-java#:~:text=Iterate%20over%20the%20characters%20of,space%20before%20appending%20each%20character.&text=Blow%20up%20your%20String%20into,a%20char%20by%20a%20space.
	 * as a reference
	 */
	public static String addSpaces(String exp) {
		// Using to rebuild the string with spaces
		StringBuilder newExp = new StringBuilder();
		for (int i = 0; i < exp.length(); i++) {
			// Checking if current is a space
			if (exp.charAt(i) == ' ') { continue; }
			newExp = newExp.append(exp.charAt(i));
			// When not to add a space
			// For logical and
			if (exp.charAt(i) == '&' && exp.charAt(i + 1) == '&') { continue; }
			// Logical or
			if (exp.charAt(i) == '|' && exp.charAt(i + 1) == '|') { continue; }
			// Comparsions
			if ((exp.charAt(i) == '>' || exp.charAt(i) == '<' || exp.charAt(i) == '=' || exp.charAt(i) == '!') && exp.charAt(i + 1) == '=') { continue; }
			if (i == exp.length() - 1) { break; }
			// For multiple digit numbers
			if (Character.isDigit(exp.charAt(i)) && Character.isDigit(exp.charAt(i + 1))) { continue; }
			newExp = newExp.append(" ");
		}
		return (newExp.toString());
	}
}
