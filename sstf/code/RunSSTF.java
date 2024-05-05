import java.util.ArrayList;

public class RunSSTF {

	public static void main(String[] args) {
		SSTF sstf = new SSTF();
        
        // request
		int[] request = {105, 142, 80, 127, 70, 115, 166, 101}; 

		int head = 113;

		sstf.run(toArrayInteger(request), head);
	}

	private static ArrayList<Integer> toArrayInteger(int[] request) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < request.length; i++) {
            arr.add(request[i]);
        }
        return arr;
    }

}
