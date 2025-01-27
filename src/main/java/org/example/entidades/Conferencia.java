package org.example.entidades;

public enum Conferencia {
    ESTE("EAST"), OESTE("WEST");

    String conferenciaCadena;

    Conferencia(){}

    Conferencia(String conferenciaCadena){
        this.conferenciaCadena=conferenciaCadena;
    }

    public String getConferenciaCadena() {
        return conferenciaCadena;
    }

    public void setConferenciaCadena(String conferenciaCadena) {
        this.conferenciaCadena = conferenciaCadena;
    }

    public static Conferencia getConferencia (String conferenciaCadena){
        for (Conferencia conf: Conferencia.values()){
            if (conf.getConferenciaCadena().equals(conferenciaCadena)){
                return conf;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Conferencia{" +
                "conferenciaCadena='" + conferenciaCadena + '\'' +
                '}';
    }
}
