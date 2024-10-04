package org.example.GestorArchivos;

import org.example.service.RepositoryService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

public class GestorTXT {
    private static final String REPOSITORY_PATH = "D:\\UTN\\2024\\Backend\\Simulacro\\REPOSITORY_Simulacro\\src\\main\\resources\\REPOSITORIES-catedra.txt";
    public static void importarTXT() {
        try (BufferedReader reader = new BufferedReader(new FileReader(REPOSITORY_PATH))) {
            String linea = reader.readLine();
            while ((linea = reader.readLine()) != null) {
                //System.out.println(linea);
                RepositoryService.crearRepository(linea);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
