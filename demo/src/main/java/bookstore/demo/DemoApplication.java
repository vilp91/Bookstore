package bookstore.demo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.demo.domain.Book;
import bookstore.demo.domain.BookRepository;
import bookstore.demo.domain.Category;
import bookstore.demo.domain.CategoryRepository;

@SpringBootApplication

public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository categoryRepository) {
    return (args) -> {
        log.info("save a couple of books and categories");

        Category sciFiCategory = new Category("scifi");
        Category comicCategory = new Category("comic");
        categoryRepository.save(sciFiCategory);
        categoryRepository.save(comicCategory);

        Book s1 = new Book("dsfsdf fsdfsdfsd", "asdasdsa", "1900", "gdfgdf", "5643543");
        s1.setCategory(sciFiCategory);
        repository.save(s1);

        Book s2 = new Book("dsfsdf1 rtyrty", "asdasdsa1", "1901", "gdfgdf1", "56435431");
        s2.setCategory(comicCategory);
        repository.save(s2);

        log.info("Find books by title");
        List<Book> foundBooks = repository.findByTitle("dsfsdf fsdfsdfsd");
        foundBooks.forEach(book -> log.info(book.toString()));
    };
}


}
