package edu.uoc.rsanchezs.ehairdressing.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import edu.uoc.rsanchezs.ehairdressing.model.Appointment;
import edu.uoc.rsanchezs.ehairdressing.model.Event;
import edu.uoc.rsanchezs.ehairdressing.service.AppointmetService;
import edu.uoc.rsanchezs.ehairdressing.service.EventService;

@Named
@ViewScoped
public class AppointmentScheduleView extends AbstractBean implements
		Serializable {

	private static final long serialVersionUID = 4894214699497372795L;


	@Inject
	private AppointmetService appointmentService;

	private ScheduleEvent event = new DefaultScheduleEvent();
	private ScheduleModel eventModel;
	private ScheduleModel lazyEventModel;
	private List<Appointment> listOfAppointments = new ArrayList<Appointment>();

	
	/**
	 * Default constructor
	 */
	public AppointmentScheduleView() {
	}
	
	/**
	 * Method to load the events
	 */
	@SuppressWarnings("serial")
	@PostConstruct
	public void init() {
		
		eventModel = new DefaultScheduleModel();
		lazyEventModel = new LazyScheduleModel() {

			@Override
			public void loadEvents(Date start, Date end) {
				listOfAppointments = appointmentService.findAllAppointments();
				for (Appointment appointment : listOfAppointments) {
					lazyEventModel.addEvent(new DefaultScheduleEvent(
							appointment.getTitle(),
							appointment.getStartDate(), 
							appointment.getEndDate()));
				}
			}	

		};
		
	}
	
	/**
	 * Method to add an Appointment into the schedule. It persists
	 * the appointment in the system.
	 * @param actionEvent
	 */
	public void addEvent(ActionEvent actionEvent) {
		if (event.getId() == null) {
			eventModel.addEvent(event);
			Appointment appointment = new Appointment(event.getTitle(),
					event.getStartDate(), event.getEndDate());
			appointmentService.createAppointment(appointment);
		}else{
			eventModel.updateEvent(event);
			Appointment appointment = appointmentService.
					findAppointmentByTitle(event.getTitle());
			appointment.setTitle(event.getTitle());
			appointment.setStartDate(event.getStartDate());
			appointment.setEndDate(event.getEndDate());
			appointmentService.updateAppointment(appointment);
		}
		event = new DefaultScheduleEvent();
	}
	
	/**
	 * Fired when an event is selected
	 * @param selectEvent
	 */
	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
		
	}
	/**
	 * Fired when a date is selected
	 * @param selectEvent
	 */
	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(),
				(Date) selectEvent.getObject());
	}

	
	//Getters and setters
	
	
	/**
	 * @return the event
	 */
	public ScheduleEvent getEvent() {
		return event;
	}

	/**
	 * @return the lazyEventModel
	 */
	public ScheduleModel getLazyEventModel() {
		return lazyEventModel;
	}

	/**
	 * @param lazyEventModel the lazyEventModel to set
	 */
	public void setLazyEventModel(ScheduleModel lazyEventModel) {
		this.lazyEventModel = lazyEventModel;
	}

	/**
	 * @return the listOfAppointments
	 */
	public List<Appointment> getListOfAppointments() {
		return listOfAppointments;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	/**
	 * @param listOfAppointments the listOfAppointments to set
	 */
	public void setListOfAppointments(List<Appointment> listOfAppointments) {
		this.listOfAppointments = listOfAppointments;
	}
	

}
