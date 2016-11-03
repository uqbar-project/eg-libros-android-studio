package uqbar.libroscondescripcion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import uqbar.libroscondescripcion.model.Biblioteca;
import uqbar.libroscondescripcion.model.Libro;

/**
 * A fragment representing a single Libro detail screen.
 * This fragment is either contained in a {@link LibroListActivity}
 * in two-pane mode (on tablets) or a {@link LibroDetailActivity}
 * on handsets.
 */
public class LibroDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_BOOK = "book";

    /**
     * The dummy content this fragment is presenting.
     */
    private Libro libro;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LibroDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_BOOK)) {
            libro = (Libro) getArguments().getSerializable(ARG_BOOK);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_libro_detail, container, false);

        if (libro != null) {
            ((TextView)rootView.findViewById(R.id.libro_detail)).setText(libro.getAutor());
            ((TextView)rootView.findViewById(R.id.titulo_libro)).setText(libro.getTitulo());
        }

        return rootView;
    }
}
