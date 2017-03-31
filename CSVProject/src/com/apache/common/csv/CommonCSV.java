package com.apache.common.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CommonCSV {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("D:/CSV/REF_DP_CTE_GEOCODE_GRID.csv");
		long startTime = System.nanoTime();
		parseCSV(file);
		 long endTime = System.nanoTime();
	        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
	        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms"  );
	}
	
	public static List<Object> parseCSV(File csvFile) throws IOException {
		//System.out.println("Inside parseCSV>>>>>");
		List<Object> data = new ArrayList<Object>();
		//Reader in = new FileReader("path/to/file.csv");
		Reader in = new FileReader(csvFile);
		//System.out.println("Reading file parseCSV>>>>>");
		Iterable<CSVRecord> records = (Iterable<CSVRecord>) CSVFormat.newFormat(',').EXCEL.withIgnoreEmptyLines(true).parse(in);
		//Iterable<CSVRecord> records = (Iterable<CSVRecord>) CSVFormat.EXCEL.parse(in);
		//System.out.println("Reading file parseCSV>>>>>Iterable>>>>>>>>");
		
	   for (CSVRecord record : records) {
		        for(int i=0; i<record.size();i++){
				System.out.print(record.get(i));
				
				}
		        
				System.out.println();
				data.add(record);
		}
		// How to read file in java line by line?
		
	   // System.out.println(data);
		return data;
	}

}
