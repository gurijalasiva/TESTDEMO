package com.test.csv.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author SivaSankar.Gurijala This class is created for parsing large size of
 *         CSV file It should be able to read up to 1 GB file without any errors
 */
public class CommonCSVUtil {

	private Scanner scanner;

	/**
	 * @param filePath
	 * This constructor is accepting file path and creates the object
	 * @throws FileNotFoundException
	 * 
	 */
	public CommonCSVUtil(String filePath) throws FileNotFoundException {
		scanner = new Scanner(new File(filePath), "UTF-8");
	}

	
	/**
	 * This method returns the current line from the csv file  
	 * @return boolean
	 */
	public boolean hasNext() {
		return scanner.hasNextLine();
	}
	
	/**
	 * This method checks next line is available or not  
	 * @return boolean
	 */
	public String[] nextLine() {
		String line = scanner.nextLine();
		return line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
	}
	
	/**
	 * closing the scanner object
	 */
	public void close(){
		if(scanner != null){
		   scanner.close();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		CommonCSVUtil util = new CommonCSVUtil("D:/CSV/VKX4910T.csv");
		while(util.hasNext()){
			System.out.println(util.nextLine());
		}
		
		util.close();
	}

}
