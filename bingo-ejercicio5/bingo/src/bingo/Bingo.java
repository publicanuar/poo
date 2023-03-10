package bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bingo {
    private List<Integer> bombo;
    private static final int BOLA_MAYOR = 30;
    private List<Integer> bolasExtraidas;
    private static final int TAMAÑO_CARTON_DEFECTO = 9;
    private List<Carton> cartonesDelBingo;
    private List<Carton> cartonesGanadores;
    private boolean finalizado;

    public Bingo() {
        this.bombo = this.todosLosNumeros();
        this.bolasExtraidas = new ArrayList<Integer>();
        this.cartonesDelBingo = new ArrayList<Carton>();
        this.cartonesGanadores = new ArrayList<Carton>();
        this.finalizado = false;
    }

    public List<Integer> getBombo() {
        return bombo;
    }

    public List<Integer> getBolasExtraidas() {
        return bolasExtraidas;
    }

    public List<Carton> getCartonesDelBingo() {
        return cartonesDelBingo;
    }

    public List<Carton> getCartonesGanadores() {
        return cartonesGanadores;
    }

    public boolean isFinalizado() {
        return this.getCartonesGanadores().size() > 0;
    }

    /**
     * Comprobar cartón: esta operación comprueba si el cartón establecido como
     * parámetro
     * es un “bingo”. Para ello consulta si todos los números del cartón están
     * contenidos en
     * la lista bolas extraídas. La operación retorna el valor booleano verdadero en
     * caso de
     * que sea bingo, falso en caso contrario.
     */
    private boolean comprobarCarton(Carton carton) {
        for (int numero : carton.getNumeros()) {
            if (!this.getBolasExtraidas().contains(numero))
                return false;
        }
        return true;
    }

    /*
     * Generar un cartón. Esta operación tiene como objetivo generar un nuevo cartón
     * y
     * retornarlo. Los pasos que realiza son:
     * - Construye una lista con todas las posibles bolas del bingo (números desde 1
     * hasta bola mayor). A esta lista la denominamos todos los números.
     * - Mezcla el contenido de esa lista utilizado el método static
     * java.util.Collections.shuffle.
     * - Construye una nueva lista vacía. Denominamos a esta lista números cartón.
     * - Realiza un bucle desde 1 hasta tamaño del cartón donde en cada paso:
     * ▪ Saca el primer elemento de la lista todos los números.
     * ▪ Introduce el elemento en la lista números cartón.
     * - Construye un cartón con la lista números cartón.
     * - Añade el cartón a la lista cartones del bingo.
     * - Por último, retorna el cartón.
     */
    private ArrayList<Integer> todosLosNumeros() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= BOLA_MAYOR; i++) {
            list.add(i);
        }
        return list;
    }

    public Carton generaCarton() {
        List<Integer> todosLosNumeros = this.todosLosNumeros();
        Collections.shuffle(todosLosNumeros);
        List<Integer> numerosCarton = new ArrayList<Integer>();

        for (int i = 0; i < TAMAÑO_CARTON_DEFECTO; i++) {
            numerosCarton.add(todosLosNumeros.get(i));
        }

        Carton carton = new Carton(numerosCarton, TAMAÑO_CARTON_DEFECTO);
        this.getCartonesDelBingo().add(carton);
        return carton;
    }

    /*
     * 
     * Extraer una bola. Esta operación se encarga de extraer una bola del bingo. La
     * bola
     * extraída será el valor devuelto por la operación. Los pasos que realiza son:
     * o Si el bingo está finalizado, la operación retorna el valor 0 como marca de
     * error.
     * o Utiliza el método java.util.Collections.shuffle para mezclar la lista del
     * bombo.
     * o Extrae el primer número de la lista bombo (lo obtiene y lo borra). Este
     * número corresponde con la bola extraída.
     * o Añade el número a la lista bolas extraídas.
     * o Recorre la lista de cartones y comprueba si alguno tiene bingo. En caso
     * afirmativo, añade el cartón a la lista de cartones ganadores.
     * o Por último, retorna la bola extraída
     */

    public int extraerBola() {
        if (this.isFinalizado())
            return 0;

        Collections.shuffle(this.getBombo());

        int bolaExtraida = this.getBombo().get(0);
        this.getBombo().remove(0);
        this.getBolasExtraidas().add(bolaExtraida);
        if (this.getBombo().size() == 0 ) {
            this.setFinalizado(true);
        }

        for (Carton carton : this.getCartonesDelBingo()) {
            if (this.comprobarCarton(carton)) {
                this.getCartonesGanadores().add(carton);
                this.setFinalizado(true);
            }
            
        }

        return bolaExtraida;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}
