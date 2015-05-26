package edu.uoc.rsanchezs.ehairdressing.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.uoc.rsanchezs.ehairdressing.util.EHairdressingPU;

/**
 * @author Rubén
 *
 */
public abstract class AbstractService<T> {

	/* @PersistenceContext(unitName = "EHairdressing") */
	@Inject
	@EHairdressingPU
	protected EntityManager em;

	private Class<T> entityClass;

	public AbstractService() {
	}

	/**
	 * Default constructor
	 * 
	 * @param entityClass
	 */
	public AbstractService(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * Stores an instance of the entity class in the database
	 * 
	 * @param T Object
	 * @return
	 */
	public T persist(T entity) {
		em.persist(entity);
		em.flush();
		em.refresh(entity);
		return entity;
	}

	/**
	 * Retrieves an entity instance that was previously persisted to the
	 * database
	 * @param T  Objet
	 * @param id
	 * @return
	 */
	public T findById(Long id) {
		return em.find(entityClass, id);
	}
	

	/**
	 * Retrieves an entity instance that was previously persisted to the
	 * database
	 * @param T  Objet
	 * @param id
	 * @return
	 */
	public T findById(String id) {
		return em.find(entityClass, id);
	}

	/**
	 * Removes the record that is associated with the entity instance
	 * @param T Object
	 */
	public void remove(T entity) {
		em.remove(em.merge(entity));
	}

	/**
	 * @param entity
	 * @return
	 */
	public T merge(T entity) {
		return em.merge(entity);
	}

	/**
	 * Returns the number of records that meet the criteria
	 * @param namedQueryName
	 * @return List
	 */
	public List<T> findWithNamedQuery(String namedQueryName) {
		TypedQuery<T> query = em.createNamedQuery(namedQueryName, entityClass);
		return query.getResultList();
	}

	/**
	 * Returns the number of records that meet the criteria
	 * @param namedQueryName
	 * @return List
	 */
	public List<T> findWithNativeQuery(String nativeQueryName) {
		TypedQuery<T> query = em.createNamedQuery(nativeQueryName, entityClass);
		return query.getResultList();
	}
	/**
	 * Returns the number of total records
	 * @param namedQueryName
	 * @return int
	 */
	public int countTotalRecord(String namedQueryName) {
		Query query = em.createNamedQuery(namedQueryName);
		Number result = (Number) query.getSingleResult();
		return result.intValue();
	}
	

}
