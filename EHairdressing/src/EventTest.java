import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import edu.uoc.rsanchezs.ehairdressing.model.Event;


public class EventTest {

	public static void main(String[] args) {
		String title = "Gestoría";
		Event event = new Event();
		Date startDate = new Date();
		Date endDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		try {
			startDate = sdf.parse("19-05-2015 03:00:00");
			endDate = sdf.parse("19-05-2015 06:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		event.setTitle("Prueba");
		event.setStartDate(startDate);
		event.setEndDate(endDate);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EHairdressing");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(event);
		tx.commit();
		
		tx.begin();
		TypedQuery<Event> typedQuery = em.createNamedQuery(Event.FIND_BY_TITLE, Event.class);
    	typedQuery.setParameter("title", title);
		Event ev = typedQuery.getSingleResult();
		tx.commit();
		System.out.println("Event created" + event.getTitle());
		System.out.println("Event finded by title" + ev.getTitle());

	}

}
