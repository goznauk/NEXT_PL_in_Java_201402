package goznauk.No6;

import java.io.*;
import java.io.InputStreamReader;

/**
 * Created by goznauk on 2014. 9. 24..
 */
public class InputStreamReaderMain {
    public static void main(String[] args) throws java.io.IOException {
        int i;
        java.io.InputStreamReader isr = new InputStreamReader(System.in);
        System.out.println("종료하기 위해서는 '끝'을 입력하시오");
        System.out.println("출력할 데이터를 입력하시오? ");
        while((i = isr.read()) != '끝') {
            System.out.print((char)i);
        }
    }
}
