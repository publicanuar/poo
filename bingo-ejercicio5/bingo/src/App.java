import bingo.Bingo;
import bingo.Carton;

public class App {
    public static void main(String[] args) throws Exception {
        /**
         * Implementa un programa con la siguiente funcionalidad:
         * - Declara y construye un Bingo.
         * - Crea tres cartones y muestra los números en la consola.
         * - Mientras el bingo no esté finalizado:
         * o Extrae una bola y muéstrala por la consola.
         * - Si hay cartones ganadores, muestra los números del cartón por la consola.
         */

        Bingo bingo = new Bingo();

        Carton carton1 = bingo.generaCarton();
        Carton carton2 = bingo.generaCarton();
        Carton carton3 = bingo.generaCarton();

        System.out.println(carton1.toString());
        System.out.println(carton2.toString());
        System.out.println(carton3.toString());

        int bolaExtraida;
        do {
            bolaExtraida = bingo.extraerBola();
            System.out.println("Bola Extraida: " + bolaExtraida);
        } while (bolaExtraida != 0);

        System.out.println("Cartones Ganadores");

        for (Carton carton : bingo.getCartonesGanadores()) {
            System.out.println(carton.toString());
        }
    }
}
