package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jdk.swing.interop.SwingInterOpUtils;
import org.example.entidades.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class GestorNbaAPP {
    static Boolean funcionando = false;
    public static void main(String[] args) {

       Type listType = new TypeToken<List<Equipo>>() {}.getType();
       Type jugListType = new TypeToken<List<Jugador>>(){}.getType();
       EntityManagerFactory enf = JpaNbaManager.getEntityManagerFactory("gestorequiposH2");
       EntityManager em = enf.createEntityManager();
       EquipoDAO equipoDAO = new EquipoDAO(em);
       JugadorDAO jugadorDAO = new JugadorDAO(em);

       Gson gson = new GsonBuilder()
                .registerTypeAdapter(listType, new EquipoDeserializer())
               .registerTypeAdapter(jugListType, new JugadorDeserializer())
                .setPrettyPrinting()
                .create();

        Path url = Paths.get("src\\main\\resources\\equipos.json");
        Path urlJug = Paths.get("src\\main\\resources\\jugadores.json");
        try {
            String json = Files.readString(url);
            List <Equipo> equipos = gson.fromJson(json, listType);
            for (Equipo eq: equipos){
                equipoDAO.save(eq);
            }

            String jsonJug = Files.readString(urlJug);
            List <Jugador> jugadores = gson.fromJson(jsonJug, jugListType);

            for (Jugador ju: jugadores){
                jugadorDAO.save(ju);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void menu(){
        funcionando = true;
        while (funcionando){
            System.out.println("GESTOR DE LA NBA");
            System.out.println("1. Añadir un equipo");
            System.out.println("2. Añadir un entrenador");
            System.out.println("3. Asignar entrenador a equipo");
            System.out.println("4. Asignar equipo a entrenador");
            System.out.println("5. Mostrar datos de un equipo y su entrenador");
            System.out.println("6. Salir de la APP");
            System.out.println("ESCOJE UNA OPCIÓN: ");

            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:
                    añadirEquipo(sc);
                    break;
                case 2:
                    añadirEntrenador(sc);
                    break;
                case 3:
                    asignarEntrenador(sc);
                    break;
                case 4:
                    asignarEquipo(sc);
                    break;
                case 5:
                    mostrarEqEntren(sc);
                    break;
                case 6:
                    System.out.println("Cerrando APP...");
                    funcionando=false;
                    break;
            }



        }
    }

    private static void mostrarEqEntren(Scanner sc) {
    }

    private static void asignarEquipo(Scanner sc) {
    }

    private static void asignarEntrenador(Scanner sc) {
    }

    private static void añadirEntrenador(Scanner sc) {
    }

    private static void añadirEquipo(Scanner sc) {
        System.out.println("Introduce el ID de Equipo");
        Long idEquipo = sc.nextLong();
        System.out.println("Introduce el nombre");
        String nombre = sc.nextLine();
        System.out.println("Introduce la ciudad");
        String ciudad = sc.nextLine();
        System.out.println("Introduce la conferencia (EAST-WEST");
        String conferencia = sc.nextLine();
        System.out.println("Introduce la división(ATLANTIC-CENTRAL-SOUTHEAST-NORTHWEST-PACIFIC-SOUTHWEST)");
        String division = sc.nextLine();
        System.out.println("Introduce el nombre completo");
        String nombreCompleto =sc.nextLine();
        System.out.println("Introduce la abreviatura");
        String abreviatura=sc.nextLine();
    }


}