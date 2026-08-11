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
    private Event event;
    private Date date;

    @BeforeEach
    public void runBefore() {
        event = new Event("Hyrox: US Open has been added to competitions");
        date = Calendar.getInstance().getTime();
    }

    @Test
    public void testEvent() {
        assertEquals("Hyrox: US Open has been added to competitions", event.getDescription());
        assertEquals(date, event.getDate());
    }

    @Test
    public void testToString() {
        assertEquals(date.toString() + "\n" + "Hyrox: US Open has been added to competitions", event.toString());
    }
}
