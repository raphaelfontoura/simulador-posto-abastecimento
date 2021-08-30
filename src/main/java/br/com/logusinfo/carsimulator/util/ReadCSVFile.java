package br.com.logusinfo.carsimulator.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCSVFile {
	
	private static String[] values;

	public ReadCSVFile(String file) throws FileNotFoundException {
		try(Scanner scanner = new Scanner(new File("resoures", file))) {
			scanner.nextLine();
			while(scanner.hasNextLine()) {
				values = scanner.nextLine().split(";");
			}
		}
	}
	
	public String[] getValues() {
		return values;
	}

}
