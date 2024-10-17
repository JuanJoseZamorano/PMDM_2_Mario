package zamoranogarcia.juanjose.pmdm2_mariobros;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PersonajeAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private PersonajeAdapter adapter;
    private List<Personaje> personajeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerViewPersonajes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar lista de personajes
        personajeList = new ArrayList<>();
        personajeList.add(new Personaje("Mario", R.drawable.mario, "Héroe del juego. Personaje principal", "Salto y rapidez"));
        personajeList.add(new Personaje("LuigUi", R.drawable.luigui, "Hermano de Mario", "Inteligente y cauto con los saltos"));
        personajeList.add(new Personaje("Peach", R.drawable.peach, "Amiga incondicional de Mario", "Habilidad y persuasión contra los malvados."));
        personajeList.add(new Personaje("Toad", R.drawable.toad, "Héroe del reino Champiñón", "Salto y velocidad infinita"));

        // Configurar el adapter
        adapter = new PersonajeAdapter(this, personajeList, this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onItemClick(Personaje personaje) {
        // Mostrar un Toast con el personaje seleccionado
        Toast.makeText(this, "Se ha seleccionado el personaje " + personaje.getNombre(), Toast.LENGTH_SHORT).show();

        // Abrir una nueva actividad para mostrar los detalles del personaje
//        Intent intent = new Intent(this, DetallePersonajeActivity.class);
//        intent.putExtra("nombre", personaje.getNombre());
//        intent.putExtra("imagen", personaje.getImagen());
//        startActivity(intent);
    }



}