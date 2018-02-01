package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	@Test
	public void test01()  throws Throwable  {
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		LinkedList<CalDay> oldDays = new LinkedList<CalDay>();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		LinkedList<Appt> listAppts1 = null;
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		GregorianCalendar nextDay = (GregorianCalendar)today.clone();
		TimeTable timeTable=new TimeTable();
		calDays.add(new CalDay(nextDay));
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
		Appt appt1 = new Appt(9,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		Appt appt2 = new Appt(startHour,
				startMinute,
				startDay+1,
				startMonth,
				startYear,
				title,
				description);
		Appt appt3 = new Appt(7,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		Appt appt4 = new Appt(35,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		int recurBy = 3;
		int recurIncrement = 5;
		int recurNumber = 3;
		int[] recurDays1 = {1,3};
		int[] recurDays = new int[0];
		appt.setRecurrence(recurDays1, recurBy, recurIncrement, recurNumber);
		appt1.setRecurrence(recurDays1, 1, recurIncrement, recurNumber);
		appt2.setRecurrence(recurDays, 2, recurIncrement, recurNumber);
		appt3.setRecurrence(recurDays1, 5, recurIncrement, recurNumber);
		listAppts.add(appt);
		listAppts.add(appt1);
		listAppts.add(appt2);
		listAppts.add(appt3);
		oldDays=timeTable.getApptRange(listAppts, today, tomorrow);
		int[] pv1 = {0,2,1,3};
		timeTable.permute(listAppts,pv1);
		assertNotSame(calDays, oldDays);
		//assertEquals(new DateOutOfRangeException ("Second date specified is not  before the first date specified."), timeTable.getApptRange(listAppts,tomorrow,today));
		timeTable.deleteAppt(listAppts,appt);
		timeTable.deleteAppt(listAppts,appt);
		timeTable.deleteAppt(listAppts1,appt);
		timeTable.deleteAppt(listAppts,appt4);
		timeTable.deleteAppt(listAppts,null);
		timeTable.deleteAppt(listAppts,appt2);
		timeTable.deleteAppt(listAppts,appt1);
		timeTable.deleteAppt(listAppts,appt2);
		assertNull(timeTable.deleteAppt(listAppts,appt3));
		//assertEquals(calDays, timeTable.getApptRange(listAppts, today, tomorrow));
	}
	@Test(expected = IllegalArgumentException.class)
	public void test02()  throws Throwable  {
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		LinkedList<CalDay> oldDays = new LinkedList<CalDay>();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		LinkedList<Appt> listAppts1 = null;
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		GregorianCalendar nextDay = (GregorianCalendar)today.clone();
		TimeTable timeTable=new TimeTable();
		calDays.add(new CalDay(nextDay));
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
		Appt appt1 = new Appt(9,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		Appt appt2 = new Appt(startHour,
				startMinute,
				startDay+1,
				startMonth,
				startYear,
				title,
				description);
		Appt appt3 = new Appt(7,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		Appt appt4 = new Appt(35,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		int recurBy = 3;
		int recurIncrement = 5;
		int recurNumber = 3;
		int[] recurDays1 = {1,3};
		int[] recurDays = new int[0];
		appt.setRecurrence(recurDays1, recurBy, recurIncrement, recurNumber);
		appt1.setRecurrence(recurDays1, 1, recurIncrement, recurNumber);
		appt2.setRecurrence(recurDays, 2, recurIncrement, recurNumber);
		appt3.setRecurrence(recurDays1, 5, recurIncrement, recurNumber);
		listAppts.add(appt);
		listAppts.add(appt1);
		listAppts.add(appt2);
		listAppts.add(appt3);
		oldDays=timeTable.getApptRange(listAppts, today, tomorrow);
		assertNotSame(calDays, oldDays);
		int[] pv = {0,2};
		//int[] pv1 = {0,2,1,3};
		timeTable.permute(listAppts,pv);
		//timeTable.permute(listAppts,pv1);
	}
//add more unit tests as you needed
}