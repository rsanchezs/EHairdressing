package edu.uoc.rsanchezs.ehairdressing.exceptions;

/**
 * Throw when the entity instance has not removed
 * @author Rubén
 *
 */

public class RemoveException extends Exception {
	
	private static final long serialVersionUID = -3113410545373798574L;

	public RemoveException()
	   {
	      super();
	   }

	   public RemoveException(String message)
	   {
	      super(message);
	   }

}
