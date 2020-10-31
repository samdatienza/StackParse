package project_2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		// File input {inputFile} and using {reader} to read from file.
		FileInputStream inputFile = new FileInputStream("expression.txt");
		Scanner reader = new Scanner(inputFile);
		
		while (reader.hasNext()) {
			// Will read from file and removes spaces of {expression} at the same time
			String expression = RemoveSpaces.removeSpaces(reader.nextLine());
			// Start parsing
		}
		
		// Closing {reader} and {inputFile}
		reader.close();
		inputFile.close();
	}
}
