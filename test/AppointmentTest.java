package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

import appointment.Appointment;

public class AppointmentTest {

	Calendar future = Calendar.getInstance();
	Calendar future2 = Calendar.getInstance();
	Calendar past = Calendar.getInstance();
	
    @Test
    void testAppointment() {
    	future.set(Calendar.MONTH, 5);
    	future.set(Calendar.DATE, 15);
    	future.set(Calendar.YEAR, 2030);
    	Date futureDate = future.getTime();

        Appointment appointment = new Appointment("01", futureDate, "Test Appointment Description");
        assertTrue(appointment.getAppointmentId().equals("01"));
        assertTrue(appointment.getAppointmentDate().equals(futureDate));
        assertTrue(appointment.getAppointmentDescription().equals("Test Appointment Description"));
    }
    
    @Test
    void testSetAppointment() {
    	future.set(Calendar.MONTH, 5);
    	future.set(Calendar.DATE, 15);
    	future.set(Calendar.YEAR, 2030);
        Date futureDate = future.getTime();

    	future2.set(Calendar.MONTH, 5);
    	future2.set(Calendar.DATE, 15);
    	future2.set(Calendar.YEAR, 2040);
    	Date futureDate2 = future2.getTime();

        Appointment appointment = new Appointment("01", futureDate, "Test Appointment Description");
        appointment.setAppointmentDate(futureDate2);
        appointment.setAppointmentDescription("Appointment Desc test");
        assertTrue(appointment.getAppointmentDate().equals(futureDate2));
        assertTrue(appointment.getAppointmentDescription().equals("Appointment Desc test"));
    }

    //testing intiail variable lengths
    @Test
    void testAppointmentIdLength() {
    	future.set(Calendar.MONTH, 5);
    	future.set(Calendar.DATE, 15);
    	future.set(Calendar.YEAR, 2030);
    	Date futureDate = future.getTime();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("00000000001", futureDate, "Test Appointment Description");
        });
    }

    @Test
    void testAppointmentDatePast() {
    	past.set(Calendar.MONTH, 5);
    	past.set(Calendar.DATE, 15);
    	past.set(Calendar.YEAR, 2015);
    	Date pastDate = past.getTime();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("01", pastDate, "Test Appointment Description");
        });
    }

    @Test
    void testAppointmentDescLength() {
    	future.set(Calendar.MONTH, 5);
    	future.set(Calendar.DATE, 15);
    	future.set(Calendar.YEAR, 2030);
    	Date futureDate = future.getTime();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("01", futureDate, "Test Appointment Descriptionxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        });
    }

    //testing setter variable lengths
    @Test
    void testSetAppointmentDatePast() {
    	past.set(Calendar.MONTH, 5);
    	past.set(Calendar.DATE, 15);
    	past.set(Calendar.YEAR, 2015);
        Date pastDate = past.getTime();

    	future.set(Calendar.MONTH, 5);
    	future.set(Calendar.DATE, 15);
    	future.set(Calendar.YEAR, 2030);
    	Date futureDate = future.getTime();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment("01", futureDate, "Test Appointment Description");
            appointment.setAppointmentDate(pastDate);
        });
    }

    @Test
    void testSetAppointmentDescLength() {
    	future.set(Calendar.MONTH, 5);
    	future.set(Calendar.DATE, 15);
    	future.set(Calendar.YEAR, 2030);
    	Date futureDate = future.getTime();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment("01", futureDate, "Test Appointment Description");
            appointment.setAppointmentDescription("Test Appointment Descriptionxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        });
    }

    //testing if variable is null
    @Test
    void testAppointmentIdNull() {
    	future.set(Calendar.MONTH, 5);
    	future.set(Calendar.DATE, 15);
    	future.set(Calendar.YEAR, 2030);
    	Date futureDate = future.getTime();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Test Appointment Description");
        });
    }

    @Test
    void testAppointmentDateNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("01", null, "Test Appointment Description");
        });
    }

    @Test
    void testAppointmentDescNull() {
    	future.set(Calendar.MONTH, 5);
    	future.set(Calendar.DATE, 15);
    	future.set(Calendar.YEAR, 2030);
    	Date futureDate = future.getTime();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("01", futureDate, null);
        });
    }

    //testing if setter variable is null
    @Test
    void testSetAppointmentDateNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	future.set(Calendar.MONTH, 5);
        	future.set(Calendar.DATE, 15);
        	future.set(Calendar.YEAR, 2030);
        	Date futureDate = future.getTime();

            Appointment appointment = new Appointment("01", futureDate, "Test Appointment Description");
            appointment.setAppointmentDate(null);
        });
    }

    @Test
    void testSetAppointmentDescNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	future.set(Calendar.MONTH, 5);
        	future.set(Calendar.DATE, 15);
        	future.set(Calendar.YEAR, 2030);
        	Date futureDate = future.getTime();
            
            Appointment appointment = new Appointment("01", futureDate, "Test Appointment Description");
            appointment.setAppointmentDescription(null);
        });
    }
}
