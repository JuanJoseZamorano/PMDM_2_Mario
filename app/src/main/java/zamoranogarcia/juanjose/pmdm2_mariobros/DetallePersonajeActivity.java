package zamoranogarcia.juanjose.pmdm2_mariobros;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetallePersonajeActivity extends AppCompatActivity {

    private ImageView imageViewDetallePersonaje;
    private TextView textViewNombreDetalle, textViewDescripcion, textViewHabilidades;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_personaje);

        // Vincular vistas
        imageViewDetallePersonaje = findViewById(R.id.imageViewDetallePersonaje);
        textViewNombreDetalle = findViewById(R.id.textViewNombreDetalle);
        textViewDescripcion = findViewById(R.id.textViewDescripcion);
        textViewHabilidades = findViewById(R.id.textViewHabilidades);

        // Obtener los datos del Intent
        Intent intent = getIntent();
        if (intent != null) {
            String nombre = intent.getStringExtra("nombre");
            int imagen = intent.getIntExtra("imagen", 0);
            String descripcion = intent.getStringExtra("descripcion");
            String habilidades = intent.getStringExtra("habilidades");

            // Mostrar datos en las vistas
            textViewNombreDetalle.setText(nombre);
            imageViewDetallePersonaje.setImageResource(imagen);
            textViewDescripcion.setText(descripcion);
            textViewHabilidades.setText(habilidades);

            // Mostrar Toast
            Toast.makeText(this, "Detalles cargados para " + nombre, Toast.LENGTH_SHORT).show();
        }
    }
}
