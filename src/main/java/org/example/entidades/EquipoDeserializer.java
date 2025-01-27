package org.example.entidades;

import com.google.gson.*;
import org.h2.util.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EquipoDeserializer implements JsonDeserializer<List<Equipo>> {
    @Override
    public List <Equipo> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List <Equipo> equipos = new ArrayList<>();
        JsonObject jo = jsonElement.getAsJsonObject();
        JsonArray ja = jo.get("Equipo").getAsJsonArray();
        for (JsonElement je:ja){
            JsonObject objeto = je.getAsJsonObject();
            Equipo equipo = new Equipo();
            equipo.setIdEquipo(objeto.get("idEquipo").getAsLong());
            equipo.setAbreviatura(objeto.get("abreviatura").getAsString());
            equipo.setCiudad(objeto.get("ciudad").getAsString());
            equipo.setNombre(objeto.get("nombre").getAsString());
            equipo.setNombreCompleto(objeto.get("nombreCompleto").getAsString());
            String confString = objeto.get("conferencia").getAsString();
            equipo.setConferencia(Conferencia.getConferencia(confString));
            String division = objeto.get("division").getAsString();
            equipo.setDivision(Division.getDivision(division));

            equipos.add(equipo);
        }

        return equipos;
    }
}
