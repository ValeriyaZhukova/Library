package kz.iitu.library;

import kz.iitu.library.model.*;
import kz.iitu.library.repository.BookIssueRepository;
import kz.iitu.library.repository.BookRepository;
import kz.iitu.library.repository.BookRequestRepository;
import kz.iitu.library.repository.UserRepository;
import kz.iitu.library.service.BookIssueService;
import kz.iitu.library.service.BookRequestService;
import kz.iitu.library.service.BookService;
import kz.iitu.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Library {

    int userInput;

    Scanner scanner = new Scanner(System.in);

    User currentUser;
    Book book;

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookService bookService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    BookRequestRepository bookRequestRepository;
    @Autowired
    BookRequestService bookRequestService;
    @Autowired
    BookIssueRepository bookIssueRepository;
    @Autowired
    BookIssueService bookIssueService;

    public void showMenu()
    {
        System.out.println("0 - Exit");
        System.out.println("1 - Add new book");
        System.out.println("2 - List all books");
        System.out.println("3 - Find book by title");
        System.out.println("4 - Find book by author surname");
        System.out.println("5 - Find book by genre");
        System.out.println("6 - Add new user");
        System.out.println("7 - List all users");
        System.out.println("8 - Request book");
        System.out.println("9 - Issue book");
        System.out.println("10 - Show books by status");
        System.out.println("11 - Update book category and status");
    }

    public void addNewBook()
    {
        bookService.addNewBook();
    }

    public void updateBook()
    {
        Long id;
        System.out.println("Enter book id");
        id = scanner.nextLong();
        bookService.updateBookCategoryAndStatus(id);
    }

    public void listBooks()
    {
        bookService.listBooks();
    }

    public void findBookByTitle()
    {
        bookService.findBookByTitle();
    }

    public void findBookByAuthor()
    {
        bookService.findBookByAuthorSurname();
    }

    public void findBookByGenre()
    {
        bookService.findBookByGenre();
    }

    public void addNewUser()
    {
        userService.addNewUser();
    }

    public void listUsers()
    {
        userService.listUsers();
    }

    public void setCurrentUser()
    {
        currentUser = userService.findUserByNameAndSurname();
    }

    public void requestBook()
    {
        setCurrentUser();
        System.out.println(currentUser.toString());

        book = bookService.findBookByTitle();
        System.out.println(book.toString());

        if (book.getStatus().equals(BookStatus.AVAILABLE))
        {
            bookRequestService.addRequest(currentUser, book);
        }
        else
        {
            System.out.println("Book is not available");
        }
    }

    public void issueBook()
    {
        setCurrentUser();
        System.out.println(currentUser.toString());

        book = bookService.findBookByTitle();
        System.out.println(book.toString());

        BookRequest bookRequest = bookRequestService.getRequestByUserAndBook(book, currentUser);

        if (book.getStatus().equals(BookStatus.AVAILABLE))
        {
            bookIssueService.addBookIssueRecord(currentUser, book);
        }
        else if (book.getStatus().equals(BookStatus.REQUESTED) && !bookRequest.equals(null))
        {
            bookIssueService.addBookIssueRecord(currentUser, book);
            bookRequestService.getRequestByUserAndBook(book, currentUser).setIssued(true);
        }
        else
        {
            System.out.println("Book is not available");
        }
    }

    public void showBooksByStatus()
    {
        bookService.showBooksByStatus();
    }

    public void checkBookOverdue()
    {
        Date currentDate = new Date();
        List<BookIssue> bookIssueList = new ArrayList<>();
        bookIssueList = bookIssueService.getBookIssueRecords();
        for (int i = 0; i < bookIssueList.size(); i++)
        {
            if ((bookIssueList.get(i).getDueDate().compareTo(currentDate)) < 0)
            {
                bookIssueList.get(i).setOverdue(true);
                bookIssueList.get(i).getBook().setStatus(BookStatus.OVERDUE);
                bookIssueRepository.save(bookIssueList.get(i));
                bookRepository.save(bookIssueList.get(i).getBook());
                System.out.println("The book " + bookIssueList.get(i).getBook().getTitle() + " issued to the user " + bookIssueList.get(i).getUser().getName() + " " + bookIssueList.get(i).getUser().getSurname() + " is overdue!");
                System.out.println(bookIssueList.get(i).toString());
                System.out.println(bookIssueList.get(i).getBook().toString());
            }
        }
    }

    public void run()
    {
        showMenu();

        checkBookOverdue();

        userInput = 1;

        while (userInput != 0)
        {
            userInput = scanner.nextInt();

            switch (userInput)
            {
                case 0:
                {
                    break;
                }

                case 1:
                {
                    addNewBook();
                    break;
                }

                case 2:
                {
                    listBooks();
                    break;
                }

                case 3:
                {
                    findBookByTitle();
                    break;
                }

                case 4:
                {
                    findBookByAuthor();
                    break;
                }

                case 5:
                {
                    findBookByGenre();
                    break;
                }

                case 6:
                {
                    addNewUser();
                    break;
                }

                case 7:
                {
                    listUsers();
                    break;
                }

                case 8:
                {
                    requestBook();
                    break;
                }

                case 9:
                {
                    issueBook();
                    break;
                }

                case 10:
                {
                    showBooksByStatus();
                    break;
                }

                case 11:
                {
                    updateBook();
                    break;
                }
            }
        }
    }
}
