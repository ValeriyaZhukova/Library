package kz.iitu.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "requests", "bookIssues"})
@ApiModel(description="Book model")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private int publicationYear;
    @NonNull
    private String language;
    @NonNull
    @ApiModelProperty(dataType = "string", value = "Book status", allowableValues = "AVAILABLE, REQUESTED,  ISSUED, OVERDUE")
    private Enum status;
    @NonNull
    @ApiModelProperty(dataType = "string", value = "Book type", allowableValues = "PROSE, DRAMA, POETRY, FICTION, NONFICTION")
    private Enum category;

    @ApiModelProperty(value = "List of book genres")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_genres",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id", referencedColumnName = "id")}
    )
    private List<Genre> genres = new ArrayList<>();

    @ApiModelProperty(value = "List of book authors")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_authors",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")}
    )
    private List<Author> authors = new ArrayList<>();

    @ApiModelProperty(value = "List of book requests")
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<BookRequest> requests = new ArrayList<>();

    @ApiModelProperty(value = "List of book issues")
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<BookIssue> bookIssues = new ArrayList<>();

}
