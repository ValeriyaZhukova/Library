package kz.iitu.library.service;

import kz.iitu.library.model.Book;
import kz.iitu.library.model.BookRequest;
import kz.iitu.library.model.BookStatus;
import kz.iitu.library.model.User;
import kz.iitu.library.repository.BookRepository;
import kz.iitu.library.repository.BookRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
public class BookRequestService {

    Scanner scanner = new Scanner(System.in);

    @Autowired
    private BookRequestRepository bookRequestRepository;

    @Autowired
    private BookRepository bookRepository;

    public void addRequest(User user, Book book)
    {
        Date date;
        String requestDate;
        boolean isIssued = false;

        System.out.println("Enter request date in format dd.mm.yyyy");

        requestDate = scanner.next();

        try {
            date = new SimpleDateFormat("dd.MM.yyy").parse(requestDate);
            BookRequest bookRequest = new BookRequest(user.getId(), book.getId(), date, isIssued, book, user);
            bookRequestRepository.save(bookRequest);
            System.out.println(bookRequest.toString() + "\nsuccessfully added");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        book.setStatus(BookStatus.REQUESTED);

        bookRepository.save(book);

        System.out.println(book.toString());
    }

    public BookRequest getRequestByUserAndBook(Book book, User user)
    {
        BookRequest bookRequest = null;
        try {
            bookRequest = bookRequestRepository.findBookRequestByBook_IdAndUser_Id(book.getId(), user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookRequest;
    }
}
