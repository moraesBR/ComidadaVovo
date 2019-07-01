package Senac.comidadavovo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Senac.comidadavovo.adapters.AdapterComida;
import Senac.comidadavovo.models.Comida;
import Senac.comidadavovo.models.MenuComidas;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvComidas;
    private MenuComidas comidas;
    private List<Comida> listComida = new ArrayList<>();
    private AdapterComida adapterComida;
    private RecyclerView.LayoutManager layout;
    private Spinner spFiltro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        comidas = new MenuComidas();
        comidas.setComidas();

        listComida = comidas.getComidas();
        adapterComida = new AdapterComida(listComida,getBaseContext());

        rvComidas = findViewById(R.id.rvComidas);
        rvComidas.setHasFixedSize(true);

        layout = new LinearLayoutManager(getBaseContext(),RecyclerView.VERTICAL, false);
        rvComidas.setLayoutManager(layout);
        rvComidas.setAdapter(adapterComida);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.filtro_comida, menu);

        MenuItem item = menu.findItem(R.id.sp_filtro);
        final Spinner spFiltro = (Spinner)item.getActionView();

        ArrayAdapter<CharSequence> adapterSpFiltro = ArrayAdapter.createFromResource(this, R.array.sp_categorias, R.layout.spinner_text);
        adapterSpFiltro.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spFiltro.setAdapter(adapterSpFiltro);

        spFiltro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spFiltro.getSelectedItem().toString().equals("Todas"))
                    adapterComida = new AdapterComida(comidas.getComidas(),getBaseContext());
                else
                    adapterComida = new AdapterComida(comidas.getComidas(spFiltro.getSelectedItem().toString()),getBaseContext());

                rvComidas.setAdapter(adapterComida);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
