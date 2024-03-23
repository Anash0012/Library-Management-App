package com.example.Library_Management.Service;

import com.example.Library_Management.Model.Book;
import com.example.Library_Management.Model.User;
import com.example.Library_Management.Repo.BookRepo;
import com.example.Library_Management.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    BookRepo bookRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Integer id) {
        return userRepo.findById(id).orElseThrow();
    }

    public String addUser(User user) {
        userRepo.save(user);
        return "User added successfully";
    }

    public String removeUser(Integer id) {
        userRepo.deleteById(id);
        return "User removed";
    }

    public String updateUser(Integer id, User user) {
        User user1=userRepo.findById(id).orElseThrow();
        if (user1==null){
            return "user not found!!!";
        }
        user1.setName(user.getName());
        user1.setContactNumber(user.getContactNumber());
        user1.setEmailId(user.getEmailId());

        User savedUser=userRepo.save(user1);
        return "User's Data updated";
    }

    public String alloteBookToUser(Integer userId, Integer bookId) {
        User user=userRepo.findById(userId).orElse(null);
        Book book=bookRepo.findById(bookId).orElse(null);

        if (user==null||book==null||book.getUser()!=null){
            return "Invalid Input";
        }
        book.setUser(user);
        bookRepo.save(book);
        return "Book with book-id "+book.getId()+" alloted to user with user-id "+user.getId();
    }

    public String dealloteBookToUser(Integer userId, Integer bookId) {
        User user=userRepo.findById(userId).orElse(null);
        Book book=bookRepo.findById(bookId).orElse(null);

        if (user!=null&&book!=null&&book.getUser()!=null&&book.getUser().getId().equals(userId)){
            book.setUser(null);
            bookRepo.save(book);
            return "Book is taken from User";
        }
        return "Failed to deallocate book from user. User or book not found, or book is not allocated to the user.";
    }
}


