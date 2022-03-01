//Marisa Paone


package cs520.hw6;

import java.util.ArrayList;
import java.util.Collection;


public class SharedResults {
	
	private Collection<ResultsEntry> results = null;
	
	public SharedResults() {
		results = new ArrayList<ResultsEntry>();
		
	}
	
	public synchronized void addToResults(ResultsEntry a) {
		results.add(a);
		
		System.out.println(Thread.currentThread().getName() + "is adding " + a);
		System.out.println("Cumulative Results are " + results);	
		
	}
	
	public synchronized int getResult() {
		
		int sum = 0;
		for (ResultsEntry e: results) {
			
			sum+= e.getCount();
			
		}
		
		return sum; 
	}
	
}
