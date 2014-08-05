package goznauk.pl_in_java.week4.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by goznauk on 2014. 8. 2..
 */
public class CsvReader {
    public static List<Student> getStudentFromCsv(String path) {
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            File csv = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";

            // pass the first line
            br.readLine();

            while ((line = br.readLine()) != null) {
                // -1 is for Read Blank after last ','
                String[] token = line.split(",", -1);
                students.add(new Student(token[0], Integer.parseInt(token[1]), token[2], Integer.parseInt(token[3]), Integer.parseInt(token[4])));
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
