package src.sstf;

import src.utils.Utils;

public class RunSSTF {

	public static void main(String[] args) {

		SSTF sstf = new SSTF();
        
		int[] request = {105, 142, 80, 127, 70, 115, 166, 101}; 

		int head = 113;

		sstf.run(Utils.toArrayInteger(request), head);
		
	}

}
