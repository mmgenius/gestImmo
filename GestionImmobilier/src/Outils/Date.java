package Outils;

import java.util.GregorianCalendar;

public class Date {
	public static GregorianCalendar StringToCalendar(String s) throws Exception{
		try {
		GregorianCalendar gc;
		String[] daymonth = s.split("\\/");
		String[] yeartime = daymonth[2].split(",");
		String[] time = yeartime[1].split("h");
		
		int day = Integer.parseInt(daymonth[0]);
		int month = Integer.parseInt(daymonth[1]);
		int year = Integer.parseInt(yeartime[0]);
		int hour = Integer.parseInt(time[0]);
		int minute = Integer.parseInt(time[1]);
		gc = new GregorianCalendar(year, month, day, hour, minute);
		return gc;
		} catch (Exception e) {
			throw new Exception("Format de Date invalide. Necessite dd/mm/yyyy,hhhmm");
		}
	}
}
