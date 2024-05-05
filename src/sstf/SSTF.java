package src.sstf;

import java.util.ArrayList;

import src.utils.Utils;

public class SSTF {

	public void run(ArrayList<Integer> request, int head) {	
		ArrayList<Sector> sectors = toSectors(request);
		ArrayList<Integer> seekSequence = new ArrayList<>();
		int seekOperationsCount = 0;
		
		this.attDistanceToHead(sectors, head);

		for (int i = 0; i < request.size(); i++) {
			int nearSectorValue = this.getNearSector(sectors);
			this.setAccessedTrue(sectors, nearSectorValue);
			seekSequence.add(nearSectorValue);
			seekOperationsCount += Math.abs(head - nearSectorValue);
			head = nearSectorValue;
			this.attDistanceToHead(sectors, head);
		}

		Utils.formatReturn(seekOperationsCount, seekSequence);
	}

	private void attDistanceToHead(ArrayList<Sector> sectors, int head) {
		for (Sector sector : sectors) {
			sector.distanceToHead = Math.abs(head - sector.value);
		}
	}

	private int getNearSector(ArrayList<Sector> sectors) {
		int nearDistanceToHead = Integer.MAX_VALUE;
		int sectorValue = -1;
		for (Sector sector : sectors) {
			if (!sector.accessed && sector.distanceToHead < nearDistanceToHead) {
				nearDistanceToHead = sector.distanceToHead;
				sectorValue = sector.value;
			}
		}
		return sectorValue;
	}

	private void setAccessedTrue(ArrayList<Sector> sectors, int value) {
		for (Sector sector : sectors) {
			if (sector.value == value)
				sector.accessed = true;
		}
	}

	private ArrayList<Sector> toSectors(ArrayList<Integer> request) {
		ArrayList<Sector> nodes = new ArrayList<>();
		for (Integer value : request)
			nodes.add(new Sector(value));
		return nodes;
	}

}
