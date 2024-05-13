package com.gast.booksm.model.dto.services;

import org.springframework.stereotype.Service;

import com.gast.booksm.model.dto.book.BookDtoBase;
import com.gast.booksm.models.entities.Book;

@Service
public class BookConverter 
{

    public Book bookDtoBaseToBook(BookDtoBase dto)
    {
        Book newBook = Book.
        builder()
        .title(dto.getTitle())
        .author(dto.getAuthor())
        .isbn(dto.getIsbn())
        .availableq(true)
        .price(dto.getPrice())
        .build();

        return newBook;
    }


    

}
