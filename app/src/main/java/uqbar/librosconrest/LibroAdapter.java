package uqbar.librosconrest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import uqbar.librosconrest.model.Libro;

/**
 * Created by estefaniamiguel on 17/6/15. Enjoy!
 */
public class LibroAdapter extends AbstractListAdapter<Libro> {

    public LibroAdapter(Context context, List<Libro> libros) {
        super(context, libros);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Libro libro = (Libro) getItem(position);
        View row = generateRow(R.layout.libro_row, parent);
        setColumnTextView(row, R.id.txtTitulo, libro.getTitulo());
        setColumnTextView(row, R.id.txtAutor, libro.getAutor());
        return row;
    }
}
