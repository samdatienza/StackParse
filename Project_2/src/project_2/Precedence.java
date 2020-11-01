package project_2;

public class Precedence {
	
	/**
	 * Returns the precedence of an operator
	 * @param oper: operator
	 * @return: precedence of the operator
	 */
	public static int prec(String oper) {
		// Taken from Lecture 5. 
		// If operator is power
		if (oper.equals("^")) { return 7; }
		// If operator is multiplication or division
		else if (oper.equals("*") || oper.equals("/") || oper.equals("%")) { return 6; }
		// If operator is addition or subtraction
		else if (oper.equals("+") || oper.equals("-")) { return 5; }
		// If operator is a comparison
		else if (oper.equals(">") || oper.equals(">=") || oper.equals("<") || oper.equals("<=")) { return 4; }
		// If operator is equality comparison
		else if (oper.equals("==") || oper.equals("!=")) { return 3; }
		// If operator is logical and
		else if (oper.equals("&&")) { return 2; }
		// Finally, if operator is logical or
		else { return 1; }
	}
}
