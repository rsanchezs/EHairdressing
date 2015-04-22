
package edu.uoc.rsanchezs.ehairdressing.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import edu.uoc.rsanchezs.ehairdressing.util.EHairdressingPU;

/**
 * @author Rubén
 *
 */
public abstract class AbstractService<T> {
	

	  /* @PersistenceContext(unitName = "EHairdressing")*/
	   @Inject @EHairdressingPU
	   protected EntityManager em;

	   private Class<T> entityClass;

	  
	   public AbstractService()
	   {
	   }

	   public AbstractService(Class<T> entityClass)
	   {
	      this.entityClass = entityClass;
	   }

	   public T persist(T entity)
	   {
	      em.persist(entity);
	      return entity;
	   }

	   public T findById(Long id)
	   {
	      return em.find(entityClass, id);
	   }

	   public void remove(T entity)
	   {
	      em.remove(em.merge(entity));
	   }

	   public T merge(T entity)
	   {
	      return em.merge(entity);
	   }


}
