package mission_2;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DateCreatorTest {

	Calendar expectedCalendar;
	Date expectedDate;
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		this.expectedCalendar = Calendar.getInstance();
		expectedCalendar.clear();
		expectedCalendar.getTimeZone();
		expectedCalendar.set(1910, 12, 10, 11, 00);
		
		expectedDate = new Date(10, 12, 10, 11, 00);
	}

	@Test
	public void testSetDate() throws NoSuchFieldException, 
			SecurityException, IllegalArgumentException, 
			IllegalAccessException {
		//set date
		final DateCreator dateCreator = new DateCreator();
		dateCreator.setDate("1910 12 10\n11:00");

		//get value
		final Field field = dateCreator.getClass()
				                       .getDeclaredField("date");
		field.setAccessible(true);
		
		//assert
		assertEquals(field.get(dateCreator), this.expectedCalendar);
	}

	@Test
	public void testGetCalendar() throws NoSuchFieldException, 
	    	SecurityException, IllegalArgumentException, 
	    	IllegalAccessException {
		
		//set date
        final DateCreator dateCreator = new DateCreator();
        final Field field = dateCreator.getClass()
        		                       .getDeclaredField("date");
        field.setAccessible(true);
        field.set(dateCreator, this.expectedCalendar);
        
        //assert
        assertEquals(dateCreator.getCalendar(), this.expectedCalendar);
	}

	@Test
	public void testGetDate() throws NoSuchFieldException, 
			SecurityException, IllegalArgumentException, 
			IllegalAccessException {
		
		//set date
        final DateCreator dateCreator = new DateCreator();
        final Field field = dateCreator.getClass()
        		                       .getDeclaredField("date");
        field.setAccessible(true);
        field.set(dateCreator, this.expectedCalendar);
        
        //assert
        assertEquals(dateCreator.getDate(), this.expectedDate);
	}

}
