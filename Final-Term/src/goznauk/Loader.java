package goznauk;

import java.io.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by goznauk on 2014. 9. 26..
 */
public class Loader {
    String path = "./passenger_list.csv";
    public PriorityQueue<Passenger> inputQueue;
    HashMap<Integer, Passenger> passengerMap;


    public HashMap<Integer, Passenger> load() {
        inputQueue = new PriorityQueue<Passenger>(60, new Comparator<Passenger>() {
            @Override
            public int compare(Passenger o1, Passenger o2) {
                if(o1.id > o2.id) return 1;
                else if(o1.id < o2.id) return -1;
                else return 0;
            }
        });

        passengerMap = new HashMap<Integer, Passenger>();

        try {
            File csv = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";
            br.readLine();

            while ((line = br.readLine()) != null) {
             //   System.out.println(line);
                // -1 is for Read Blank after last ','
                String[] token = line.split(",", -1);
                if(token.length == 7) {
                    Passenger p = new Passenger(Integer.parseInt(token[0]), Integer.parseInt(token[2]), Integer.parseInt(token[3]), STATION.parse(token[4]), STATION.parse(token[5]));
                    inputQueue.add(p);
                    passengerMap.put(p.getId(), p);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return passengerMap;
    }

}
