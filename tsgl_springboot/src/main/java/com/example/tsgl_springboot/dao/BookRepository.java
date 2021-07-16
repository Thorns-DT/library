package com.example.tsgl_springboot.dao;

import com.example.tsgl_springboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
