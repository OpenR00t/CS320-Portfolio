package appointment;

import java.util.*;

public class Appointment {
    private String appointmentId;
    private Date appointmentDate;
    private String appointmentDescription;

    public Appointment(String appointmentId, Date appointmentDate, String appointmentDescription) {
    	Calendar c = Calendar.getInstance();	
        Date currentDate = c.getTime();
        
        if(appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid Appointment ID");
        }
        if(appointmentDate == null || appointmentDate.before(currentDate)) {
            throw new IllegalArgumentException("Invalid Appointment Date");
        }
        if(appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid Appointment Description");
        }
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentDescription = appointmentDescription;
    }

    //setters
    public void setAppointmentDate(Date appointmentDate) {
        Calendar c = Calendar.getInstance();	
        Date currentDate = c.getTime();
        
        if(appointmentDate == null || appointmentDate.before(currentDate)) {
            throw new IllegalArgumentException("Invalid Appointment Date");
        }
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        if(appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid Appointment Description");
        }
        this.appointmentDescription = appointmentDescription;
    }

    //getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }
}