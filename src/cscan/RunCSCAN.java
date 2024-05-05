package src.cscan;

import src.utils.Utils;

public class RunCSCAN {

    public static void main(String[] args) {
        
        CSCAN cscan = new CSCAN();

        int[] request = {64, 176, 9, 184, 104, 97, 26, 10};

        int head = 139;

        cscan.run(Utils.toArrayInteger(request), head);

    }

}
