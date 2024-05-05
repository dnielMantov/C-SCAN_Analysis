package src.cscan;

import java.util.ArrayList;

public class RunCSCAN {

    public static void main(String[] args) {
        
        CSCAN cscan = new CSCAN();

        int[] request = {64, 176, 9, 184, 104, 97, 26, 10};

        int head = 139;

        cscan.run(toArrayInteger(request), head);

    }

    private static ArrayList<Integer> toArrayInteger(int[] request) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < request.length; i++) {
            arr.add(request[i]);
        }
        return arr;
    }
    
}
