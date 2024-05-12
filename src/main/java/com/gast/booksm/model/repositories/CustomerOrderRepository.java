package com.gast.booksm.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gast.booksm.models.entities.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository <CustomerOrder, Integer>{

}
