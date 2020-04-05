package kz.iitu.library.repository;

import kz.iitu.library.model.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRequestRepository extends JpaRepository<BookRequest, Long> {

    BookRequest findBookRequestByBook_IdAndUserId(Long book_id, Long user_id);
}
