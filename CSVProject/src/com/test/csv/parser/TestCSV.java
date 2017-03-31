package com.test.csv.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCSV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		CommonCSVUtil util = null;
		try {
			List<Object> objects = new ArrayList<Object>();
			util = new CommonCSVUtil("D:/CSV/REF_DP_CTE_GEOCODE_GRID.csv");
			while (util.hasNext()) {
				objects.add(util.nextLine());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			util.close();
		}
		long endTime = System.nanoTime();
		long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
		System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
	}

}
