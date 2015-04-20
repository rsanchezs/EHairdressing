package edu.uoc.rsanchezs.ehairdressing.util;

import java.lang.annotation.Target;
import javax.inject.Qualifier;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Documented
@Qualifier
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EHairdressing {
	

	   String message() default "{edu.uoc.rsanchezs.ehairdressing.util.EHairdressing.message}";

	   Class<?>[] groups() default {};

	   Class<? extends Payload>[] payload() default {};


	   @Retention(RetentionPolicy.RUNTIME)
	   @Target( {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER,
	         ElementType.TYPE, ElementType.ANNOTATION_TYPE,
	         ElementType.CONSTRUCTOR})
	   public @interface List
	   {
	      EHairdressing[] value();
	   }

}
