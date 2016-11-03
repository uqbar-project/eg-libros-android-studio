package uqbar.libroscondescripcion.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Created by estefaniasoledadmiguel on 9/6/15.
 */
public class Libro implements Serializable {
    private int id;
    private String titulo;
    private String autor;

    public Libro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    // solo para Json.fromObject (backend en play)
    public Libro() {
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void validar() {
        assertNotEmpty(this.titulo, "Titulo es requerido");
        assertNotEmpty(this.autor, "Autor es requerido");
    }

    protected static void assertNotEmpty(String fieldValue, String message) {
        if (StringUtils.isEmpty(fieldValue)) throw new UserException(message);
    }

    @Override
    public String toString() {
        return titulo + " (" + autor + ")";
    }
}
