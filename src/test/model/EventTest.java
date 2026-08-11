package model;

import model.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the Event class
 * modeled from AlarmSystem
 */
public class EventTest {
	private Event e;
	private Date d;
	
	@BeforeEach
	public void runBefore() {
		e = new Event("Hyrox: US Open has been added to competitions");
		d = Calendar.getInstance().getTime(); 
	}
	
	@Test
	public void testEvent() {
		assertEquals("Hyrox: US Open has been added to competitions", e.getDescription());
		assertEquals(d, e.getDate());
	}

	@Test
	public void testToString() {
		assertEquals(d.toString() + "\n" + "Hyrox: US Open has been added to competitions", e.toString());
	}
}
