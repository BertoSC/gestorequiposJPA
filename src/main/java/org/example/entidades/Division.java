package org.example.entidades;

public enum Division {
    ATLANTICO("ATLANTIC"), CENTRAL("CENTRAL"), SURESTE("SOUTHEAST"), NOROESTE("NORTHWEST"), PACIFICO("PACIFIC"), SUROESTE("SOUTHWEST");

    String divisionCadena;

    Division(){}

    Division(String divisionCadena){
        this.divisionCadena=divisionCadena;
    }

    public String getDivisionCadena() {
        return divisionCadena;
    }

    public void setDivisionCadena(String divisionCadena) {
        this.divisionCadena = divisionCadena;
    }

    @Override
    public String toString() {
        return "Division{" +
                "divisionCadena='" + divisionCadena + '\'' +
                '}';
    }
}
