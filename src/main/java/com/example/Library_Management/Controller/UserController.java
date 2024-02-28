package com.example.Library_Management.Controller;

import com.example.Library_Management.Model.User;
import com.example.Library_Management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("user/id/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping("user")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("user/id/{id}")
    public String removeUser(@PathVariable Integer id){
        return userService.removeUser(id);
    }

    @PutMapping("user/id/{id}")
    public String updateUser(@PathVariable Integer id,@RequestBody User user){
        return userService.updateUser(id,user);
    }

    @PostMapping("user/userId/{userId}/bookId/{bookId}/allocate")
    public String alloteBookToUser(@PathVariable Integer userId,@PathVariable Integer bookId){
        return userService.alloteBookToUser(userId,bookId);
    }

    @PostMapping("user/userId/{userId}/bookId/{bookId}/deallocate")
    public String dealloteBookFromUser(@PathVariable Integer userId,@PathVariable Integer bookId){
        return userService.dealloteBookToUser(userId,bookId);
    }
}
