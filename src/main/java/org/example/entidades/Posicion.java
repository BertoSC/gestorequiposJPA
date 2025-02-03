package org.example.entidades;

public enum Posicion {
    BASE("G"), ESCOLTA("C"), ALERO("F"), ALAPIVOT("F-C"), PIVOT("C-F"), DESCONOCIDA("Desconocida");

    String posicionString;

    Posicion(String pos){
        this.posicionString=pos;
    }

    public String getPosicionString() {
        return posicionString;
    }

    public void setPosicionChar(String posicionChar) {
        this.posicionString = posicionChar;
    }

    public static Posicion getPosicion (String posicionString){
        for (Posicion pos: Posicion.values()){
            if (pos.getPosicionString().equals(posicionString)){
                return pos;
            }
        }
        return Posicion.DESCONOCIDA;
    }

}
