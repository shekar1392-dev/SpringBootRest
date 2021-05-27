package com.charter.demo.charterspringdemo.service;

import com.charter.demo.charterspringdemo.DAO.UserDAO;
import com.charter.demo.charterspringdemo.modell.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
        private Map<Long,User> users= UserDAO.getUsers();

    public UserService(){
        //User u1=new User(1L,"raja");
        User u1=new User(1L,"raja");
        User u2=new User(2l,"Shekar");
        users.put(1l,u1);
        users.put(2l,u2);


    }

    public List<User> getAllUsers(){
        return new ArrayList<User>(users.values());
    }
    public User getUserById(Long userId){
        return users.get(userId);

    }
    public User addUser(User user){
        user.setId(users.size()+1);
        users.put(user.getId(),user);
        return user;
    }
    public User updateUser(User user){
        if(user.getId()<=0){
            return null;
        }
        users.put(user.getId(),user);
        return user;
    }
    public List<User> deleteUser(Long id){
        users.remove(id);
        return new ArrayList<User>(users.values());
    }

}
