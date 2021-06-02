package com.example.demo.dao;

import com.example.demo.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.persistence.Id;

public interface BookRepository extends MongoRepository<Book,Integer>{
  public Book findById(int id);



}
