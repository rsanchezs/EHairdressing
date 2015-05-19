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

import edu.uoc.rsanchezs.ehairdressing.model.Event;
import edu.uoc.rsanchezs.ehairdressing.service.EventService;

@Named
@ViewScoped
public class GeneralScheduleView implements Serializable {


	private static final long serialVersionUID = -274278189302528918L;
	
	@Inject
	private EventService eventService;

	private ScheduleEvent event = new DefaultScheduleEvent();
	private ScheduleModel eventModel;
	private ScheduleModel lazyEventModel;
	private List<Event> listOfEvents = new ArrayList<Event>();
	Event ev = new Event();
	

	/**
	 * Default constructor
	 */
	public GeneralScheduleView() {
		
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
				listOfEvents = eventService.findAllEvents();
				for (Event event : listOfEvents) {
					lazyEventModel.addEvent(new DefaultScheduleEvent(event
							.getTitle(), event.getStartDate(), event
							.getEndDate(), event));
				}
			}

		};
		
	}
	
	/**
	 * Method to add an Event into the schedule. It persists
	 * the event in the system.
	 * @param actionEvent
	 */
	public void addEvent(ActionEvent actionEvent) {
		if (event.getId() == null) {
			eventModel.addEvent(event);
			Event ev = new Event(event.getTitle(), event.getStartDate(), 
					event.getEndDate());
			eventService.createEvent(ev);
		}else{
			eventModel.updateEvent(event);
			Event ev = eventService.findEventByTitle(event.getTitle());
			ev.setTitle(event.getTitle());
			ev.setStartDate(event.getStartDate());
			ev.setEndDate(event.getEndDate());
			eventService.updateEvent(ev);
		}
		event = new DefaultScheduleEvent();
		
	
	}
	
	/**
	 * Fired when an event is selected
	 * @param selectEvent
	 */
	public void onEventSelect(SelectEvent selectEvent) {
		event = (DefaultScheduleEvent) selectEvent.getObject();
		
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
	 * @return the listOfEvents
	 */
	public List<Event> getListOfEvents() {
		return listOfEvents;
	}
	/**
	 * @param event the event to set
	 */
	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}
	/**
	 * @param listOfEvents the listOfEvents to set
	 */
	public void setListOfEvents(List<Event> listOfEvents) {
		this.listOfEvents = listOfEvents;
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
	
	
	
	
}