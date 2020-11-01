package project_2;

public class InfixToPostFix {
	/** Converts an infix expression to postfix
	 * Using Lecture 5 notes
	 * @param infix: an infix expression
	 * @return: postfix expression
	 * @throws Exception: stack's method pop() and peek()
	 */
	public static String infixToPostfix(String infix) throws Exception {
		String[] tokens = infix.split(" ");
		StringBuilder postfix = new StringBuilder();
		StackedArrayList<String> S = new StackedArrayList<>();
		for (int i = 0; i < tokens.length; ++i) {
			if (Character.isDigit(tokens[i].charAt(0))) { postfix.append(tokens[i]).append(' '); }
			else if (tokens[i].equals("(")) { S.push(tokens[i]); }
			else if (tokens[i].equals(")")) { 
				while (!S.peek().equals("(")) {
					postfix.append(S.pop()).append(' ');
				}
				S.pop();
			}
			else {
				while (!S.empty() && !S.peek().equals("(") && Precedence.prec(tokens[i]) <= Precedence.prec(S.peek())) {
					postfix.append(S.pop()).append(' ');
				}
				S.push(tokens[i]);
			}
		}
		while (!S.empty()) { postfix.append(S.pop()).append(" "); }
		return postfix.toString().trim();
	}
}
