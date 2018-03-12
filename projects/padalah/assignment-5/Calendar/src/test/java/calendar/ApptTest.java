package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

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
		int[] recurDays = null;
		int recurBy = 0;
		int recurIncrement = 5;
		int recurNumber = -1;
		appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		assertTrue(appt.isRecurring());
		assertEquals("	1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party." +
				"\n", appt.toString());
		//assertEquals(0, appt.getRecurDays());
		assertEquals(0,appt.getRecurBy());
		assertEquals(5,appt.getRecurIncrement());
		assertEquals(-1,appt.getRecurNumber());
		int[] recurDays1 = {1,3};
		appt.setRecurrence(recurDays1, recurBy, recurIncrement, recurNumber);
		//assertEquals(0, appt.getRecurDays());
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
		assertEquals(25,appt.getStartHour());
		appt.setStartHour(-1);
		assertEquals(-1,appt.getStartHour());
		appt.setStartHour(9);
		appt.setStartMinute(60);
		assertEquals(60,appt.getStartMinute());
		appt.setStartMinute(-1);
		assertEquals(-1,appt.getStartMinute());
		appt.setStartMinute(30);
		appt.setStartDay(45);
		assertEquals(45,appt.getStartDay());
		appt.setStartDay(-1);
		assertEquals(-1,appt.getStartDay());
		appt.setStartMonth(01);
		assertEquals(01,appt.getStartMonth());
		appt.setStartYear(1885);
		appt.setDescription(null);
		appt.setTitle(null);
		assertEquals(1885,appt.getStartYear());
		assertEquals("", appt.getDescription());
		assertEquals("",appt.getTitle());
		assertNull(appt.toString());
		Appt appt1 = new Appt(0,65,45,12,1885, "we are awesome", "awesome");
	}
}
