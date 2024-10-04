package org.example.service;

import org.example.entities.Language;
import org.example.entities.Repository;
import org.example.entities.Tag;
import org.example.entities.User;
import org.example.repository.RepositoryDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class RepositoryService {
    private static List<Repository> listaRepositorios = new ArrayList<>();


    public static void crearRepository (String linea) throws ParseException {
        String[] atributos = linea.split("\\|");
        //REPOSITORY_ID|USER_NAME|REPOSITORY_NAME|DESCRIPTION|LAST_UPDATE|LANGUAGE|STARS|TAGS|URL
        int REPOSITORY_ID = Integer.parseInt(atributos[0]);
        User USER_NAME = UserService.getoCreate(atributos[1]);
        String REPOSITORY_NAME = atributos[2];
        String DESCRIPTION = atributos[3];
        int LAST_UPDATE = gestorFecha(atributos[4]);
        List<Language> LANGUAGE = LanguageService.getOcreate(atributos[5]);
        float STARS = gestorStart(atributos[6]);
        List<Tag> TAGS = TagService.getOcreate(atributos[7]);
        String URL = atributos[8];

        Repository nuevoRepository = new Repository(REPOSITORY_ID,REPOSITORY_NAME,DESCRIPTION,LAST_UPDATE,STARS,URL,USER_NAME,TAGS,LANGUAGE);
        listaRepositorios.add(nuevoRepository);
        //RepositoryDAO.saveRepository(nuevoRepository);
    }

    public static List<Repository> getListaRepositorios() {
        return listaRepositorios;
    }

    private static float gestorStart (String start) {
        return  (Float.parseFloat(start)/100) * 5;
    }

    private static int gestorFecha (String fecha) throws ParseException {
        String[] fechavector = fecha.split("T");
        String[] fechaimportantevector = fechavector[0].split("-");
        for (String s : fechaimportantevector) {
            System.out.println(s);
        }
        LocalDate fechavieja = LocalDate.of(Integer.parseInt(fechaimportantevector[0]),Integer.parseInt(fechaimportantevector[1]),Integer.parseInt(fechaimportantevector[2]));
        LocalDate fechaHoy = LocalDate.now();
        Period periodo = Period.between(fechaHoy, fechavieja);
        return periodo.getDays();
    }
}
