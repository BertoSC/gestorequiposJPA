package org.example.entidades;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;

@Converter(autoApply = true)

public class ConferenciaConverter implements AttributeConverter<Conferencia, String>{
    @Override
    public String convertToDatabaseColumn(Conferencia conferencia) {
        return conferencia.getConferenciaCadena();
    }

    @Override
    public Conferencia convertToEntityAttribute(String s) {
        return Conferencia.getConferencia(s);
    }
}
