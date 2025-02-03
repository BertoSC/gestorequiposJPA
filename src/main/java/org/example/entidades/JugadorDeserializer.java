package org.example.entidades;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JugadorDeserializer implements JsonDeserializer<List<Jugador>> {
    @Override
    public List<Jugador> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<Jugador> jugadores = new ArrayList<>();

        if (jsonElement == null || !jsonElement.isJsonObject()) {
            throw new JsonParseException("El JSON proporcionado no es válido");
        }

        JsonObject jo = jsonElement.getAsJsonObject();
        JsonArray ja = jo.has("Jugador") && jo.get("Jugador").isJsonArray() ? jo.getAsJsonArray("Jugador") : new JsonArray();

        for (JsonElement je : ja) {
            if (!je.isJsonObject()) continue;
            JsonObject objeto = je.getAsJsonObject();

            Jugador jug = new Jugador();

            double altura = getDouble(objeto, "altura", 0.0);
            int anoDraft = getInt(objeto, "anoDraft", 0);
            Long idEquipo = getLong(objeto, "idEquipo", null);
            Equipo equipo = (idEquipo != null) ? new Equipo().setIdEquipo(idEquipo) : null;
            Long idJugador = getLong(objeto, "idJugador", 0L);
            short numero = getShort(objeto, "numero", (short) 0);
            short numeroDr = getShort(objeto, "numeroDraft", (short) 0);
            double peso = getDouble(objeto, "peso", 0.0);
            String posicion = getString(objeto, "posicion", "Desconocida");
            short rondaDraft = getShort(objeto, "rondaDraft", (short) 0);
            String pais = getString(objeto, "pais", "Desconocido");
            String colegio = getString(objeto, "colegio", "Desconocido");
            String nombre = getString(objeto, "nombre", "");
            String apellido = getString(objeto, "apellido", "");
            byte[] foto = null; // No se puede obtener de JSON directamente

            jug.setAltura(altura)
                    .setAnoDraft(anoDraft)
                    .setEquipo(equipo)
                    .setIdjugador(idJugador)
                    .setNumero(numero)
                    .setNumeroDraft(numeroDr)
                    .setPeso(peso)
                    .setPosicion(posicion != null ? Posicion.getPosicion(posicion) : Posicion.getPosicion("Desconocida"))
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

    // Métodos auxiliares para manejar valores null o JsonNull
    private int getInt(JsonObject obj, String memberName, int defaultValue) {
        return (obj.has(memberName) && !obj.get(memberName).isJsonNull()) ? obj.get(memberName).getAsInt() : defaultValue;
    }

    private double getDouble(JsonObject obj, String memberName, double defaultValue) {
        return (obj.has(memberName) && !obj.get(memberName).isJsonNull()) ? obj.get(memberName).getAsDouble() : defaultValue;
    }

    private long getLong(JsonObject obj, String memberName, Long defaultValue) {
        return (obj.has(memberName) && !obj.get(memberName).isJsonNull()) ? obj.get(memberName).getAsLong() : defaultValue;
    }

    private short getShort(JsonObject obj, String memberName, short defaultValue) {
        return (obj.has(memberName) && !obj.get(memberName).isJsonNull()) ? obj.get(memberName).getAsShort() : defaultValue;
    }

    private String getString(JsonObject obj, String memberName, String defaultValue) {
        return (obj.has(memberName) && !obj.get(memberName).isJsonNull()) ? obj.get(memberName).getAsString() : defaultValue;
    }
}
