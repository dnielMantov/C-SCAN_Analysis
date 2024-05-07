package src.cscan;

import java.util.ArrayList;

public class CSCAN {

	public void run(int sectorSize, int tracks, int sectorPerTrack, double seekTime, double rotationTime, double transferTime, ArrayList<Integer> requests, int head) {

		double totalSeekTime = 0;
		double totalRotationTime = 0;
		double totalTransferTime = 0;

		int headTrack = head / sectorPerTrack;
		for (int i = 0; i < requests.size(); i++) {
			int sector = requests.get(i);
			if (head < sector)
				continue;

			int sectorTrack = sector / sectorPerTrack;

			if (headTrack < sectorTrack) {
				totalSeekTime += seekTime;
				head += sectorPerTrack;
			} else if (headTrack > sectorTrack) {
				totalSeekTime += seekTime;
				head -= sectorPerTrack;
			}
			headTrack = sectorTrack;

			totalRotationTime += ((double) Math.abs(head - sector) / sectorPerTrack) * rotationTime;
			head = sector;
			requests.remove(i);

			if (i == requests.size()) {
				i = 0;
				head = head - (headTrack * sectorPerTrack);
			}
		}

	}

}
