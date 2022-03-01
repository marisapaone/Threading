

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		StringBuffer data = new StringBuffer();
		
		InputStreamReader inputStream = null;
		BufferedReader reader = null;
		
		try {
			URL urlObject = new URL("http://norvig.com/big.txt");
			URLConnection urlConnectionObject = urlObject.openConnection();
			
			int contentSize = urlConnectionObject.getContentLength();
			System.out.println("Input data length: " + contentSize);
			
			inputStream = new InputStreamReader(urlObject.openStream());
			reader = new BufferedReader(inputStream);
			String inputLine;
			
			while ((inputLine = reader.readLine()) != null) {
				
				data.append(inputLine + "\n");
				
			}
			for(int i = 0; i< data.length();i++) {
				char c = data.charAt(i);
				data.setCharAt(i, Character.toLowerCase(c));
				
			}
			
			
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e2) {
					// Exception closing stream or reader
			}
		}
		
		SharedResults sharedResults = new SharedResults();
		char letter = 'a';
		LongTask[] array = new LongTask[26];
		
		
		for (int i = 0; i < array.length ; i++) {
			LongTask test = new LongTask(sharedResults, data, letter);	
			array[i]=test;
			test.start();		
			letter++;	
		}	
		
		for (LongTask test : array) {
			try {		
				test.join();
				
				
				} catch (InterruptedException ex) {
				ex.printStackTrace();
				} 
			
		}			
		System.out.println("Character Count = " + sharedResults.getResult());	

	}
	
}
