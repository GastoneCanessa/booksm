package com.gast.booksm.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gast.booksm.model.dto.book.BookDtoBase;
import com.gast.booksm.model.dto.book.BookPutRqst;
import com.gast.booksm.model.dto.services.BookConverter;
import com.gast.booksm.model.repositories.BookRepository;
import com.gast.booksm.models.entities.Book;

public class BookController {

    @Autowired
    BookRepository bRepo;

    @Autowired
    BookConverter bConv;

    @PostMapping("/book")
    public ResponseEntity<?> postBook(@RequestBody BookDtoBase bookDto)
    {
        Optional<Book> opBook = bRepo.findByIsbn(bookDto.getIsbn());

        if(opBook.isPresent())
        {
            return new ResponseEntity<String>("Book already exist", HttpStatus.BAD_REQUEST);
        }

        Book newBook = bConv.bookDtoBaseToBook(bookDto);
        Book savedBook = bRepo.save(newBook);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @GetMapping("/books")
    public List<Book> getBooks()
    {
        return bRepo.findAll();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBook(@PathVariable Integer id)
    {
        Optional<Book> opBook = bRepo.findById(id);

        if(opBook.isPresent())
        {
            return ResponseEntity.ok(opBook.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<?> putBook(@PathVariable Integer id, @RequestBody BookPutRqst bookPutRqst)
    {
        Optional<Book> opBook = bRepo.findById(id);

        if(opBook.isPresent())
        {
            Book book = opBook.get();
            book.setAuthor(bookPutRqst.getAuthor());
            book.setAvailableq(bookPutRqst.getAvailableq());
            book.setIsbn(bookPutRqst.getIsbn());
            book.setTitle(bookPutRqst.getTitle());
            book.setPrice(bookPutRqst.getPrice());

            Book modBook = bRepo.save(book);

            return new ResponseEntity<Book>(modBook, HttpStatus.OK);
        }

        return new ResponseEntity<String>("No book with id " + id, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id)
    {
        Optional<Book> opBook = bRepo.findById(id);

        if(opBook.isPresent())
        {
            bRepo.deleteById(id);

            return new ResponseEntity<String>("Book deleted", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Book not found", HttpStatus.NOT_FOUND);
    }

}
