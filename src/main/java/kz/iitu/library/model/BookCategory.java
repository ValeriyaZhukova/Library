package kz.iitu.library.model;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Book type")
public enum BookCategory {

    PROSE,
    DRAMA,
    POETRY,
    FICTION,
    NONFICTION

}
