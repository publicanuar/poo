package redsocial;

public class Mensaje {
    private String texto;
    private String autor;
    private Mensaje mensajeQueResponde;
    private boolean independiente;

    public Mensaje(String texto, String autor) {
        this(texto, autor, null);
    }

    public Mensaje(String texto, String autor, Mensaje mensajeQueResponde) {
        this.texto = texto;
        this.autor = autor;
        this.mensajeQueResponde = mensajeQueResponde;
        this.independiente = true;
    }

    public String getTexto() {
        return texto;
    }

    public void setIndependiente(boolean independiente) {
        this.independiente = independiente;
    }

    public String getAutor() {
        return autor;
    }

    public Mensaje getMensajeQueResponde() {
        return mensajeQueResponde;
    }

    public boolean isIndependiente() {
        return independiente;
    }


}