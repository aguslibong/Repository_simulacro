package org.example.service;

import org.example.entities.Language;
import org.example.entities.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagService {
    private static Map<String, Tag> listaTag = new HashMap<>();

    public static List<Tag> getOcreate (String tags){
        String[] nombreTags = tags.split(",");
        List<Tag> listaReturn = new ArrayList<>();
        for (String nombre : nombreTags) {
            if (listaTag.containsKey(nombre)){
                listaReturn.add(listaTag.get(nombre));
            } else {
                Tag newTag = new Tag(nombre);
                listaTag.put(nombre,newTag);
                listaReturn.add(newTag);
            }
        }
        return listaReturn;
    }
}
