package com.example.tsgl_springboot.dao;

import com.example.tsgl_springboot.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());
    }

    @Test
    void save(){
        Book book =new Book();
        book.setName("springboot");
        book.setAuthor("张三");
        Book book1=bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
     void findById(){
        Book book=bookRepository.findById(1).get();
        System.out.println(book);
     }

     @Test
     void update(){
        Book book=new Book();
        book.setId(18);
        book.setName("测试");
        Book book1=bookRepository.save(book);
         System.out.println(book1);
     }

     @Test
     void delete(){
        bookRepository.deleteById(18);
     }
}