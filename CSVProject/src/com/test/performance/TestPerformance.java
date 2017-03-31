package com.test.performance;

import java.io.BufferedReader;
import java.io.FileReader;

public class TestPerformance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			long start  = System.currentTimeMillis();
			int bufferSize = 8 * 1024;
			FileReader fileReader = new FileReader("D:/CSV/KX3480T.csv");
			BufferedReader bufferedReader = new BufferedReader(fileReader, bufferSize);
			System.out.println("Started to process the file");
			String line = null;
			int lineCnt = 0;
			while((line = bufferedReader.readLine())!= null){
				System.out.println(line);
				lineCnt++;
			}
			
			long end  = System.currentTimeMillis();
			System.out.println("Time taken : "+(end-start));
			System.out.println("Total lines : "+lineCnt);
			
			bufferedReader.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
		}

	}

}
