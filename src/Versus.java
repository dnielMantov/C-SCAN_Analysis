package src;

import src.cscan.CSCAN;
import src.sstf.SSTF;
import src.utils.Utils;

import java.util.ArrayList;

public class Versus {

    public static void main(String[] args) {
        SSTF sstf = new SSTF();
        CSCAN cscan = new CSCAN();

        // Set request (between 0 ~ 199)
        int[] request = {105, 142, 80, 127, 70, 115, 166, 101};
        // Set head
        int head = 113;

        ArrayList<Integer> arr = Utils.toArrayInteger(request);
        System.out.println("==== SSTF Algorithm ====");
        sstf.run(arr, head);
        System.out.println("\n==== C-SCAN Algorithm ====");
//        cscan.run(arr, head);
    }

}
