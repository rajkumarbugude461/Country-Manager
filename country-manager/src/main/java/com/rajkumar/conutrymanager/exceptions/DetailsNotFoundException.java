package com.rajkumar.conutrymanager.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DetailsNotFoundException extends Exception{
 
	    private static final long serialVersionUID = 1L;
	    private static final Logger logger =  LoggerFactory.getLogger(DetailsNotFoundException.class);
	    
	    public DetailsNotFoundException(String exception) {
	        super(exception);
	        logger.info(exception);
	    }
	}


