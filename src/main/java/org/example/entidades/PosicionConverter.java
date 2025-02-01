package org.example.entidades;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PosicionConverter implements AttributeConverter<Posicion,String> {
    @Override
    public String convertToDatabaseColumn(Posicion posicion) {
        return posicion.getPosicionString();
    }

    @Override
    public Posicion convertToEntityAttribute(String s) {
        return Posicion.getPosicion(s);
    }
}
