package org.example.entidades;

public enum Division {
    ATLANTICO("ATLANTIC"), CENTRAL("CENTRAL"), SURESTE("SOUTHEAST"), NOROESTE("NORTHWEST"), PACIFICO("PACIFIC"), SUROESTE("SOUTHWEST");

    String divisionCadena;

    Division(){}

    Division(String divisionCadena){
        this.divisionCadena=divisionCadena;
    }

    public static Division getDivision(String divisionCadena){
        for (Division div: Division.values()){
            if (div.getDivisionCadena().equalsIgnoreCase(divisionCadena)){
                return div;
            }
        }
        return null;
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
