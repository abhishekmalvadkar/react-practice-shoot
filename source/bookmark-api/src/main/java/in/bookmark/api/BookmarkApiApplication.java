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
		log.trace("TRACE");
		log.debug("DEBUG");
		log.warn("WARN");
		log.info("INFO");
		log.error("ERROR");
	}

}
