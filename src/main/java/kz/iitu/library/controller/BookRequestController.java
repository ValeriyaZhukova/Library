package kz.iitu.library.controller;

import kz.iitu.library.model.BookRequest;
import kz.iitu.library.repository.BookRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookRequests")
public class BookRequestController {

    @Autowired
    BookRequestRepository bookRequestRepository;

    @GetMapping("")
    public List<BookRequest> getAllBookRequests()
    {
        return bookRequestRepository.findAll();
    }

    @GetMapping("/{id}")
    public BookRequest getBookRequestById(@PathVariable("id") Long id)
    {
        return bookRequestRepository.findById(id).get();
    }

    @GetMapping("/find/")
    public BookRequest findBookRequestByBookIdAndUserId(@RequestParam("bookId") Long bookId,
                                                        @RequestParam("userId") Long userId)
    {
        return bookRequestRepository.findBookRequestByBook_IdAndUser_Id(bookId, userId);
    }

    @PostMapping("")
    public BookRequest addBookRequest(@RequestBody BookRequest bookRequest)
    {
        return bookRequestRepository.save(bookRequest);
    }

    @PutMapping("/{id}")
    public BookRequest updateBookRequest(@PathVariable("id") Long id,
                                         @RequestBody BookRequest bookRequest)
    {
        bookRequest.setId(id);
        return bookRequestRepository.save(bookRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteBookRequest(@PathVariable("id") Long id)
    {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setId(id);
        bookRequestRepository.delete(bookRequest);
    }
}
