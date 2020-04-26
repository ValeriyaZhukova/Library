package kz.iitu.library.model;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Book status")
public enum BookStatus {

    AVAILABLE,
    REQUESTED,
    ISSUED,
    OVERDUE

}
