package kz.iitu.library.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.library.model.Book;
import kz.iitu.library.model.User;
import kz.iitu.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api
@ApiResponses
    (value	=
        {
                @ApiResponse(code = 200, message = "Successful"),
                @ApiResponse(code =	401, message = "Not	authorized"),
                @ApiResponse(code =	403, message = "Forbidden"),
                @ApiResponse(code =	404, message = "Resource not found")
        }
    )

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @ApiOperation(value	= "List all books", response = Book.class, responseContainer = "List")
    @GetMapping("")
    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    @ApiOperation(value	= "Get book by ID", response = Book.class)
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id)
    {
        return bookRepository.findById(id).get();
    }

    @ApiOperation(value	= "Find book by title", response = Book.class)
    @GetMapping("/find/")
    public Book findBookByTitle(@RequestParam("title") String title)
    {
        return bookRepository.findBookByTitleContaining(title);
    }

    @ApiOperation(value	= "Find book by author", response = Book.class, responseContainer = "List")
    @GetMapping("/findByAuthor/")
    public List<Book> findBooksByAuthor(@RequestParam("name") String name,
                                        @RequestParam("surname") String surname)
    {
        return bookRepository.findBookByAuthors_Name_AndAuthors_Surname(name, surname);
    }

    @ApiOperation(value	= "Find book by genre", response = Book.class, responseContainer = "List")
    @GetMapping("/findByGenre/")
    public List<Book> findBooksByGenre(@RequestParam("genre") String genre)
    {
        return bookRepository.findBookByGenres_Genre(genre);
    }

    @ApiOperation(value	= "Add new book", response = Book.class)
    @PostMapping("")
    public Book addBook(@RequestBody Book book)
    {
        return bookRepository.save(book);
    }

    @ApiOperation(value	= "Update book", response = Book.class)
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") Long id,
                            @RequestBody Book book)
    {
        book.setId(id);
        return bookRepository.save(book);
    }

    @ApiOperation(value	= "Update book title", response = Book.class)
    @PatchMapping("/{id}")
    public Book updateBookTitle(@PathVariable("id") Long id,
                                @RequestParam("title") String title)
    {
        Book book = bookRepository.findById(id).get();
        book.setId(id);
        book.setTitle(title);
        return bookRepository.save(book);
    }

    @ApiOperation(value	= "Delete book")
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id)
    {
        Book book = new Book();
        book.setId(id);
        bookRepository.delete(book);
    }
}
