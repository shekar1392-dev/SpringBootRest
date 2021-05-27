package com.charter.demo.charterspringdemo.DAO;

import com.charter.demo.charterspringdemo.modell.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {

    public static Map<Long, User> users=new HashMap<>();

    public static Map<Long,User> getUsers(){
        return users;
    }


}
