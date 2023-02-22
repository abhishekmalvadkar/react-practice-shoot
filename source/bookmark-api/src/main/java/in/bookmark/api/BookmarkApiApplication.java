package in.bookmark.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class BookmarkApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarkApiApplication.class, args);
		/*
		 * TRACE < DEBUG < INFO < WARN  < ERROR
		 */
		
		/**
		 * In both TRACE and debug log level we are printing verbose info where mentioned function will be called wheather that log level is enabled or not that's why to improve performance we are plcaing this chacek over trace and debug log level
		 */
		if (log.isDebugEnabled()) {
			log.debug("variable name :: {}" , "callingFunction()"); // callingFunction() will execute if debug is enabled or not if we don't write debug enabled if check it
		}
		if (log.isTraceEnabled()) {
			log.trace("variable name :: {}" , "callingFunction()"); // callingFunction() will execute if trace is enabled or not if don't write trace enabled if check it
		}
		log.warn("WARN");
		log.info("INFO");
		log.error("ERROR");
	}

}
