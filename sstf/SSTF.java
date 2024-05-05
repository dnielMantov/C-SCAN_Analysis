class node {

	int distanceToHead = 0; 
	boolean accessed = false;

}

public class SSTF {

	public static void calculateDistance(int queue[], int head, node[] nodes) {
		for (int i = 0; i < queue.length; i++)
			nodes[i].distanceToHead = Math.abs(queue[i] - head);
	}

	public static int findMinDistanceToHead(node[] nodes) {
		int index = -1, minimum = Integer.MAX_VALUE;

		for (int i = 0; i < nodes.length; i++) {
			if (!nodes[i].accessed && minimum > nodes[i].distanceToHead) {
				minimum = nodes[i].distanceToHead;
				index = i;
			}
		}
		return index;
	}

	public static void shortestSeekTimeFirst(int request[], int head) {
		if (request.length == 0)
			return;
			
		node[] nodes = new node[request.length]; 
		
		for (int i = 0; i < nodes.length; i++) 
            nodes[i] = new node();
		
		int seek_operations_count = 0; 
		
		int[] seek_sequence = new int[request.length + 1];

		for (int i = 0; i < request.length; i++) {
			
			seek_sequence[i] = head;
			calculateDistance(request, head, nodes);
			
			int index = findMinDistanceToHead(nodes);
			
			nodes[index].accessed = true;
			
			seek_operations_count += nodes[index].distanceToHead; 
			
			head = request[index]; 
		}
		
		seek_sequence[seek_sequence.length - 1] = head; 
		
		System.out.println("Total number of seek operations = " + seek_operations_count);
													
		System.out.println("Seek Sequence is");
		
		for (int i = 0; i < seek_sequence.length; i++) 
			System.out.println(seek_sequence[i]);
	}

	public static void main(String[] args) {
		// request array
		int arr[] = {105, 142, 80, 127, 70, 115, 166, 101}; 
		shortestSeekTimeFirst(arr, 113);
	}
}
