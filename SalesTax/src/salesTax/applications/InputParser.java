package salesTax.applications;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import salesTax.exceptions.InvalidInputException;

public class InputParser {

	
	private ArrayList<InputData> inputDataList;

	public InputParser() {
		this.inputDataList = new ArrayList<InputData>();

	}

	private boolean isNumber(String fileInputString) {
		boolean isNumber = true;
		try {
			isNumber = (Double.parseDouble(fileInputString)) > 0;
		} catch (NumberFormatException e) {
			isNumber = false;
		}
		return isNumber;
	}

	public ArrayList<InputData> getInputData() throws InvalidInputException,
			NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String currentLine = null;
		int quantity = 0;
		double cost = 0;
		while ((currentLine = bufferedReader.readLine()) != null
				&& currentLine.length() != 0) {
			currentLine = currentLine.replaceAll("\\s+$", "");
			String[] array = currentLine.split(" ");

			if (isNumber(array[0]) && isNumber(array[array.length - 1])) {
				quantity = new Integer(array[0]).intValue();
				cost = new Double(array[array.length - 1]).doubleValue();
			} else {
				quantity = 0;
				cost = 0;
				throw new InvalidInputException();
			}

			String[] product = Arrays.copyOfRange(array, 1, array.length - 2);
			String productDescription = "";
			for (int index = 0; index < product.length; index++) {
				productDescription += " " + product[index].toLowerCase();
			}

			boolean isImported = productDescription.contains("imported")
					|| productDescription.contains("Imported");
			String productName = productDescription.replaceAll("[i,I]mported",
					"");
			inputDataList.add(new InputData(quantity, productName, isImported,
					cost));
		}

		return inputDataList;

	}
}
