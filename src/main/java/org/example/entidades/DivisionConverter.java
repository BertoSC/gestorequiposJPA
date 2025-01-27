package org.example.entidades;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DivisionConverter implements AttributeConverter<Division, String> {
    @Override
    public String convertToDatabaseColumn(Division division) {
        return division.getDivisionCadena();
    }

    @Override
    public Division convertToEntityAttribute(String s) {
        return Division.getDivision(s);
    }
}
