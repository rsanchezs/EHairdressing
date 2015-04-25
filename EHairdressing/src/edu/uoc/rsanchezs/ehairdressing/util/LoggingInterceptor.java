package edu.uoc.rsanchezs.ehairdressing.util;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Loggable
@Interceptor
public class LoggingInterceptor {
	
	@Inject
	private Logger logger;
	
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
