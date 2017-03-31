package com.test.csv.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVUtil {
	
	final File file;
	
	public CSVUtil(String filePath){
		file = new File(filePath);
	}
	
	public List<Object> parseCSVFile(){
		List<Object> records = new ArrayList<Object>();
		try(Scanner scanner = new Scanner(file, "UTF-8")){
			 while (scanner.hasNextLine()) {
	                
	                String line = scanner.nextLine();
	                String[] strArr = line.split(",");
	                records.add(strArr);
			 }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return records;
	}
	
	public List<Object> getCSVFileRecords(String filePath){
		List<Object> records = new ArrayList<Object>();
		try(Scanner scanner = new Scanner(file, "UTF-8")){
			 while (scanner.hasNextLine()) {
	                
	                String line = scanner.nextLine();
	                String[] strArr = line.split(",");
	                records.add(strArr);
			 }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return records;
	}

}
