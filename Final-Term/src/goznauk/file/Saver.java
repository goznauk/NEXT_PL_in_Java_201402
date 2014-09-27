package goznauk.file;

import goznauk.data.Passenger;
import goznauk.data.STATION;

import java.io.*;
import java.util.HashMap;

/**
 * Created by goznauk on 2014. 9. 27..
 */
public class Saver {
    public static void SaveCsvFromHashMap(HashMap<Integer, Passenger> map) {
        String path = "./passenger_list_result.csv";

        try {
            File csv = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv));

            bw.write("Id, waited(forTicket), ticketed, waited(forTrain), arrived\n");

            for (int i = 1; map.get(i) != null; i++) {
                Passenger p =map.get(i);
                bw.write(p.getId() + ","
                        + p.getWaitingTicket() + ","
                        + (p.getArrived() + p.getWaitingTicket() + p.getTicketing()) + ","
                        + p.getWaitingTrain() + ","
                        + (p.getArrived() + p.getWaitingTicket() + p.getTicketing() + p.getWaitingTrain() + p.getMoving()) + "\n");
            }

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
