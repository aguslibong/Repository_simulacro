package org.example.entities;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id_user;
    @Column
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
