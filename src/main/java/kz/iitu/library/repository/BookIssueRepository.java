package kz.iitu.library.repository;

import kz.iitu.library.model.BookIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookIssueRepository extends JpaRepository<BookIssue, Long> {

    BookIssue findBookIssuesByBook_IdAndUser_Id(Long bookId, Long userId);
}
