package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

import appointment.AppointmentService;

class AppointmentServiceTest {
	Calendar future = Calendar.getInstance();
	Calendar future2 = Calendar.getInstance();

    @Test
    void addAppointmentTest() {
    	future.set(Calendar.MONTH, 5);
    	future.set(Calendar.DATE, 15);
    	future.set(Calendar.YEAR, 2030);
    	Date futureDate = future.getTime();

        AppointmentService service = new AppointmentService();
        service.newAppointment(futureDate, "Test Appointment Description");
        assertTrue(service.getAppointments().get(0).getAppointmentDate().equals(futureDate));
        assertTrue(service.getAppointments().get(0).getAppointmentDescription().equals("Test Appointment Description"));
    }

    @Test
    void deleteAppointmentTest() {
    	future.set(Calendar.MONTH, 5);
    	future.set(Calendar.DATE, 15);
    	future.set(Calendar.YEAR, 2030);
    	Date futureDate = future.getTime();

        AppointmentService service = new AppointmentService();
        service.newAppointment(futureDate, "Test Appointment Description");
        Assertions.assertThrows(Exception.class, () -> {
            service.deleteAppointment("01");
        });
        Assertions.assertAll( () -> {
            service.deleteAppointment(service.getAppointments().get(0).getAppointmentId());
        });
    }

    @Test
    void changeAppointmentTest() throws Exception {
    	future.set(Calendar.MONTH, 5);
    	future.set(Calendar.DATE, 15);
    	future.set(Calendar.YEAR, 2030);
    	Date futureDate = future.getTime();

    	future2.set(Calendar.MONTH, 5);
    	future2.set(Calendar.DATE, 15);
    	future2.set(Calendar.YEAR, 2040);
    	Date futureDate2 = future.getTime();
        
        AppointmentService service = new AppointmentService();
        service.newAppointment(futureDate, "Test Appointment Description");
        service.changeAppointmentDate(service.getAppointments().get(0).getAppointmentId(), futureDate2);
        service.changeAppointmentDescription(service.getAppointments().get(0).getAppointmentId(),"Appointment Desc test");
        assertEquals(futureDate2, service.getAppointments().get(0).getAppointmentDate());
        assertEquals("Appointment Desc test", service.getAppointments().get(0).getAppointmentDescription());
        assertThrows(Exception.class, () -> {
            service.changeAppointmentDate("01",futureDate2);
        });
        assertThrows(Exception.class, () -> {
            service.changeAppointmentDescription("01", "Appointment Desc test");
        });
    }
}
