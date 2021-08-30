package br.com.logusinfo.carsimulator.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCSVFile {
	
	private static String[] values;
	private String file;
	
	public ReadCSVFile() throws FileNotFoundException {
		try(Scanner scanner = new Scanner(new File("resoures", file))) {
			scanner.nextLine();
			while(scanner.hasNextLine()) {
				values = scanner.nextLine().split(";");
			}
		}
	}
	
	public static String[] getValues(String file) {
		return values;
	}

}
