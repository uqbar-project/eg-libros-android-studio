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
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Libro mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LibroDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            String itemID = getArguments().getString(ARG_ITEM_ID);
            mItem = Biblioteca.getInstance().getLibro(Integer.parseInt(itemID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_libro_detail, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.libro_detail)).setText(mItem.getAutor());
            ((TextView)rootView.findViewById(R.id.titulo_libro)).setText(mItem.getTitulo());
        }

        return rootView;
    }
}
