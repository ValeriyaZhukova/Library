package kz.iitu.library.controller;

import kz.iitu.library.model.BookIssue;
import kz.iitu.library.repository.BookIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookIssues")
public class BookIssueController {

    @Autowired
    BookIssueRepository bookIssueRepository;

    @GetMapping("")
    public List<BookIssue> getAllBookIssues()
    {
        return bookIssueRepository.findAll();
    }

    @GetMapping("/{id}")
    public BookIssue getBookIssueById(@PathVariable("id") Long id)
    {
        return bookIssueRepository.findById(id).get();
    }

    @GetMapping("/find/")
    public BookIssue findBookIssueByBookIdAndUserId(@RequestParam("bookId") Long bookId,
                                                    @RequestParam("userId") Long userId)
    {
        return bookIssueRepository.findBookIssuesByBook_IdAndUser_Id(bookId, userId);
    }

    @PostMapping("")
    public BookIssue addBookIssue(@RequestBody BookIssue bookIssue)
    {
        return bookIssueRepository.save(bookIssue);
    }

    @PutMapping("/{id}")
    public BookIssue updateBookIssue(@PathVariable("id") Long id,
                                     @RequestBody BookIssue bookIssue)
    {
        bookIssue.setId(id);
        return bookIssueRepository.save(bookIssue);
    }

    @DeleteMapping("/{id}")
    public void deleteBookIssue(@PathVariable("id") Long id)
    {
        BookIssue bookIssue = new BookIssue();
        bookIssue.setId(id);
        bookIssueRepository.delete(bookIssue);
    }
}
