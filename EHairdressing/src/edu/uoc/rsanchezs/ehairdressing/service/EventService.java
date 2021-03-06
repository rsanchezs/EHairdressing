package edu.uoc.rsanchezs.ehairdressing.service;

import static edu.uoc.rsanchezs.ehairdressing.model.Event.FIND_ALL;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import edu.uoc.rsanchezs.ehairdressing.model.Event;
import edu.uoc.rsanchezs.ehairdressing.util.Loggable;
import edu.uoc.rsanchezs.ehairdressing.util.LoggingInterceptor;


@Named
@Stateless
@LocalBean
@Loggable
public class EventService extends AbstractService<Event> implements Serializable {

	private static final long serialVersionUID = 4466002886752151169L;

	@Inject
	private Logger logger;
	/**
	 * Default constructor
	 */
	public EventService() {
		super(Event.class);
	}
	/**
	 * Method to persist an Event in the system
	 * @param event Event to persist
	 * @return event Event persisted
	 */
	public @NotNull Event createEvent(@NotNull Event event) {
		logger.log(Level.INFO, "Event created with id {0}", event.getId());
		em.persist(event);
		return event;
	}
	
	/**
	 * Method to update an Event in the system.
	 * @param event Event to update
	 * @return event Event updated
	 */
    public @NotNull Event updateEvent(@NotNull Event event)
    {
       em.merge(event);
       return event;
    }
 
    /**
     * Method to remove an Event in the system.
     * @param event Event to remove
     */
    public void removeEvent(@NotNull Event event)
    {
		em.remove(em.merge(event));

    }
    
    /**
     * Method that returns an Event by its id
     * @param id The id of the Event to find
     * @return event Event with that id
     */
    public Event findEventById(@NotNull String id) {
    	TypedQuery<Event> typedQuery = em.createNamedQuery(Event.FIND_BY_TITLE, Event.class);
    	typedQuery.setParameter("id", id);
    	
    	return typedQuery.getSingleResult();
    }
    
    
    /**
     * Method that returns an Event by its title
     * @param title The title of the Event to find
     * @return event Event with that title
     */
    public Event findEventByTitle(@NotNull String title) {
    	TypedQuery<Event> typedQuery = em.createNamedQuery(Event.FIND_BY_TITLE, Event.class);
    	typedQuery.setParameter("title", title);
    	
    	return typedQuery.getSingleResult();
    }
   
    /**
     * Method that returns all the Events stored in the system
     * @return List of Events
     */
	public List<Event> findAllEvents(){
    	return findWithNamedQuery(FIND_ALL);
    	
    }

}
