package com.example.Library_Management.Service;

import com.example.Library_Management.Model.Book;
import com.example.Library_Management.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(Integer id) {
        return bookRepo.findById(id).orElseThrow();
    }

    public String addBook(Book book) {
        bookRepo.save(book);
        return "Book Added Successfully";
    }

    public String addBooks(List<Book> books) {
        bookRepo.saveAll(books);
        return books.size()+" books were added successfully";
    }

    public String updateBook(Integer id, Book book) {
        Book book1=bookRepo.findById(id).orElseThrow();
        if (book1==null){
            return "book not found!!!";
        }
        book1.setAuthor(book.getAuthor());
        book1.setIsbn(book.getIsbn());
        book1.setName(book.getName());
        book1.setUser(book.getUser());
        book1.setPublisher(book.getPublisher());

        Book savedBook=bookRepo.save(book1);
        return "Book Updated";
    }

    public String deleteBook(Integer id) {
        bookRepo.deleteById(id);
        return "Book Deleted";
    }

//    public List<Book> getBookByAuthor(String author) {
//        return bookRepo.findByAuthor(author);
//    }
//
//    public List<Book> getBooksByPublisher(String publisher) {
//        return bookRepo.findByPublisher(publisher);
//    }
}
