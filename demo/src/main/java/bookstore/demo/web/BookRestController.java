package bookstore.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstore.demo.domain.Book;
import bookstore.demo.domain.BookRepository;

@CrossOrigin
@Controller
public class BookRestController {
    
    @Autowired
	private BookRepository repository; 
    
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    } 
    @SuppressWarnings("null")
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {	
    	return repository.findById(id);
    }
}
