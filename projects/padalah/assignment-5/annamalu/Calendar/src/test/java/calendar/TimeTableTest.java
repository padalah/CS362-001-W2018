package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.*;

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


	/**
	 * Random Test Generator  for TimeTable class.
	 */

		/**
		 * Generate Random Tests that tests TimeTable Class.
		 */
		private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */

		@Test
		public void randomtest()  throws Throwable  {
			long startTime = Calendar.getInstance().getTimeInMillis();
			long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

			System.out.println("Start testing...");

			try {
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {

					//LinkedList<Appt> listAppts = new LinkedList<Appt>();
					LinkedList<CalDay> calDays = new LinkedList<CalDay>();
					long randomseed = System.currentTimeMillis();
					Random random = new Random(randomseed);

					int startHour = ValuesGenerator.getRandomIntBetween(random, -10, 150);
					int startMinute = ValuesGenerator.getRandomIntBetween(random, -10, 150);
					int startDay = ValuesGenerator.RandInt(random);
					int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);

					int startHour2 = ValuesGenerator.getRandomIntBetween(random, -15, 150);
					int startMinute2 = ValuesGenerator.getRandomIntBetween(random, -15, 150);
					int startDay2 = ValuesGenerator.RandInt(random);
					int startMonth2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);

					int startYear = ValuesGenerator.RandInt(random);
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
							startDay,
							startMonth,
							startYear,
							title,
							description);
					Appt appt2 = new Appt(startHour2,
							startMinute2,
							startDay2,
							startMonth2,
							startYear,
							title,
							description);
					Appt appt3 = null;
				 /*int thisMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int thisYear = ValuesGenerator.RandInt(random);
				 int thisDay = ValuesGenerator.RandInt(random);*/
					Calendar rightnow = Calendar.getInstance();
					int thisMonth = rightnow.get(Calendar.MONTH) + 1;
					int thisYear = rightnow.get(Calendar.YEAR);
					int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
					//LinkedList<CalDay> calDays = ValuesGenerator.generateRandomCalDayLinkedList(random, thisYear, thisMonth, thisDay);
					GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
					GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
					tomorrow.add(Calendar.DAY_OF_MONTH, 1);
					calDays.add(new CalDay(today));
					int num=ValuesGenerator.getRandomIntBetween(random, 0, 1);
					LinkedList<Appt> listAppts = ValuesGenerator.generateRandomApptLinkedList(random, num);
					TimeTable timeTable=new TimeTable();
					if(listAppts==null){
						timeTable.deleteAppt(listAppts, appt);
					}
					else {
						listAppts.add(appt);
						listAppts.add(appt1);
						listAppts.add(appt2);
						listAppts.add(appt3);
						timeTable.deleteAppt(listAppts, appt);
						timeTable.deleteAppt(listAppts, appt1);
						timeTable.deleteAppt(listAppts, appt2);
						timeTable.deleteAppt(listAppts, appt3);
					}
					elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
					if ((iteration % 10000) == 0 && iteration != 0) {
						System.out.println("elapsed time 1: " + elapsed + " of " + TestTimeout);
					}
				}
			}
			catch(Exception e){

			}

			System.out.println("Done testing...");
		}

		@Test
		public void randomtest2()  throws Throwable  {
			long startTime = Calendar.getInstance().getTimeInMillis();
			long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

			System.out.println("Start testing...");

			try {
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {

					//LinkedList<Appt> listAppts = new LinkedList<Appt>();
					LinkedList<CalDay> calDays = new LinkedList<CalDay>();
					long randomseed = System.currentTimeMillis();
					Random random = new Random(randomseed);

					int startHour = ValuesGenerator.getRandomIntBetween(random, -10, 150);
					int startMinute = ValuesGenerator.getRandomIntBetween(random, -10, 150);
					int startDay = ValuesGenerator.RandInt(random);
					int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);

					int startHour2 = ValuesGenerator.getRandomIntBetween(random, -15, 150);
					int startMinute2 = ValuesGenerator.getRandomIntBetween(random, -15, 150);
					int startDay2 = ValuesGenerator.RandInt(random);
					int startMonth2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);

					int startYear = ValuesGenerator.RandInt(random);
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
				 /*int thisMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int thisYear = ValuesGenerator.RandInt(random);
				 int thisDay = ValuesGenerator.RandInt(random);*/
					Calendar rightnow = Calendar.getInstance();
					int thisMonth = rightnow.get(Calendar.MONTH) + 1;
					int thisYear = rightnow.get(Calendar.YEAR);
					int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
					//LinkedList<CalDay> calDays = ValuesGenerator.generateRandomCalDayLinkedList(random, thisYear, thisMonth, thisDay);
					GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
					GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
					tomorrow.add(Calendar.DAY_OF_MONTH, 1);
					calDays.add(new CalDay(today));
					int num=ValuesGenerator.getRandomIntBetween(random, 0, 1);
					LinkedList<Appt> listAppts = ValuesGenerator.generateRandomApptLinkedList(random, num);
					TimeTable timeTable=new TimeTable();
					if(listAppts==null){
						timeTable.deleteAppt(listAppts, appt);
					}
					else {
						listAppts.add(appt);
						timeTable.deleteAppt(listAppts, appt);
					}
					elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
					if ((iteration % 10000) == 0 && iteration != 0) {
						System.out.println("elapsed time 7: " + elapsed + " of " + TestTimeout);
					}
				}
			}
			catch(Exception e){

			}

			System.out.println("Done testing...");
		}

		@Test
		public void randomtest1()  throws Throwable {
			long startTime = Calendar.getInstance().getTimeInMillis();
			long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

			System.out.println(elapsed);
			System.out.println("Start testing...");

			try {
				if (elapsed < TestTimeout) {
					System.out.println("timeout");
				}
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {

					//LinkedList<Appt> listAppts = new LinkedList<Appt>();
					LinkedList<CalDay> calDays = new LinkedList<CalDay>();
					long randomseed = System.currentTimeMillis();
					System.out.println(" Seed:" + randomseed);
					Random random = new Random(randomseed);

					int startHour = ValuesGenerator.getRandomIntBetween(random, -10, 150);
					int startMinute = ValuesGenerator.getRandomIntBetween(random, -10, 150);
					int startDay = ValuesGenerator.RandInt(random);
					int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);

					int startHour1 = ValuesGenerator.getRandomIntBetween(random, 1, 22);
					int startMinute1 = ValuesGenerator.getRandomIntBetween(random, 1, 58);
					int startDay1 = ValuesGenerator.RandInt(random);
					int startMonth1 = ValuesGenerator.getRandomIntBetween(random, 1, 11);

					int startHour2 = ValuesGenerator.getRandomIntBetween(random, -15, 150);
					int startMinute2 = ValuesGenerator.getRandomIntBetween(random, -15, 150);
					int startDay2 = ValuesGenerator.RandInt(random);
					int startMonth2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);

					int startYear = ValuesGenerator.getRandomIntBetween(random, 2010, 2020);
					int startYear1 = ValuesGenerator.getRandomIntBetween(random, 2020, 2030);
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
							startDay,
							startMonth,
							startYear,
							title,
							description);
					Appt appt2 = new Appt(startHour2,
							startMinute2,
							startDay2,
							startMonth2,
							startYear,
							title,
							description);
					Appt appt3 = new Appt(startHour1,
							startMinute1,
							startDay1,
							startMonth1,
							startYear1,
							title,
							description);
					Appt appt4 = new Appt(startHour1,
							startMinute1,
							startDay1,
							startMonth1,
							startYear,
							title,
							description);
					Calendar rightnow = Calendar.getInstance();
					Appt appt5 = new Appt (14, 30, rightnow.get(Calendar.DAY_OF_MONTH)+1,
							rightnow.get(Calendar.MONTH) + 1, 2018, title, description);
				 /*int thisMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int thisYear = ValuesGenerator.RandInt(random);
				 int thisDay = ValuesGenerator.RandInt(random);*/
					int thisMonth = rightnow.get(Calendar.MONTH) + 1;
					int thisYear = rightnow.get(Calendar.YEAR);
					int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
					//LinkedList<CalDay> calDays = ValuesGenerator.generateRandomCalDayLinkedList(random, thisYear, thisMonth, thisDay);
					GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
					GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
					GregorianCalendar yesterday = (GregorianCalendar) today.clone();
					tomorrow.add(Calendar.DAY_OF_MONTH, 3);
					yesterday.add(Calendar.DAY_OF_MONTH, -3);
					calDays.add(new CalDay(today));
					int num = 1;
					LinkedList<Appt> listAppts = ValuesGenerator.generateRandomApptLinkedList(random, num);
					TimeTable timeTable = new TimeTable();
					int recurBy = ValuesGenerator.getRandomIntBetween(random, 1, 3);
					int recurIncrement = ValuesGenerator.getRandomIntBetween(random, 1, 100);
					int recurNumber = ValuesGenerator.getRandomIntBetween(random,-1, 30);
					int[] recurDays = ValuesGenerator.generateRandomArray(random, 7);
					appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
					appt3.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
					appt4.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
					appt5.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
					listAppts.add(appt);
					listAppts.add(appt1);
					listAppts.add(appt2);
					listAppts.add(appt3);
					listAppts.add(appt4);
					listAppts.add(appt5);
					timeTable.getApptRange(listAppts, today, tomorrow);
					try{
						timeTable.getApptRange(listAppts, today, yesterday);
					}
					catch(DateOutOfRangeException e){

					}
					elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
					if ((iteration % 10000) == 0 && iteration != 0) {
						System.out.println("elapsed time 5: " + elapsed + " of " + TestTimeout);
					}
				}
			} catch (Exception e) {

			}

			System.out.println("Done testing...");
		}

}