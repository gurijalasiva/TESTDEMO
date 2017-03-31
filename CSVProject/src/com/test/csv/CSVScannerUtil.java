package com.test.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CSVScannerUtil {
	
	
	public static void main(String[] args) {
		 
        long startTime = System.nanoTime();
        long freeMemoryBefore = Runtime.getRuntime().freeMemory();
        System.out.println(freeMemoryBefore);
        String filePath = "D:/CSV/REF_DP_CTE_GEOCODE_GRID.csv";
        parseCSVFile(filePath);
        long freeMemoryAfter = Runtime.getRuntime().freeMemory();
        System.out.println(freeMemoryAfter);
        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms"  );
    }
	
	public static List<Object> parseCSVFile(String filePath){
		List<Object> records = null;
		 try (Scanner sc = new Scanner(new File(filePath), "UTF-8")) {
	            int lines = 0;
	            records = new ArrayList<Object>();
	            while (sc.hasNextLine()) {
	                String line = sc.nextLine();
	               // String[] strArr = line.split(",");
	                String[] strArr = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
		            for(String str : strArr){
		            	//System.out.println(str);
		            }
	                // parse line
	               // System.out.println(line);
		            records.add(line);
		            lines++;
	            }
	           
	            System.out.println("Total lines : "+lines+" Total recrds :"+records.size() );
	            // note that Scanner suppresses exceptions
	            if (sc.ioException() != null) {
	                sc.ioException().printStackTrace();
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
		return records;		
	}

}
