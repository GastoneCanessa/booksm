package com.gast.booksm.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gast.booksm.models.entities.User;

public interface UserRepository extends JpaRepository <User, Integer>{

}
