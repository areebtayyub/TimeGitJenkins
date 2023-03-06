package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@Test
	public void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05:005");
		assertTrue("The seconds were not calculated "
				+ "properly", seconds==18305);
	}

	@Test
	public void testGetTotalSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class , 
				()-> {Time.getTotalSeconds("10:00");});
		
	}
	
	@Test
	public void testGetTotalSecondsBoundary() {
		int seconds = Time.getTotalSeconds("05:59:59:999");
		assertTrue("The seconds were not calculated "
				+ "properly", seconds==21599);
	}
	
	
	@Test
	public void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("13:20:20:005");
		assertTrue("The minutes were not calculated "
				+ "properly", minutes==20);
	}
	
	@Test
	public void testGetTotalMinutesBoundary() {
		int minutes = Time.getTotalMinutes("13:59:59:999");
		assertTrue("The minutes were not calculated "
				+ "properly", minutes==59);
	}
	
	@Test
	public void testGetTotalMinutesBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class , 
				()-> {Time.getTotalMinutes("10");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"06:00:00:000","06:30:30:005", "06:59:59:999"})
	public void testGetTotalHoursGood(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated "
				+ "properly", hours==6);
	}
	
	@Test
	public void testGetTotalHoursBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class , 
				()-> {Time.getTotalHours("a");});
	}
	
	@Test
	public void testGetSecondsGood() {
		int seconds = Time.getSeconds("12:40:13:005");
		assertTrue("The seconds were not calculated "
				+ "properly", seconds==13);
	}
	
	@Test
	public void testGetSecondsBoundary() {
		int seconds = Time.getSeconds("12:40:59:005");
		assertTrue("The seconds were not calculated "
				+ "properly", seconds==59);
	}
	
	@Test
	public void testGetSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class , 
				()-> {Time.getSeconds("19:00");});
	}
	
	@Test
	public void testGetMilliseconds() {
		int milliseconds = Time.getMilliseconds("12:05:05:005");
		assertTrue("The seconds were not calculated "
				+ "properly", milliseconds==5);
	}
	
	@Test
	public void testgetTotalMilliseconds() {
		int milliseconds = Time.getTotalMilliseconds("05:05:05:005");
		assertTrue("The seconds were not calculated "
				+ "properly", milliseconds==18305005);
	}

}
