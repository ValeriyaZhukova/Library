package kz.iitu.library.controller;

import kz.iitu.library.model.Book;
import kz.iitu.library.model.User;
import kz.iitu.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("")
    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id)
    {
        return bookRepository.findById(id).get();
    }

    @GetMapping("/find/")
    public Book findBookByTitle(@RequestParam("title") String title)
    {
        return bookRepository.findBookByTitleContaining(title);
    }

    @GetMapping("/findByAuthor/")
    public List<Book> findBooksByAuthor(@RequestParam("name") String name,
                                        @RequestParam("surname") String surname)
    {
        return bookRepository.findBookByAuthors_Name_AndAuthors_Surname(name, surname);
    }

    @GetMapping("/findByGenre/")
    public List<Book> findBooksByGenre(@RequestParam("genre") String genre)
    {
        return bookRepository.findBookByGenres_Genre(genre);
    }

    @PostMapping("")
    public Book addBook(@RequestBody Book book)
    {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") Long id,
                            @RequestBody Book book)
    {
        book.setId(id);
        return bookRepository.save(book);
    }

    @PatchMapping("/{id}")
    public Book updateBookTitle(@PathVariable("id") Long id,
                                @RequestParam("title") String title)
    {
        Book book = bookRepository.findById(id).get();
        book.setId(id);
        book.setTitle(title);
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id)
    {
        Book book = new Book();
        book.setId(id);
        bookRepository.delete(book);
    }
}
