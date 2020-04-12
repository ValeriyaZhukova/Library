package kz.iitu.library.service;

import kz.iitu.library.model.Book;
import kz.iitu.library.model.Author;
import kz.iitu.library.model.BookCategory;
import kz.iitu.library.model.BookStatus;
import kz.iitu.library.model.Genre;
import kz.iitu.library.repository.AuthorRepository;
import kz.iitu.library.repository.BookRepository;
import kz.iitu.library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class BookService {

    //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    Scanner scanner = new Scanner(System.in);

    @Autowired
    private BookRepository bookRepository;

    List<Book> books = new ArrayList<>();

/*    private AuthorRepository authorRepository;
    private GenreRepository genreRepository;*/

    public void addNewBook()
    {
        String title;
        int publicationYear;
        String language;
        String category;
        BookCategory bookCategory;
        BookStatus bookStatus = BookStatus.AVAILABLE;
        /*List<Genre> genres = new ArrayList<>();
        List<Author> authors = new ArrayList<>();*/

        System.out.println("Enter book title");
        title = scanner.nextLine();

        System.out.println("Enter book language");
        language = scanner.nextLine();

        System.out.println("Enter book category: ");
        System.out.println("Prose, Drama, Poetry, Fiction or Nonfiction");
        category = scanner.nextLine();

        System.out.println("Enter book publication year");
        publicationYear = scanner.nextInt();

        if (category.equals("Prose"))
        {
            bookCategory = BookCategory.PROSE;
        }

        else if (category.equals("Drama"))
        {
            bookCategory = BookCategory.DRAMA;
        }

        else if (category.equals("Poetry"))
        {
            bookCategory = BookCategory.POETRY;
        }

        else if (category.equals("Fiction"))
        {
            bookCategory = BookCategory.FICTION;
        }

        else if (category.equals("Nonfiction"))
        {
            bookCategory = BookCategory.NONFICTION;
        }

        else
        {
            bookCategory = BookCategory.PROSE;
        }

        Book book = new Book(title, publicationYear, language, bookStatus, bookCategory);

        bookRepository.save(book);

        System.out.println("Book " + book.toString() + "\nsuccessfully added");
    }

    public void updateBookCategoryAndStatus(Long id)
    {
        Book book = bookRepository.findById(id).get();
        BookCategory bookCategory;
        BookStatus bookStatus = BookStatus.AVAILABLE;
        String category;

        System.out.println("Enter book category: ");
        System.out.println("Prose, Drama, Poetry, Fiction or Nonfiction");
        category = scanner.next();

        if (category.equals("Prose"))
        {
            bookCategory = BookCategory.PROSE;
        }

        else if (category.equals("Drama"))
        {
            bookCategory = BookCategory.DRAMA;
        }

        else if (category.equals("Poetry"))
        {
            bookCategory = BookCategory.POETRY;
        }

        else if (category.equals("Fiction"))
        {
            bookCategory = BookCategory.FICTION;
        }

        else if (category.equals("Nonfiction"))
        {
            bookCategory = BookCategory.NONFICTION;
        }

        else
        {
            bookCategory = BookCategory.PROSE;
        }

        book.setCategory(bookCategory);
        book.setStatus(bookStatus);

        bookRepository.save(book);

        System.out.println("Book " + book.toString() + " was updated successfully");
    }

    public void listBooks()
    {
        books.clear();
        for (Book book: bookRepository.findAll())
        {
            books.add(book);
            System.out.println(book.toString());
        }
    }

    public List<Book> getBooks()
    {
        books.clear();
        for (Book book: bookRepository.findAll())
        {
            books.add(book);
        }
        return books;
    }

    public Book findBookByTitle()
    {
        String title;
        System.out.println("Enter book title");
        title = scanner.nextLine();
        Book book = bookRepository.findBookByTitleContaining(title);
        System.out.println(book.toString());
        return book;
    }

    public void findBookByAuthorSurname()
    {
        String authorName, authorSurname;
        System.out.println("Enter author name");
        authorName = scanner.nextLine();
        System.out.println("Enter author surname");
        authorSurname = scanner.nextLine();
        books.clear();
        books = bookRepository.findBookByAuthors_Name_AndAuthors_Surname(authorName, authorSurname);
        for (int i = 0; i < books.size(); i++)
        {
            System.out.println(books.get(i).toString());
        }
    }

    public void findBookByGenre()
    {
        String genre;
        System.out.println("Enter book genre");
        genre = scanner.next();
        books.clear();
        books = bookRepository.findBookByGenres_Genre(genre);
        for (int i = 0; i < books.size(); i++)
        {
            System.out.println(books.get(i).toString());
        }
    }

    public void showBooksByStatus()
    {
        books.clear();

        for (Book book: bookRepository.findAll())
        {
            books.add(book);
        }

        System.out.println("Available books: ");
        for (int i = 0; i < books.size(); i++)
        {
            if (books.get(i).getStatus().equals(BookStatus.AVAILABLE))
            {
                System.out.println(books.get(i).toString());
            }
        }

        System.out.println("Requested books: ");
        for (int i = 0; i < books.size(); i++)
        {
            if (books.get(i).getStatus().equals(BookStatus.REQUESTED))
            {
                System.out.println(books.get(i).toString());
            }
        }

        System.out.println("Issued books: ");
        for (int i = 0; i < books.size(); i++)
        {
            if (books.get(i).getStatus().equals(BookStatus.ISSUED))
            {
                System.out.println(books.get(i).toString());
            }
        }

        System.out.println("Overdue books: ");
        for (int i = 0; i < books.size(); i++)
        {
            if (books.get(i).getStatus().equals(BookStatus.OVERDUE))
            {
                System.out.println(books.get(i).toString());
            }
        }
    }
}
