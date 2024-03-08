package bookstore.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String title;
    private String publicationYear;
    private String isbn;
    private String price;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoryid")
    private Category category;

    public Book() {
        
    }

    public Book(String author, String title, String publicationYear, String isbn, String price) {
        
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublicationYear() {
        return publicationYear;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "Book [id=" + id + ", author=" + author + ", title=" + title + ", publicationYear=" + publicationYear
                + ", isbn=" + isbn + ", price=" + price + "]";
    }
}
