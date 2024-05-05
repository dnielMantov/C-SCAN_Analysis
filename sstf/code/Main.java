public class Main {

	public static void main(String[] args) {
		SSTF sstf = new SSTF();
        
        // request
		int[] request = {176, 79, 34, 60, 92, 11, 41, 114}; 

		int head = 50;

		sstf.run(request, head);
	}

}
