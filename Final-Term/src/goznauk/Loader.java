package goznauk;

import java.io.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by goznauk on 2014. 9. 26..
 */
public class Loader {
    String path = "./passenger_list.csv";
    public PriorityQueue<Passenger> inputQueue;

    public Loader() {
        load();
    }

    public void load() {
        inputQueue = new PriorityQueue<Passenger>(60, new Comparator<Passenger>() {
            @Override
            public int compare(Passenger o1, Passenger o2) {
                if(o1.id > o2.id) return 1;
                else if(o1.id < o2.id) return -1;
                else return 0;
            }
        });

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
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
