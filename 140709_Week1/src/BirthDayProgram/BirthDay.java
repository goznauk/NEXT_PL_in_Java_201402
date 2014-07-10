package BirthDayProgram;

public class BirthDay {
	private int mYear, mMonth, mDay;

	public BirthDay() {
		setYear(-1);
		setMonth(-1);
		setDay(-1);
	}
	
	public BirthDay(int year, int month, int day) {
		setDate(year, month, day);
	}
	
	public void print() {
		System.out.println(mYear + "." + mMonth + "." + mDay);
	}
	
	public void setYear(int year) {
		this.mYear = year;
	}
	
	public void setMonth(int month) {
		this.mMonth = month;
	}
	
	public void setDay(int day) {
		this.mDay = day;
	}
	
	public void setDate(int year, int month, int day) {
		this.mYear = year;
		this.mMonth = month;
		this.mDay = day;
	}
	
	public boolean checkValidate() {
		if (mYear<0) { return false; }

		if (mMonth<=0 || mMonth>=12) { return false; }
			
		if (mDay<0) { return false; }
		
		switch(mMonth) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return mDay<=31;
		case 4:
		case 6:
		case 9:
		case 11:
			return mDay<=30;
		case 2:
			if(mYear%4==0) {
				if(mYear%100==0 && mYear%400!=0) {
					return mDay<=28;
				}
				return mDay<=29;
			}
			return mDay<=28;
		default:
			return false;
		}
	}
}
