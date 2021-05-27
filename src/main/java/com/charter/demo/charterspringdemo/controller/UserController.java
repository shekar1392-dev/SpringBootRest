package com.charter.demo.charterspringdemo.controller;


import com.charter.demo.charterspringdemo.modell.User;
import com.charter.demo.charterspringdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
   @GetMapping(value="/getUserById/{id}")
    public User getUserById(@PathVariable(value = "id") Long id){
        return userService.getUserById(id);
    }
    @PostMapping(value="/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @PutMapping(value="/updateUser/{id}")
    public ResponseEntity updateUser(@PathVariable(value="id") Long id, @RequestBody User user){
        User currentUser=userService.getUserById(id);
        if(currentUser==null){
            return new ResponseEntity("User Not Found", HttpStatus.NOT_FOUND);
                    }
        currentUser.setName(user.getName());
        return new ResponseEntity<User>(currentUser,HttpStatus.OK);

    }
    @DeleteMapping(value="/deleteUser/{id}")
    public ResponseEntity deleteUserById(@PathVariable(value="id") Long id){
        User currentUser=userService.getUserById(id);
        if(currentUser==null){
            return new ResponseEntity("User Not Found", HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(id);
        return new ResponseEntity("User Deleted", HttpStatus.OK);
    }
}
