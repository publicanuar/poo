import java.util.List;

import redsocial.Mensaje;
import redsocial.Panel;

public class App {

    public static void main(String[] args) {
        Panel panel1 = new Panel("Ernesto");

        Mensaje mensaje1 = panel1.publicarMensaje("Busco programador/a Java");
        Mensaje mensaje2 = panel1.publicarMensaje("Tengo la certificación Java SE Programmer I", "Antonio", mensaje1);
        panel1.publicarMensaje("Tengo cinco años de experiencia", "Marta", mensaje1);

        List<Mensaje> respuestas = panel1.consultarRespuestas(mensaje1);

        System.out.println("Respuestas al mensaje: " + mensaje1.getTexto() + ",Del autor: " + mensaje1.getAutor());

        for (Mensaje respuesta : respuestas) {
            System.out.println("\tRespuesta: " + respuesta.getTexto() + ", Del autor: " + respuesta.getAutor());
        }

        boolean mensajeBorrado1 = panel1.borrarMensaje(mensaje1);
        System.out
                .println("\nEl mensaje: " + mensaje1.getTexto() + " ¿fue borrado? " + (mensajeBorrado1 ? "Si" : "No"));

        boolean mensajeBorrado2 = panel1.borrarMensaje(mensaje2);
        System.out
                .println("\nEl mensaje: " + mensaje2.getTexto() + " ¿fue borrado? " + (mensajeBorrado2 ? "Si" : "No"));

        System.out.println("\nMensajes del Panel");
        for (Mensaje mensaje : panel1.getMensajes()) {
            System.out.println("\tMensaje: " + mensaje.getTexto() + ", Del autor: " + mensaje.getAutor());
        }
    }
}
