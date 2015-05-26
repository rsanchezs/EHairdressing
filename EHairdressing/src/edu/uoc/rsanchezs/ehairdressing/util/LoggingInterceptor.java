package edu.uoc.rsanchezs.ehairdressing.util;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Loggable
@Interceptor
public class LoggingInterceptor implements Serializable {
	
	private static final long serialVersionUID = 1120893000908130711L;
	
	@Inject
	private transient Logger logger;
	
	@AroundInvoke
	public Object logMethod(InvocationContext ic) throws Exception {
		logger.entering(ic.getTarget().getClass().getName(), 
				ic.getMethod().getName());
		try {
			
			return ic.proceed();
			
		} finally {
			logger.exiting(ic.getTarget().getClass().getName(), 
					ic.getMethod().getName());
		}
	}

}
