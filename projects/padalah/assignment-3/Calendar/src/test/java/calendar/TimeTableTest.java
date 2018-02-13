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
		assertNotEquals(calDays, timeTable.getApptRange(listAppts, today, tomorrow));
	}

	/*@Test(expected = IllegalArgumentException.class)
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
		//int[] pv1 = {0,2};
		//int[] pv = {0,1,2,3};
		//assertEquals(4, timeTable.permute(listAppts,pv).size());
//		oldDays=timeTable.getApptRange(null, tomorrow, today);
// assertNull(oldDays);
		//timeTable.permute(listAppts,pv1);
	}*/


	@Test
	public void test03()  throws Throwable {
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		LinkedList<CalDay> oldDays = new LinkedList<CalDay>();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		LinkedList<Appt> listAppts1 = null;
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH) + 1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		GregorianCalendar nextDay = (GregorianCalendar) today.clone();
		TimeTable timeTable = new TimeTable();
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
				51,
				startMonth,
				startYear,
				title,
				description);
		listAppts.add(appt);
		assertNull(timeTable.deleteAppt(listAppts,appt));
	}

	@Test
	public void test04()  throws Throwable {
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		LinkedList<CalDay> oldDays = new LinkedList<CalDay>();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		LinkedList<Appt> listAppts1 = null;
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH) + 1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		GregorianCalendar nextDay = (GregorianCalendar) today.clone();
		nextDay.add(Calendar.DAY_OF_MONTH, -1);
		TimeTable timeTable = new TimeTable();
		//calDays.add(new CalDay(nextDay));
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
		Appt appt1 = new Appt(250,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		Appt appt2 = new Appt(startHour,
				startMinute,
				startDay + 1,
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
		Appt appt5 = new Appt(7,
				startMinute,
				startDay,
				2,
				startYear,
				title,
				description);
		int recurBy = 3;
		int recurIncrement = 5;
		int recurNumber = 3;
		int[] recurDays1 = {1, 3};
		int[] recurDays = new int[0];
		appt.setRecurrence(recurDays1, recurBy, recurIncrement, recurNumber);
		appt1.setRecurrence(recurDays1, 1, recurIncrement, recurNumber);
		appt2.setRecurrence(recurDays, 2, recurIncrement, recurNumber);
		appt3.setRecurrence(recurDays1, 5, recurIncrement, recurNumber);
		listAppts.add(appt);
		listAppts.add(appt1);
		listAppts.add(appt2);
		listAppts.add(appt3);
		calDays.add(new CalDay(today));
		assertNotEquals(calDays, (timeTable.getApptRange(listAppts, today, tomorrow)));
		assertNotNull(timeTable.getApptRange(listAppts, today, tomorrow));
		try{
			assertNull(timeTable.getApptRange(listAppts, today, nextDay));
		} catch (Exception e) {
			System.err.println("error");
		}
		assertNotNull(timeTable.deleteAppt(listAppts, appt));
		assertNull(timeTable.deleteAppt(listAppts, appt1));
		assertNull(timeTable.deleteAppt(listAppts,appt5));
	}

	@Test
	public void test05()  throws Throwable {
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		LinkedList<CalDay> oldDays = new LinkedList<CalDay>();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		LinkedList<Appt> listAppts1 = null;
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH) + 1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		GregorianCalendar nextDay = (GregorianCalendar) today.clone();
		nextDay.add(Calendar.DAY_OF_MONTH, -1);
		TimeTable timeTable = new TimeTable();
		//calDays.add(new CalDay(nextDay));
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
		int recurBy = 3;
		int recurIncrement = 5;
		int recurNumber = 3;
		int[] recurDays1 = {1, 3};
		int[] recurDays = new int[0];
		//appt.setRecurrence(recurDays1, recurBy, recurIncrement, recurNumber);
		listAppts.add(appt);
		assertNotEquals(calDays, (timeTable.getApptRange(listAppts, today, tomorrow)));
		try {
			assertNull(timeTable.getApptRange(listAppts1, today, tomorrow));
		}
		catch(Exception e){
			System.err.println("error");
		}
		//timeTable.getApptRange(listAppts, tomorrow, today);
	}

	@Test
	public void test06()  throws Throwable {
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		LinkedList<CalDay> oldDays = new LinkedList<CalDay>();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		LinkedList<Appt> listAppts1 = new LinkedList<Appt>();
		LinkedList<Appt> listAppts2 = new LinkedList<Appt>();
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH) + 1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		GregorianCalendar nextDay = (GregorianCalendar) today.clone();
		nextDay.add(Calendar.DAY_OF_MONTH, 5);
		TimeTable timeTable = new TimeTable();
		//calDays.add(new CalDay(nextDay));
		int startHour = 21;
		int startMinute = 30;
		int startDay = 150;
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
		Appt appt1 = new Appt(startHour,
				startMinute,
				15,
				startMonth,
				startYear,
				title,
				description);
		int recurBy = 3;
		int recurIncrement = 5;
		int recurNumber = -2;
		int[] recurDays1 = {1, 3};
		int[] recurDays = new int[0];
		appt1.setRecurrence(recurDays1, recurBy, recurIncrement, recurNumber);
		listAppts.add(appt);
		listAppts2.add(appt1);
		calDays=timeTable.getApptRange(listAppts, today, tomorrow);
		assertNotNull(timeTable.getApptRange(listAppts2, today, nextDay));
		assertEquals(listAppts1, calDays.get(0).getAppts());
		//assertEquals(listAppts2, oldDays);

	}

	@Test
	public void test07()  throws Throwable {
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		LinkedList<CalDay> oldDays = new LinkedList<CalDay>();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		LinkedList<Appt> listAppts1 = new LinkedList<Appt>();
		LinkedList<Appt> listAppts2 = new LinkedList<Appt>();
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH) + 1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		GregorianCalendar today1 = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow1 = (GregorianCalendar) today.clone();
		tomorrow1.add(Calendar.DAY_OF_MONTH, -1);
		GregorianCalendar nextDay = (GregorianCalendar) today.clone();
		nextDay.add(Calendar.DAY_OF_MONTH, 5);
		TimeTable timeTable = new TimeTable();
		//calDays.add(new CalDay(nextDay));
		int startHour = 21;
		int startMinute = 30;
		int startDay = 17;
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
		Appt appt1 = new Appt(startHour,
				startMinute,
				15,
				startMonth,
				startYear,
				title,
				description);
		Appt appt2 = new Appt(startHour,
				startMinute,
				17,
				startMonth,
				startYear,
				title,
				description);
		int recurBy = 3;
		int recurIncrement = 5;
		int recurNumber = -2;
		int[] recurDays1 = {1, 3};
		int[] recurDays = new int[0];
		appt1.setRecurrence(recurDays1, recurBy, recurIncrement, recurNumber);
		listAppts2.add(appt1);
		listAppts2.add(appt2);
		assertEquals(1, timeTable.getApptRange(listAppts, today, tomorrow).size());
		//listAppts.add(appt2);
		assertEquals(2, listAppts2.size());
		int [] pv= {1,0};
		//try {
			assertEquals(15, timeTable.permute(listAppts2, pv).get(0).getStartDay());
			assertEquals(17, timeTable.permute(listAppts2, pv).get(1).getStartDay());
		//}
		//catch (Exception e) {
			//System.err.println("error");
		//}
		//assertEquals(1,timeTable.getApptRange(listAppts, today1, today1).size());
	}

	@Test
	public void test08() throws Throwable{
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		Calendar rightnow = Calendar.getInstance();
		int thisMonth = rightnow.get(Calendar.MONTH) + 1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 3);
		TimeTable timeTable = new TimeTable();
		int startHour = 21;
		int startMinute = 30;
		int startDay = rightnow.get(Calendar.DAY_OF_MONTH);
		int startMonth = rightnow.get(Calendar.MONTH) + 1;
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
		Appt appt1 = new Appt (14, 30, rightnow.get(Calendar.DAY_OF_MONTH)+1,
				rightnow.get(Calendar.MONTH) + 1, 2018, title, description);
		assertEquals(0,listAppts.size());
		listAppts.add(appt);
		listAppts.add(appt1);
		assertEquals(2,listAppts.size());
		LinkedList <CalDay> calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		//LinkedList <Appt> apptresult = calDays.get(0).getAppts().get(0);
		assertEquals(appt,calDays.get(0).getAppts().get(0));
		assertEquals(appt1,calDays.get(1).getAppts().get(0));
	}

	@Test
	public void test09() throws Throwable{
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		Calendar rightnow = Calendar.getInstance();
		int thisMonth = rightnow.get(Calendar.MONTH) + 1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 7);
		TimeTable timeTable = new TimeTable();
		int startHour = 21;
		int startMinute = 30;
		int startDay = rightnow.get(Calendar.DAY_OF_MONTH);
		int startMonth = rightnow.get(Calendar.MONTH) + 1;
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
		Appt appt1 = new Appt (14, 30, rightnow.get(Calendar.DAY_OF_MONTH)+1,
				rightnow.get(Calendar.MONTH) + 1, 2018, title, description);
		assertEquals(0,listAppts.size());
		int [] recurDays = {0,1,2,3,4,5,6};
		int recurBy = 1;
		int recurIncrement=1;
		int recurNumber=7;
		appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		listAppts.add(appt);
		LinkedList <CalDay> calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		//for(int i=0; i<7; i++){
			assertEquals(appt, calDays.get(0).getAppts().get(0));
			assertEquals(appt, calDays.get(1).getAppts().get(0));
			assertEquals(appt, calDays.get(2).getAppts().get(0));
			assertEquals(appt, calDays.get(3).getAppts().get(0));
			assertEquals(appt, calDays.get(4).getAppts().get(0));
			//assertEquals(appt, calDays.get(5).getAppts().get(0));
			//assertEquals(appt, calDays.get(6).getAppts().get(0));
		//}
	}
}

