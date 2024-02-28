package com.example.Library_Management.Repo;

import com.example.Library_Management.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
//    List<Book> findByAuthor(String author);
//
//    List<Book> findByPublisher(String publisher);
}
