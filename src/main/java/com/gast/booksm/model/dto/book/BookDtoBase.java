package com.gast.booksm.model.dto.book;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BookDtoBase {
    private String title;
    private String author;
    private String isbn;
    private BigDecimal price;
}
