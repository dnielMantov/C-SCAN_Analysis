package src.cscan;

import src.utils.Utils;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class RunCSCAN {

    public static void main(String[] args) {

        CSCAN cscan = new CSCAN();
        DecimalFormat df = new DecimalFormat("#.##");

        // Generate X random requests within a specified range
        int base                = 0;
        int bounds              = 35;
        int number              = 20;

        ArrayList<Integer> requests = Utils.getRandomRequests(base, bounds, number);
        System.out.println("Requests:\n" + requests);

        // Select parameters
        int sectorSize          = 512;      // size of a sector in KB
        int tracks              = 3;        // number of tracks in one disk
        int sectorsPerTrack     = 12;       // number of sectors in one track
        int transferRate        = 100;      // transfer rate in MB
        double seekTime         = 4;        // in ms
        double rotationTime     = 2;        // in ms
        int initialSector       = 21;       // initial position of disk arm's head

        double totalTime = cscan.run(sectorSize, tracks, sectorsPerTrack, transferRate, seekTime, rotationTime, initialSector, requests);

        System.out.println(df.format(totalTime) + " ms");

    }

}
