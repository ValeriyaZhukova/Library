package kz.iitu.library.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.library.model.BookRequest;
import kz.iitu.library.repository.BookRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
@RequestMapping("/bookRequests")
public class BookRequestController {

    @Autowired
    BookRequestRepository bookRequestRepository;

    @ApiOperation(value	= "List all book request records", response = BookRequest.class, responseContainer = "List")
    @GetMapping("")
    public List<BookRequest> getAllBookRequests()
    {
        return bookRequestRepository.findAll();
    }

    @ApiOperation(value	= "Get book request by ID", response = BookRequest.class)
    @GetMapping("/{id}")
    public BookRequest getBookRequestById(@PathVariable("id") Long id)
    {
        return bookRequestRepository.findById(id).get();
    }

    @ApiOperation(value	= "Find book request by user ID and book ID", response = BookRequest.class)
    @GetMapping("/find/")
    public BookRequest findBookRequestByBookIdAndUserId(@RequestParam("bookId") Long bookId,
                                                        @RequestParam("userId") Long userId)
    {
        return bookRequestRepository.findBookRequestByBook_IdAndUser_Id(bookId, userId);
    }

    @ApiOperation(value	= "Add new book request", response = BookRequest.class)
    @PostMapping("")
    public BookRequest addBookRequest(@RequestBody BookRequest bookRequest)
    {
        return bookRequestRepository.save(bookRequest);
    }

    @ApiOperation(value	= "Update book request", response = BookRequest.class)
    @PutMapping("/{id}")
    public BookRequest updateBookRequest(@PathVariable("id") Long id,
                                         @RequestBody BookRequest bookRequest)
    {
        bookRequest.setId(id);
        return bookRequestRepository.save(bookRequest);
    }

    @ApiOperation(value	= "Delete book request")
    @DeleteMapping("/{id}")
    public void deleteBookRequest(@PathVariable("id") Long id)
    {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setId(id);
        bookRequestRepository.delete(bookRequest);
    }
}
