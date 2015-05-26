package edu.uoc.rsanchezs.ehairdressing.service;

import static edu.uoc.rsanchezs.ehairdressing.model.Tag.FIND_TAGS;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;

import edu.uoc.rsanchezs.ehairdressing.model.Tag;
import edu.uoc.rsanchezs.ehairdressing.util.Loggable;

/**
 * Session Bean implementation class TagService
 */
@Stateless
@LocalBean
@Loggable
public class TagService extends AbstractService<Tag> implements Serializable {

	private static final long serialVersionUID = 3330285238174992575L;

	/**
     * Default constructor. 
     */
    public TagService() {
    	super(Tag.class);
    }
    
    /**
     * Method that create a Tag in the system. 
     * @param Tag to persist
     * @return Tag persisted
     */
    public @NotNull Tag createTag(@NotNull Tag tag){
    	em.persist(tag);
    	return tag;
    }
    
    /**
     * Method that returns all the tags saved in the system.
     * @return list of tags
     */
    public List<Tag> findAllTags(){
    	
    	return findWithNamedQuery(FIND_TAGS);
    }

}
