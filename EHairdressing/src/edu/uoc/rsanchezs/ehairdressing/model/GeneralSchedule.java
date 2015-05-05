package edu.uoc.rsanchezs.ehairdressing.model;

import edu.uoc.rsanchezs.ehairdressing.model.Schedule;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: GeneralSchedule
 *
 */
@Entity
public class GeneralSchedule extends Schedule implements Serializable {

	
	private List<Event> events;
	private static final long serialVersionUID = 1L;

	public GeneralSchedule() {
		super();
	}   
	@JoinTable(joinColumns = @JoinColumn(name = "GeneralSchedule_fk", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "events_fk", referencedColumnName = "id"))
	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
   
}
