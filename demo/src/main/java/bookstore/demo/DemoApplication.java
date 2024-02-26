package bookstore.demo;

//import java.lang.System.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.demo.domain.Book;
import bookstore.demo.domain.BookRepository;

@SpringBootApplication

public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			Book s1 = new Book("dsfsdf fsdfsdfsd", "asdasdsa", "1900", "gdfgdf", "5643543");
			Book s2 = new Book("dsfsdf1 rtyrty", "asdasdsa1", "1901", "gdfgdf1", "56435431");
			repository.save(s1);
			repository.save(s2);	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

	public static Logger getLog() {
		return log;
	}

}
