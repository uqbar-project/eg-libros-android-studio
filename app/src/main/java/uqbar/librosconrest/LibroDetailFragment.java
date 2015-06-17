package uqbar.librosconrest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import uqbar.librosconrest.model.Libro;
import uqbar.librosconrest.service.LibrosService;

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
            obtenerLibro(itemID);
        }
    }

    private void obtenerLibro(String libroId) {
        LibrosService librosService = createLibrosService();
        librosService.getLibro(libroId, new Callback<Libro>() {
            @Override
            public void success(Libro libro, Response response) {
                mostrarLibro(libro);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("", error.getMessage());
                error.printStackTrace();
            }
        });
    }

    private void mostrarLibro(Libro libro) {
        ((TextView) this.getView().findViewById(R.id.libro_detail)).setText(libro.getTitulo());
        ((TextView) this.getView().findViewById(R.id.titulo_libro)).setText(libro.getAutor());
    }

    private LibrosService createLibrosService() {
        //MMM código repetido, habría que modificar esto no?
        String SERVER_IP = "10.0.2.2"; //esta ip se usa para comunicarse con mi localhost en el emulador de Android Studio
        String SERVER_IP_GENY = "192.168.56.1";//esta ip se usa para comunicarse con mi localhost en el emulador de Genymotion
        String API_URL = "http://"+ SERVER_IP_GENY +":9000";

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        LibrosService librosService = restAdapter.create(LibrosService.class);
        return librosService;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_libro_detail, container, false);
        return rootView;
    }
}
