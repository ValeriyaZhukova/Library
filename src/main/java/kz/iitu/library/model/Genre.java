package kz.iitu.library.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genre;

    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    @Override
    public String toString()
    {
        return "Genre{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                '}';
    }
}
