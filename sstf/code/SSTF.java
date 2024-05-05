class node {

	int distanceToHead = 0; 
	boolean accessed = false;

}

public class SSTF {

	public void run(int[] request, int head) {
		if (request.length == 0)
			return;
			
		node[] nodes = new node[request.length]; 
		
		for (int i = 0; i < nodes.length; i++) 
            nodes[i] = new node();
		
		int seekOperationsCount = 0; 
		
		int[] seekSequence = new int[request.length + 1];

		for (int i = 0; i < request.length; i++) {
			
			seekSequence[i] = head;
				
			int index = this.findMinDistanceToHead(request, head, nodes);
			
			nodes[index].accessed = true;
			
			seekOperationsCount += nodes[index].distanceToHead; 
			
			head = request[index]; 
		}
		
		seekSequence[seekSequence.length - 1] = head;

		formatReturn(seekOperationsCount, seekSequence);
	}

	private void calculateDistance(int[] request, int head, node[] nodes) {
		for (int i = 0; i < request.length; i++)
			nodes[i].distanceToHead = Math.abs(request[i] - head);
	}

	private int findMinDistanceToHead(int[] request, int head, node[] nodes) {
		this.calculateDistance(request, head, nodes);

		int index = -1, minimum = Integer.MAX_VALUE;

		for (int i = 0; i < nodes.length; i++) {
			if (!nodes[i].accessed && minimum > nodes[i].distanceToHead) {
				minimum = nodes[i].distanceToHead;
				index = i;
			}
		}
		return index;
	}

	private void formatReturn(int seekOperationsCount, int[] seekSequence) {
		System.out.println("Total number of seek operations:");
		System.out.println(seekOperationsCount);

		StringBuilder sequence = new StringBuilder();
		for (int i = 0; i < seekSequence.length; i++) {
			if (i == seekSequence.length - 1)
				sequence.append(seekSequence[i]);
			else {
				sequence.append(seekSequence[i]);
				sequence.append(" -> ");
			}
		}
		System.out.println("Seek Sequence:");
		System.out.println(sequence);
	}

}
