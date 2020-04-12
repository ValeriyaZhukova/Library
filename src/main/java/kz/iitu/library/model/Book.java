package kz.iitu.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "requests", "bookIssues"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int publicationYear;
    private String language;
    //@Enumerated(EnumType.STRING)
    private Enum status;
    //@Enumerated(EnumType.STRING)
    private Enum category;

    public Book(){}

    public Book(String title, int publicationYear, String language, Enum status, Enum category)
    {
        this.title = title;
        this.publicationYear = publicationYear;
        this.language = language;
        this.status = status;
        this.category = category;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_genres",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id", referencedColumnName = "id")}
    )
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_authors",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")}
    )
    private List<Author> authors = new ArrayList<>();

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<BookRequest> requests = new ArrayList<>();

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<BookIssue> bookIssues = new ArrayList<>();

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getPublicationYear()
    {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear)
    {
        this.publicationYear = publicationYear;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public Enum getStatus()
    {
        return status;
    }

    public void setStatus(Enum status)
    {
        this.status = status;
    }

    public Enum getCategory()
    {
        return category;
    }

    public void setCategory(Enum category)
    {
        this.category = category;
    }

    public List<Genre> getGenres()
    {
        return genres;
    }

    public void setGenres(List<Genre> genres)
    {
        this.genres = genres;
    }

    public List<Author> getAuthors()
    {
        return authors;
    }

    public void setAuthors(List<Author> authors)
    {
        this.authors = authors;
    }

    public List<BookRequest> getRequests() {
        return requests;
    }

    public List<BookIssue> getBookIssues() {
        return bookIssues;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", language='" + language + '\'' +
                ", status=" + status +
                ", category=" + category +
                ", genres=" + genres.toString() +
                ", authors=" + authors.toString() +
                '}';
    }
}
