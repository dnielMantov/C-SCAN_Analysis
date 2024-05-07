package src.cscan;

import java.util.ArrayList;
import java.util.Collections;

public class CSCAN {

	public double run(int sectorSize, int tracks, int sectorsPerTrack, int transferRate, double seekTime, double rotationTime, ArrayList<Integer> requests, int head) {
		Collections.sort(requests);
		double transferTime = (sectorSize * Math.pow(2, 10)) / (transferRate * Math.pow(2, 20));

		double totalSeekTime = 0;
		double totalRotationTime = 0;
		double totalTransferTime = 0;

		while (!requests.isEmpty()) {
			 int headTrack = head / sectorsPerTrack;
			 int nextSector = this.getNextRequestInCurrentTrack(head, sectorsPerTrack, requests);

            if (nextSector != -1) {
                totalRotationTime += this.updateTotalRotationTime(head, nextSector, sectorsPerTrack, rotationTime);
                totalTransferTime += transferTime;
				head = nextSector;
            }
            if (!requests.isEmpty() && headTrack < tracks - 1) {
                head += sectorsPerTrack;
                totalSeekTime += seekTime;
            }
            else if (!requests.isEmpty() && headTrack == tracks - 1) {
                head = head - (headTrack * sectorsPerTrack);
                totalSeekTime += seekTime * headTrack;
            }
        }
		return totalSeekTime + totalRotationTime + totalTransferTime;
	}

	private int getNextRequestInCurrentTrack(int head, int sectorsPerTrack, ArrayList<Integer> requests) {
		for (Integer request : requests) {
			if ((request / sectorsPerTrack) == (head / sectorsPerTrack)) {
				requests.remove(request);
				return request;
			}
		}
		return -1;
	}

	private double updateTotalRotationTime(int head, int nextSector, int sectorsPerTrack, double rotationTime) {
		if (head <= nextSector)
            return ((double) (nextSector - head) / sectorsPerTrack) * rotationTime;
		else
			return ((double) ((sectorsPerTrack - head % sectorsPerTrack) + nextSector % sectorsPerTrack) / sectorsPerTrack) * rotationTime;
	}

}
