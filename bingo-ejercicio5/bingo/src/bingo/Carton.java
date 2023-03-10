package bingo;

import java.util.List;

public class Carton {
    private List<Integer> numeros;
    private int tamaño;


    public Carton(List<Integer> numeros, int tamaño) {
        this.numeros = numeros;
        this.tamaño = tamaño;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    public int getTamaño() {
        return tamaño;
    }

    @Override
    public String toString() {
        return "Carton [numeros: " + numeros + ", tamaño: " + tamaño + "]";
    }
    
}
