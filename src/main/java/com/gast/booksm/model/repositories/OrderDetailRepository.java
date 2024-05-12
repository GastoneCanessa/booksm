package com.gast.booksm.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gast.booksm.models.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository <OrderDetail, Integer>{

}
