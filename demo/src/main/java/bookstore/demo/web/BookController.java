package bookstore.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import bookstore.demo.domain.Book;
import bookstore.demo.domain.BookRepository;





@Controller
public class BookController {
    private final BookRepository bookRepository;
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping("/booklist")
    public String getBooks(Model model) {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "booklist";
    }
    @GetMapping("/add")
    public String showbookform(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    @SuppressWarnings("null")
    @PostMapping("/add")
    public String addbook(@ModelAttribute Book newBook) {
        bookRepository.save(newBook);
        return "redirect:/booklist";
    }
    @SuppressWarnings("null")
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }
}
