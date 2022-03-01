public class LongTask extends Thread {
	
	private SharedResults sharedData;
	private StringBuffer inputData;
	private char target;
	
	public LongTask (SharedResults sharedData, StringBuffer inputData, char target) {
		
		super("Thread_"+target+" ");
		this.sharedData = sharedData;
		this.inputData = inputData;
		this.target = target;
		
	}
	
	public void run() {
		
		System.out.println("Thread Thread_"+target+ " running");
		int targetCount = 0;
		for (int i = 0; i < inputData.length(); i++) {
	
			if (inputData.charAt(i) == target) {
				targetCount++;
			}
		}
		
		ResultsEntry mm = new ResultsEntry(targetCount, target);
		
		sharedData.addToResults(mm);
		
		
	}
	
	
}





