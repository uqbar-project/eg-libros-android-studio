package uqbar.librosconrest.service;

import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;
import uqbar.librosconrest.model.Libro;

/**
 * Created by estefaniamiguel on 16/6/15. Enjoy!
 */
public interface LibrosService {
    @GET("/libros")
    void getLibros(Callback<List<Libro>> callback);

    @GET("/libros/{LibroId}")
    void getLibro(@retrofit.http.Path("LibroId") String id, Callback<Libro> callback);
}
