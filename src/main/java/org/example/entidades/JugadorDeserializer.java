package org.example.entidades;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JugadorDeserializer implements JsonDeserializer <List<Jugador>> {
    @Override
    public List<Jugador> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List <Jugador> jugadores = new ArrayList<>();
        JsonObject jo = jsonElement.getAsJsonObject();
        JsonArray ja = jo.get("Jugador").getAsJsonArray();
        for (JsonElement je: ja){
            JsonObject objeto = je.getAsJsonObject();
            Jugador jug = new Jugador();
            double altura = objeto.get("altura").getAsDouble();
            int anoDraft = objeto.get("anoDraft").getAsInt();
            Long idEquipo = objeto.get("idEquipo").getAsLong();
            Equipo equipo = new Equipo().setIdEquipo(idEquipo);
            Long idJugador = objeto.get("idJugador").getAsLong();
            short numero = objeto.get("numero").getAsShort();
            short numeroDr = objeto.get("numeroDraft").getAsShort();
            double peso = objeto.get("peso").getAsDouble();
            String posicion = objeto.get("posicion").getAsString();
            short rondaDraft = objeto.get("rondaDraft").getAsShort();
            String pais = objeto.get("pais").getAsString();
            String colegio = objeto.get("colegio").getAsString();
            String nombre = objeto.get("nombre").getAsString();
            String apellido = objeto.get("apellido").getAsString();
            byte [] foto = null;
            jug.setAltura(altura)
                    .setAnoDraft(anoDraft)
                    .setEquipo(equipo)
                    .setIdjugador(idJugador)
                    .setNumero(numero)
                    .setNumeroDraft(numeroDr)
                    .setPeso(peso)
                    .setPosicion(Posicion.getPosicion(posicion))
                    .setRondaDraft(rondaDraft)
                    .setPais(pais)
                    .setColegio(colegio)
                    .setNombre(nombre)
                    .setApellidos(apellido)
                    .setFoto(foto);
            jugadores.add(jug);
        }
        return jugadores;
    }
}
