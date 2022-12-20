package com.crud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.entites.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
