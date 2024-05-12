package com.gast.booksm.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gast.booksm.models.entities.Book;

public interface BookRepository extends JpaRepository <Book, Integer>
{

}
