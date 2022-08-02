package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    private static Map<Integer, User> userDB;

    @PostConstruct
    public void init() throws Exception {
        userDB = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            User student = new User(i);
            userDB.put(i, new User(i));
        }
    }

    public List<User> getAll(){
        List<User> userList = userDB.entrySet().stream()
                .map(Map.Entry::getValue).collect(Collectors.toList());
        return userList;
    }

    public User getUserById(Integer userId) {
        return userDB.get(userId);
    }

    public User getFirstbyAge(Integer age) {
        return userDB.get(age);
    }
}