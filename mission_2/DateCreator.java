package mission_2;

import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class DateCreator {

	public static void main(String[] args) {
		String date = "1910 12 12\n12:12";
		DateCreator d = new DateCreator();
		d.setDate(date);
		System.out.println(d.getCalendar());
	}
	
	public final static String ALL_SEPS = " .:\n-";
	Calendar date;
	public void setDate(String s) {
		StringTokenizer date = new StringTokenizer(s, ALL_SEPS);
		this.date = Calendar.getInstance();
		this.date.clear();
		this.date.getTimeZone();
		this.date.set(Integer.parseInt(date.nextToken()), 
				      Integer.parseInt(date.nextToken()), 
				      Integer.parseInt(date.nextToken()), 
				      Integer.parseInt(date.nextToken()), 
				      Integer.parseInt(date.nextToken()));
	}
	public Calendar getCalendar() {
		return this.date;
	}
	public Date getDate() {
		return new Date(this.date.getTimeInMillis());
	}
}
