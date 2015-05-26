package edu.uoc.rsanchezs.ehairdressing.service;

import static edu.uoc.rsanchezs.ehairdressing.model.Appointment.FIND_ALL;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import edu.uoc.rsanchezs.ehairdressing.model.Appointment;
import edu.uoc.rsanchezs.ehairdressing.model.AppointmentPK;
import edu.uoc.rsanchezs.ehairdressing.util.Loggable;

/**
 * Session Bean implementation class AppointmetService
 * @param <Appointment>
 */
@Named
@Stateless
@LocalBean
@Loggable
public class AppointmetService extends AbstractService<Appointment> implements Serializable{

 
	private static final long serialVersionUID = -1104337535933925152L;

	/**
     * Default constructor. 
     */
    public AppointmetService() {
       super(Appointment.class);
    }
    
    /**
	 * Method to persist an Appointment in the system
	 * @param appointment Appointment to persist
	 * @return appointment Appointment persisted
	 */
	public @NotNull Appointment createAppointment(@NotNull Appointment appointment) {
		em.persist(appointment);
		return appointment;
	}
	
	/**
	 * Method to update an Appointment in the system.
	 * @param appointment Appointment to update
	 * @return appointment Appointment updated
	 */
    public @NotNull Appointment updateAppointment(@NotNull Appointment appointment)
    {
       em.merge(appointment);
       return appointment;
    }
 
    /**
     * Method to remove an Appointment in the system.
     * @param appointment Appointment to remove
     */
    public void removeAppointment(@NotNull Appointment appointment)
    {
		em.remove(em.merge(appointment));

    }
    
    /**
     * Returns an Appointment by its composite primary key.
     * @param aPK The composite primary key
     * @return Appointment The appointment searched
     */
    public Appointment findByCompositePK (AppointmentPK aPK) {
    	return em.find(Appointment.class, aPK);
    	
    }
    
    /**
     * Method that returns all the Appointments stored in the system
     * @return List of Appointments
     */
    public List<Appointment> findAllAppointments(){
    	return findWithNamedQuery(FIND_ALL);
    }

}
