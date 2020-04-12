package kz.iitu.library.repository;

import kz.iitu.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByTitleContaining(String title);

    List<Book> findBookByAuthors_Name_AndAuthors_Surname(String authorName, String authorSurname);

    List<Book> findBookByGenres_Genre(String genre);
}
