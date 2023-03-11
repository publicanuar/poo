package redsocial;

import java.util.ArrayList;
import java.util.List;

public class Panel {
    private String propietario;
    private List<Mensaje> mensajes;

    public Panel(String propietario) {
        this.propietario = propietario;
        this.mensajes = new ArrayList<Mensaje>();
    }

    public List<Mensaje> consultarRespuestas(Mensaje mensaje) {

        List<Mensaje> mensajesQueResponden = new ArrayList<Mensaje>();

        if (mensaje.isIndependiente())
            return mensajesQueResponden;

        for (Mensaje mensaje2 : this.getMensajes()) {
            if (mensaje2.getMensajeQueResponde() == mensaje) {
                mensajesQueResponden.add(mensaje2);
            }
        }

        return mensajesQueResponden;
    }

    public boolean borrarMensaje(Mensaje mensaje) {
        if (this.consultarRespuestas(mensaje).size() > 0)
            return false;
        return this.getMensajes().remove(mensaje);
    }

    public Mensaje publicarMensaje(String texto, String autor, Mensaje mensajeQueResponde) {
        if (this.cumpleRequisitosPublicacion(autor, mensajeQueResponde)
                || this.getMensajes().contains(mensajeQueResponde)) {
            mensajeQueResponde.setIndependiente(false);
            Mensaje mensaje = new Mensaje(texto, autor, mensajeQueResponde);
            this.getMensajes().add(mensaje);
            return mensaje;
        }
        return null;
    }

    public Mensaje publicarMensaje(String texto) {
        Mensaje mensaje = new Mensaje(texto, this.getPropietario(), null);
        this.getMensajes().add(mensaje);
        return mensaje;
    }

    private boolean cumpleRequisitosPublicacion(String autor, Mensaje mensajeQueResponde) {
        return mensajeQueResponde == null && autor.equals(this.getPropietario());
    }

    public String getPropietario() {
        return propietario;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }
}
