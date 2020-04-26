package kz.iitu.library.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.library.model.BookIssue;
import kz.iitu.library.repository.BookIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/bookIssues")
public class BookIssueController {

    @Autowired
    BookIssueRepository bookIssueRepository;

    @ApiOperation(value	= "List all book issue records", response = BookIssue.class, responseContainer = "List")
    @GetMapping("")
    public List<BookIssue> getAllBookIssues()
    {
        return bookIssueRepository.findAll();
    }

    @ApiOperation(value	= "Get book issue by ID", response = BookIssue.class)
    @GetMapping("/{id}")
    public BookIssue getBookIssueById(@PathVariable("id") Long id)
    {
        return bookIssueRepository.findById(id).get();
    }

    @ApiOperation(value	= "Find book issue by user ID and book ID", response = BookIssue.class)
    @GetMapping("/find/")
    public BookIssue findBookIssueByBookIdAndUserId(@RequestParam("bookId") Long bookId,
                                                    @RequestParam("userId") Long userId)
    {
        return bookIssueRepository.findBookIssuesByBook_IdAndUser_Id(bookId, userId);
    }

    @ApiOperation(value	= "Add book issue", response = BookIssue.class)
    @PostMapping("")
    public BookIssue addBookIssue(@RequestBody BookIssue bookIssue)
    {
        return bookIssueRepository.save(bookIssue);
    }

    @ApiOperation(value	= "Update book issue", response = BookIssue.class)
    @PutMapping("/{id}")
    public BookIssue updateBookIssue(@PathVariable("id") Long id,
                                     @RequestBody BookIssue bookIssue)
    {
        bookIssue.setId(id);
        return bookIssueRepository.save(bookIssue);
    }

    @ApiOperation(value	= "Delete book issue")
    @DeleteMapping("/{id}")
    public void deleteBookIssue(@PathVariable("id") Long id)
    {
        BookIssue bookIssue = new BookIssue();
        bookIssue.setId(id);
        bookIssueRepository.delete(bookIssue);
    }
}
