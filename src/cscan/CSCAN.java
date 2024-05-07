package src.cscan;

import java.util.ArrayList;

public class CSCAN {

	public void run(int sectorSize, int tracks, int sectorsPerTrack, int transferRate, double seekTime, double rotationTime, ArrayList<Integer> requests, int head) {

		double transferTime = (sectorSize * Math.pow(2, 10)) / (transferRate * Math.pow(2, 20));

		double totalSeekTime = 0;
		double totalRotationTime = 0;
		double totalTransferTime = 0;

		int headTrack = head / sectorsPerTrack;
		for (int i = 0; i < requests.size(); i++) {
			int sector = requests.get(i);
			if (head < sector)
				continue;

			int sectorTrack = sector / sectorsPerTrack;

			if (headTrack < sectorTrack) {
				totalSeekTime += seekTime;
				head += sectorsPerTrack;
			} else if (headTrack > sectorTrack) {
				totalSeekTime += seekTime;
				head -= sectorsPerTrack;
			}
			headTrack = sectorTrack;

			totalRotationTime += ((double) Math.abs(head - sector) / sectorsPerTrack) * rotationTime;
			totalTransferTime += transferTime;

			head = sector;
			requests.remove(i);

			if (requests.isEmpty())
				break;

			if (headTrack < tracks - 1) {
				head += sectorsPerTrack;
			} else if (headTrack == tracks - 1) {
				i = 0;
				head = head - (headTrack * sectorsPerTrack);
				headTrack = head / sectorsPerTrack;
			}

		}

	}

}
