package edu.uoc.rsanchezs.ehairdressing.model;

import edu.uoc.rsanchezs.ehairdressing.model.Schedule;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AppointmentSchedule
 *
 */
@Entity
public class AppointmentSchedule extends Schedule implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Appointment> appointments;
	
	public AppointmentSchedule() {
		super();
	}   
	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
   
}
