package goznauk.pl_in_java.mid_term.entry.mapmaker;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by goznauk on 2014. 8. 11..
 */
public class MapMakerModel {
    private int width, height;
    private int[][] mapInfo;

    public void init(int width, int height) {
        this.width = width;
        this.height = height;

        mapInfo = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setMapInfo(int x, int y, int value) {
        mapInfo[y][x] = value;
    }

    public int[][] getMapInfo() {
        return mapInfo;
    }

    public void saveAsCsv(String path) {
        try {
            File csv = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv));

            for(int[] i : mapInfo) {
                String line = "";
                for(int j : i) {
                    line += j + ",";
                }
                line = line.substring(0, line.length()-1);
                bw.write(line + "\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printConsole() {
        for(int[] i : mapInfo) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
