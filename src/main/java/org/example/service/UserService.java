package org.example.service;

import org.example.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static Map<String, User> listaUsers = new HashMap<>();


    public static User getoCreate (String User){
        User userEncontrado = listaUsers.get(User);
        if (userEncontrado != null){
            return userEncontrado;
        } else {
            User userNuevo = new User(User);
            listaUsers.put(User, userNuevo);
            return userNuevo;
        }

    }
}
