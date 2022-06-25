package appointment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.*;

public class AppointmentService {
    private String uniqueID;
    private List<Appointment> appointments = new ArrayList<>();

    public void newAppointment(Date appointmentDate, String appointmentDescription) {
        Appointment appointment = new Appointment(newUniqueID(), appointmentDate, appointmentDescription);
        appointments.add(appointment);
    }

    public void deleteAppointment(String id) throws Exception {
        appointments.remove(appointmentSearch(id));
    }

    public void changeAppointmentDate(String id, Date appointmentDate) throws Exception {
        appointmentSearch(id).setAppointmentDate(appointmentDate);
    }

    public void changeAppointmentDescription(String id, String appointmentDescription) throws Exception {
        appointmentSearch(id).setAppointmentDescription(appointmentDescription);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    private String newUniqueID() {
        return uniqueID = UUID.randomUUID().toString().substring(
            0, Math.min(toString().length(), 10));
    }

    private Appointment appointmentSearch(String id) throws Exception {
        int index = 0;
        while (index < appointments.size()) {
            if (id.equals(appointments.get(index).getAppointmentId())) {
                return appointments.get(index);
            }
            index++;
        }
        throw new Exception("The id could not be found");
    }
}