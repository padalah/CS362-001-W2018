package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import java.io.Console;

import static org.junit.Assert.*;
public class ApptTest {
	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test01() throws Throwable {
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
		// assertions
		assertTrue(appt.getValid());
		assertEquals(21, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());
	}

	@Test
	public void test02() throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 30;
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
		// assertions
		//assertTrue(appt.getValid());
		assertEquals(21, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(30, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());
	}

	//add more unit tests as you needed
	@Test
	public void test03() throws Throwable {
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
		assertFalse(appt.isRecurring());
		int[] recurDays = null;
		int recurBy = 0;
		int recurIncrement = 5;
		int recurNumber = -1;
		appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		assertNotEquals(null, appt.getRecurDays());
		assertTrue(appt.isRecurring());
		assertEquals("	1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party." +
				"\n", appt.toString());
		appt.setStartHour(10);
		assertEquals("	1/15/2018 at 10:30am ,Birthday Party, This is my birthday party." +
				"\n", appt.toString());
		appt.setStartHour(11);
		assertEquals("	1/15/2018 at 11:30am ,Birthday Party, This is my birthday party." +
				"\n", appt.toString());
		//assertEquals(0, appt.getRecurDays());
		assertEquals(0, appt.getRecurBy());
		assertEquals(5, appt.getRecurIncrement());
		assertEquals(-1, appt.getRecurNumber());
		int[] recurDays1 = {1, 3};
		appt.setRecurrence(recurDays1, recurBy, recurIncrement, recurNumber);
		assertNotEquals(0, appt.getRecurDays());
	}

	@Test
	public void test04() throws Throwable {
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
		appt.setStartHour(25);
		assertEquals(25, appt.getStartHour());
		appt.setStartHour(-1);
		assertEquals(-1, appt.getStartHour());
		appt.setStartHour(9);
		appt.setStartMinute(60);
		assertEquals(60, appt.getStartMinute());
		appt.setStartMinute(-1);
		assertEquals(-1, appt.getStartMinute());
		appt.setStartMinute(30);
		appt.setStartDay(45);
		assertEquals(45, appt.getStartDay());
		appt.setStartDay(-1);
		assertEquals(-1, appt.getStartDay());
		appt.setStartMonth(01);
		assertEquals(01, appt.getStartMonth());
		appt.setStartYear(1885);
		appt.setDescription(null);
		appt.setTitle(null);
		assertEquals(1885, appt.getStartYear());
		assertEquals("", appt.getDescription());
		assertEquals("", appt.getTitle());
		assertNull(appt.toString());
		Appt appt1 = new Appt(0, 65, 45, 12, 1885, "we are awesome", "awesome");
	}

	@Test
	public void test05() throws Throwable {
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
		appt.setStartHour(-1);
		assertEquals(false, appt.getValid());
	}

	@Test
	public void test06() throws Throwable {
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
		appt.setStartMinute(-1);
		assertEquals(false, appt.getValid());
	}

	@Test
	public void test07() throws Throwable {
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
		appt.setStartDay(-1);
		assertEquals(false, appt.getValid());
	}
	//appt.setStartMonth(0);
	//assertEquals(false,appt.getValid());

	@Test
	public void test08() throws Throwable {
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
		appt.setStartYear(18850);
		assertEquals(true, appt.getValid());
	}

	@Test
	public void test09() throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 05;
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
		int startHour1 = 20;
		int startMinute1 = 15;
		int startDay1 = 5;
		int startMonth1 = -9;
		int startYear1 = 2015;
		String title1 = "Birthday Party";
		String description1 = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		try {
			Appt appt1 = new Appt(startHour1,
					startMinute1,
					startDay1,
					startMonth1,
					startYear1,
					title1,
					description1);
			assertEquals(true, appt.getValid());
		} catch (Exception e) {
			System.err.println("error");
//			continue;
		}
		Appt appt1 = new Appt(startHour1,
				startMinute1,
				startDay1,
				1,
				startYear1,
				title1,
				description1);
		assertEquals(33, appt.compareTo(appt1));
	}

	@Test
	public void test10() throws Throwable {
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
			assertFalse(appt.isRecurring());
			int[] recurDays = null;
			int recurBy = 3;
			int recurIncrement = 5;
			int recurNumber = -1;
			appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
			assertTrue(appt.isRecurring());
	}

	@Test
	public void test11() throws Throwable {
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
		assertFalse(appt.isRecurring());
		int[] recurDays = null;
		int recurBy = 2;
		int recurIncrement = 5;
		int recurNumber = -1;
		appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		assertEquals(2, appt.getRecurBy());
		assertTrue(appt.isRecurring());
	}

	@Test
	public void test12() throws Throwable {
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
		appt.setStartHour(0);
		assertTrue(appt.getValid());
		appt.setStartHour(23);
		assertTrue(appt.getValid());
		appt.setStartHour(20);
		appt.setStartMinute(0);
		assertTrue(appt.getValid());
		appt.setStartMinute(59);
		assertTrue(appt.getValid());
		appt.setStartMinute(30);
		appt.setStartDay(1);
		assertTrue(appt.getValid());
		appt.setStartDay(28);
		assertTrue(appt.getValid());
		appt.setStartDay(3);
		appt.setStartMonth(1);
		assertTrue(appt.getValid());
		appt.setStartMonth(12);
		assertTrue(appt.getValid());
		assertEquals(2,appt.getRecurBy());
		assertEquals(0,appt.getRecurNumber());
		assertEquals(0,appt.getRecurIncrement());
	}

	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void test13() throws Throwable {
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
		appt.setStartMonth(15);
		assertFalse(appt.getValid());
		//assertEquals(java.lang.ArrayIndexOutOfBoundsException, appt.getStartMonth());
	}


}