package Senac.comidadavovo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Senac.comidadavovo.adapters.AdapterReceita;
import Senac.comidadavovo.models.Comida;
import Senac.comidadavovo.models.Ingrediente;

public class ReceitaActivity extends AppCompatActivity {

    private RecyclerView rvIngrediente;
    private TextView tvIngredientesTitulo;
    private ImageView ivComida;
    private AdapterReceita adapterReceita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receita);
        Toolbar toolbar = findViewById(R.id.tbReceita);
        setSupportActionBar(toolbar);
        rvIngrediente = findViewById(R.id.rvIngrediente);
        //tvIngredientesTitulo = findViewById(R.id.tvIngredientesTitulo);
        ivComida = findViewById(R.id.ivComida);


        Comida comida = getIntent().getExtras().getParcelable("comida");

        ivComida.setImageDrawable(getBaseContext().getResources()
                .getDrawable(comida.getFoto().getNormal(),null));

        adapterReceita = new AdapterReceita(comida.getIngredientes(),getBaseContext());

        rvIngrediente.setHasFixedSize(true);
        rvIngrediente.setLayoutManager(new LinearLayoutManager(getBaseContext(),
                RecyclerView.VERTICAL,
                false));
        rvIngrediente.setAdapter(adapterReceita);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
