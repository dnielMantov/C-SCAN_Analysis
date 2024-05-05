package cscan.code;

import java.util.ArrayList;

import utils.Utils;

public class CSCAN {

	public void run(ArrayList<Integer> request, int head) {
		int seekOperationsCount = 0;

		ArrayList<Integer> seekSequence = new ArrayList<>();
		
		int lastSector = head;
		for (int i = lastSector + 1; i < 200; i++) {
			if (i == 199) {
				seekSequence.add(i);
				seekOperationsCount += Math.abs(lastSector - i);
				lastSector = i;
				i = 0;
				seekOperationsCount += Math.abs(lastSector - i);
				seekSequence.add(i);
				lastSector = i;
			}
			
			if (request.contains(i) && !seekSequence.contains(i)) {
				seekSequence.add(i);
				request.remove((Integer) i);
				seekOperationsCount += Math.abs(lastSector - i);
				lastSector = i;
			}

			if (request.size() == 0)
				break;
		}

		Utils.formatReturn(seekOperationsCount, seekSequence);
	}

}
