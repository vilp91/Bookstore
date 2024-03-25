package bookstore.demo.web;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import bookstore.demo.domain.Book;
import bookstore.demo.domain.BookRepository;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;


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
    //@PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        @SuppressWarnings("null")
        Book book = bookRepository.findById(id)
                                  .orElseThrow(() -> new IllegalArgumentException("Invalid book id: " + id));
        model.addAttribute("book", book);
        return "editbook";
    }
    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, @ModelAttribute Book updatedBook) {
        @SuppressWarnings("null")
        Book bookToUpdate = bookRepository.findById(id)
                                          .orElseThrow(() -> new IllegalArgumentException("Invalid book id: " + id));
        bookToUpdate.setTitle(updatedBook.getTitle());
        bookToUpdate.setAuthor(updatedBook.getAuthor());
        bookToUpdate.setPublicationYear(updatedBook.getPublicationYear());
        bookToUpdate.setIsbn(updatedBook.getIsbn());
        bookToUpdate.setPrice(updatedBook.getPrice());
        
        bookRepository.save(bookToUpdate);
        return "redirect:/booklist";
    }
}
