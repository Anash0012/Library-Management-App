package com.example.Library_Management.Controller;

import com.example.Library_Management.Model.Book;
import com.example.Library_Management.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("book/id/{id}")
    public Book getBookById(@PathVariable Integer id){
        return bookService.getBookById(id);
    }

    @PostMapping("book")
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PostMapping("books")
    public String addBooks(@RequestBody List<Book> books){
        return bookService.addBooks(books);
    }
    
    @PutMapping("book/id/{id}")
    public String updateBook(@PathVariable Integer id,@RequestBody Book book){
        return bookService.updateBook(id,book);
    }

    @DeleteMapping("book/id/{id}")
    public String deleteBook(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }

//    @GetMapping("books/author/{author}")
//    public List<Book> getBooksByAuthor(@PathVariable String author){
//        return bookService.getBookByAuthor(author);
//    }
//
//    @GetMapping("books/publisher/{publisher}")
//    public List<Book> getBooksByPublisher(@PathVariable String publisher){
//        return bookService.getBooksByPublisher(publisher);
//    }
}
