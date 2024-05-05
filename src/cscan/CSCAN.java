package src.cscan;

import java.util.ArrayList;

import src.utils.Utils;

public class CSCAN {

	public void run(ArrayList<Integer> request, int head) {
		ArrayList<Integer> seekSequence = new ArrayList<>();
		int seekDistance = 0;

		int lastSector = head;
		for (int i = lastSector + 1; i < 200; i++) {
			if (i == 199) {
				seekSequence.add(i);
				seekDistance += Math.abs(lastSector - i);
				lastSector = i;
				i = 0;
				seekDistance += Math.abs(lastSector - i);
				seekSequence.add(i);
				lastSector = i;
			}
			
			if (request.contains(i) && !seekSequence.contains(i)) {
				seekSequence.add(i);
				request.remove((Integer) i);
				seekDistance += Math.abs(lastSector - i);
				lastSector = i;
			}

			if (request.isEmpty())
				break;
		}

		Utils.formatReturn(seekDistance, seekSequence);
	}

}
