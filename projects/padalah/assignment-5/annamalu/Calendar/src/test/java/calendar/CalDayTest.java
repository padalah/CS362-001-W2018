package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	@Test
	public void test01()  throws Throwable  {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		Appt appt1 = new Appt(15,30,15,01,2018,"hi", "hi test");
		Appt appt2 = new Appt(22,30,15,01,2018,"hi2", "hi test2");
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		CalDay cal= new CalDay (today);
		CalDay calnull = new CalDay ();
		assertTrue(cal.isValid());
		cal.iterator();
		calnull.iterator();
		//FAILED HERE:
		assertEquals(1, cal.getMonth());
		assertEquals(thisDay, cal.getMonth());
		assertNotEquals(thisMonth, cal.getMonth());
		assertEquals(2018,cal.getYear());
		assertEquals(thisDay,cal.getDay());
		cal.addAppt(appt);
		cal.addAppt(appt1);
		cal.addAppt(appt2);
		cal.addAppt(appt);
		calnull.toString();
	}
	@Test
	public void test02()  throws Throwable  {
		int startHour = 25;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		Appt appt1 = new Appt(9,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar faketoday = new GregorianCalendar(thisYear,thisMonth,32);
		CalDay cal= new CalDay (today);
		CalDay cal1= new CalDay (faketoday);
		cal.addAppt(appt);
		cal.addAppt(appt1);
		cal.toString();
		cal1.toString();
	}
}