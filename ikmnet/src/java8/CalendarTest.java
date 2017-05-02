package java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		Date aDate = null;
		try {
			aDate = new SimpleDateFormat("yyyy-mm-dd").parse("2012-01-15");
			Calendar aCalendar = Calendar.getInstance();
			aCalendar.setTime(aDate);
			System.out.print(aCalendar.get(aCalendar.DAY_OF_MONTH) + "," + aCalendar.get(aCalendar.MONTH));
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate bDate = LocalDate.parse("2012-01-15", formatter);
			System.out.print(" " + bDate.getDayOfMonth() + "," + bDate.getMonthValue());
			
		} catch(ParseException ex) { System.out.println("ParseException " + ex);
		} catch(DateTimeParseException ex) { System.out.println("DateTimeParseException " + ex);
		}
	}
} 