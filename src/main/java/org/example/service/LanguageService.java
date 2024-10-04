package org.example.service;

import org.example.entities.Language;

import java.util.*;

public class LanguageService {
    private static Map<String, Language> listaLanguages = new HashMap<>();

    public static List<Language> getOcreate (String languages){
        String[] nombreLanguages = languages.split(",");
        List<Language> listaReturn = new ArrayList<>();
        for (String nombreLanguage : nombreLanguages) {
            if (listaLanguages.containsKey(nombreLanguage)){
                listaReturn.add(listaLanguages.get(nombreLanguage));
            } else {
                Language newLanguage = new Language(nombreLanguage);
                listaLanguages.put(nombreLanguage,newLanguage);
                listaReturn.add(newLanguage);
            }
        }
        return listaReturn;
    }
}
