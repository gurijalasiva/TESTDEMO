package com.test.csv.parser;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCSV1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println("start time : "+startTime);
		CSVUtil util = null;
		try{
			util = new CSVUtil("D:/CSV/REF_DP_CTE_GEOCODE_GRID.csv");
			
			List<Object> records = util.parseCSVFile();
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
		long endTime = System.nanoTime();
		long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
		System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");

	}

}
