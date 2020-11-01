package project_2;

import java.lang.Math;

class PostfixEvaluation {
	
    public static void postfixEval(String postfix) throws Exception {
        String[] tokens = postfix.split(" ");
        StackedArrayList<Double> oppStack = new StackedArrayList<>();
        for (int i = 0; i < tokens.length; ++i) {
            // Checks if the first item in tokens is a number or operator
        	if (Character.isDigit(tokens[i].charAt(0))) {
                oppStack.push(Double.valueOf(tokens[i]));
            } else {
                double right = oppStack.pop();
                double left = oppStack.pop();
                // Determines the operator do know how to evaluate
                if (tokens[i].equals("+")) {
                    oppStack.push(left + right);
                }
                if (tokens[i].equals("-")) {
                    oppStack.push(left - right);
                }
                if (tokens[i].equals("*")) {
                    oppStack.push(left * right);
                }
                if (tokens[i].equals("/")) {
                    //Catches if user attempts to divide by zero
                    if (right == 0) {
                        System.out.println("Attempted to divide by zero.");
                        return;
                    } else {
                        oppStack.push(left / right);
                    }
                }
                if (tokens[i].equals("%")) {
                	oppStack.push(left % right);
                }
                if (tokens[i].equals("^")) {
                    oppStack.push(Math.pow(left, right));
                }
                // Comparison operators
                if (tokens[i].equals(">")) {
                    if (left > right) {
                        oppStack.push(1.0);
                    } else {
                        oppStack.push(0.0);
                    }
                }
                if (tokens[i].equals(">=")) {
                    if (left >= right) {
                        oppStack.push(1.0);
                    } else {
                        oppStack.push(0.0);
                    }
                }
                if (tokens[i].equals("<")) {
                    if (left < right) {
                        oppStack.push(1.0);
                    } else {
                        oppStack.push(0.0);
                    }
                }
                if (tokens[i].equals("<=")) {
                    if (left <= right) {
                        oppStack.push(1.0);
                    } else {
                        oppStack.push(0.0);
                    }
                }
                // Equality Comparison
                if (tokens[i].equals("==")) {
                    if (left == right) {
                        oppStack.push(1.0);
                    } else {
                        oppStack.push(0.0);
                    }
                }
                if (tokens[i].equals("!=")) {
                    if (left != right) {
                        oppStack.push(1.0);
                    } else {
                        oppStack.push(0.0);
                    }
                }
                // Logical and Comparison
                if (tokens[i].equals("&&")) {
                    if (left == 1.0 && right == 1.0) {
                        oppStack.push(1.0);
                    } else {
                        oppStack.push(0.0);
                    }
                }
                // Logical or Comparison
                if (tokens[i].equals("||")) {
                    if (left == 1.0 || right == 1.0) {
                        oppStack.push(1.0);
                    } else {
                        oppStack.push(0.0);
                    }
                }
            }
        }
        // Converts the double value to Int to return
        int value = oppStack.pop().intValue();
       	System.out.println(value);
    }
}