package org.example.entities;

import jakarta.persistence.*;

@Entity
public class Language {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id_language;
    @Column
    private String name;

    public Language() {
    }

    public Language(String id_language) {
        this.name = id_language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Language{" +
                "name='" + name + '\'' +
                '}';
    }
}
