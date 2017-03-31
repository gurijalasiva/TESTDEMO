package com.test.csv;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ParseCSVNio1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 long freeMemoryBefore = Runtime.getRuntime().freeMemory();
         System.out.println(freeMemoryBefore);
         long startTime = System.nanoTime();
         int lineC = 0;
         List<Object> data = new ArrayList<Object>();
		try{
			File file = new File("D:/CSV/REF_DP_CTE_GEOCODE_GRID.csv");
		    List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
		  
		    for (String line : lines) {
		        String[] array = line.split(",");
		       // System.out.println(array[0]);
		        data.add(line);
		        lineC++;
		    }
	    
		}catch (Exception ex){
			
		} finally{
			long freeMemoryAfter = Runtime.getRuntime().freeMemory();
            System.out.println(freeMemoryAfter);
            System.out.println("Total lines : "+lineC +" Object size : "+data);
            long endTime = System.nanoTime();
	        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
	        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
		}

	}

}
