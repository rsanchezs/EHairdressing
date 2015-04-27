package edu.uoc.rsanchezs.ehairdressing.view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import edu.uoc.rsanchezs.ehairdressing.util.Loggable;

@Named
@RequestScoped
@Loggable
public class ScheduleView extends DefaultScheduleModel implements Serializable {

	private static final long serialVersionUID = -7376837551928013443L;

	private ScheduleModel model = new DefaultScheduleModel();
	private ScheduleEvent event = new DefaultScheduleEvent();
	private List<ScheduleEvent> events;

	/**
	 * Default constructor
	 */
	public ScheduleView() {
		super();
	}

	/**
	 * @param events
	 */
	public ScheduleView(List<ScheduleEvent> events) {
		super(events);
	}


	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(),
				(Date) selectEvent.getObject());
	}
	

	/**
	 * @return the model
	 */
	public ScheduleModel getEventModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(ScheduleModel eventModel) {
		this.model = eventModel;
	}

	/**
	 * @return the event
	 */
	public ScheduleEvent getEvent() {
		return event;
	}

	/**
	 * @return the events
	 */
	public List<ScheduleEvent> getEvents() {
		return events;
	}

	/**
	 * @param event
	 *            the event to set
	 */
	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	/**
	 * @param events
	 *            the events to set
	 */
	public void setEvents(List<ScheduleEvent> events) {
		this.events = events;
	}
	
	

}
