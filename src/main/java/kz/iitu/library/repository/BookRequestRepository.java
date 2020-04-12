package kz.iitu.library.repository;

import kz.iitu.library.model.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRequestRepository extends JpaRepository<BookRequest, Long> {

    BookRequest findBookRequestByBook_IdAndUser_Id(Long book_id, Long user_id);
}
