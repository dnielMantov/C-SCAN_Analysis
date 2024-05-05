package cscan.code;

import java.util.*;

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

		this.formatReturn(seekOperationsCount, seekSequence);
	}

	private void formatReturn(int seekOperationsCount, ArrayList<Integer> seekSequence) {
		System.out.println("Total number of seek operations:");
		System.out.println(seekOperationsCount);

		StringBuilder sequence = new StringBuilder();
		for (int i = 0; i < seekSequence.size(); i++) {
			if (i == seekSequence.size() - 1)
				sequence.append(seekSequence.get(i));
			else {
				sequence.append(seekSequence.get(i));
				sequence.append(" -> ");
			}
		}
		System.out.println("Seek Sequence:");
		System.out.println(sequence);
	}

}
