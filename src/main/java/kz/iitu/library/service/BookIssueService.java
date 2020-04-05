package kz.iitu.library.service;

import kz.iitu.library.model.Book;
import kz.iitu.library.model.BookIssue;
import kz.iitu.library.model.BookStatus;
import kz.iitu.library.model.User;
import kz.iitu.library.repository.BookIssueRepository;
import kz.iitu.library.repository.BookRepository;
import kz.iitu.library.repository.BookRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Component
public class BookIssueService {

    Scanner scanner = new Scanner(System.in);

    @Autowired
    private BookIssueRepository bookIssueRepository;

    @Autowired
    private BookRepository bookRepository;

    List<BookIssue> bookIssueList = new ArrayList<>();

    public void addBookIssueRecord(User user, Book book)
    {
        String s_issueDate;
        String s_dueDate;
        boolean isOverdue = false;
        Date issueDate;
        Date dueDate;

        System.out.println("Enter issue date in format dd.mm.yy");
        s_issueDate = scanner.next();

        System.out.println("Enter due date in format dd.mm.yy");
        s_dueDate = scanner.next();

        try {
            issueDate = new SimpleDateFormat("dd.MM.yyyy").parse(s_issueDate);
            dueDate = new SimpleDateFormat("dd.MM.yyyy").parse(s_dueDate);
            BookIssue bookIssue = new BookIssue(user.getId(), book.getId(), issueDate, dueDate, isOverdue, book, user);
            bookIssueRepository.save(bookIssue);
            System.out.println(bookIssue.toString() + "\nsuccessfully added");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        book.setStatus(BookStatus.ISSUED);
        bookRepository.save(book);
        System.out.println(book.toString());
    }

    public List<BookIssue> getBookIssueRecords()
    {
        for (BookIssue b: bookIssueRepository.findAll())
        {
            bookIssueList.add(b);
        }
        return bookIssueList;
    }


}
