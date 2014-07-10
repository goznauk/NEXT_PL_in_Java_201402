package BirthDayProgram;

import java.io.InputStreamReader;


public class BirthDayMain {

	public static void main(String[] args) {
		BirthDay day = new BirthDay();
		day.setYear(2000);
		day.setMonth(2);
		day.setDay(29);
		//day.print();
		System.out.println(day.checkValidate());  //true
		
		BirthDay day2 = new BirthDay(2014,7,10);
		//day2.print();
		System.out.println(day2.checkValidate()); //true
		
		
		BirthDay day3 = new BirthDay();
		day3.setDate(2100,2,29);
		System.out.println(day3.checkValidate()); //false
	}
}
