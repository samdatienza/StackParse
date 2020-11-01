package project_2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		// File input {inputFile} and using {reader} to read from file.
		FileInputStream inputFile = new FileInputStream("expression.txt");
		Scanner reader = new Scanner(inputFile);
		
		while (reader.hasNext()) {
			// Will read from file and adding spaces of {expression} at the same time if need be
			String expression = AddSpaces.addSpaces(reader.nextLine());
			expression = InfixToPostFix.infixToPostfix(expression);
			PostfixEvaluation.postfixEval(expression);
		}
		
		// Closing {reader} and {inputFile}
		reader.close();
		inputFile.close();
	}
}
