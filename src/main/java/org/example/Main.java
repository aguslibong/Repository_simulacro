package org.example;

import org.example.GestorArchivos.GestorTXT;
import org.example.repository.RepositoryDAO;
import org.example.service.RepositoryService;

public class Main {
    public static void main(String[] args) {
        GestorTXT.importarTXT();
        RepositoryService.getListaRepositorios().forEach(repository -> System.out.println(repository.toString()));

    }
}