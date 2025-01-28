package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import jakarta.persistence.EntityManagerFactory;
import org.example.entidades.Equipo;
import org.example.entidades.EquipoDAO;
import org.example.entidades.EquipoDeserializer;
import org.example.entidades.JpaNbaManager;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GestorNbaAPP {
    public static void main(String[] args) {

       Type listType = new TypeToken<List<Equipo>>() {}.getType();
       EntityManagerFactory enf = JpaNbaManager.getEntityManagerFactory("gestorequiposH2");
       EquipoDAO equipoDAO = new EquipoDAO(enf.createEntityManager());
       Gson gson = new GsonBuilder()
                .registerTypeAdapter(listType, new EquipoDeserializer())
                .setPrettyPrinting()
                .create();

        Path url = Paths.get("src\\main\\resources\\equipos.json");
        try {
            String json = Files.readString(url);
            List <Equipo> equipos = gson.fromJson(json, listType);
            for (Equipo eq: equipos){
                equipoDAO.save(eq);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}