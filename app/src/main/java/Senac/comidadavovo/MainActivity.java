package Senac.comidadavovo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Senac.comidadavovo.adapters.AdapterComida;
import Senac.comidadavovo.models.Comida;
import Senac.comidadavovo.models.MenuComidas;

public class MainActivity extends AppCompatActivity {

    /* Dados */
    private MenuComidas comidas;
    private List<Comida> listComida = new ArrayList<>();

    /* RecyclerView */
    private AdapterComida adapterComida;
    private RecyclerView rvComidas;

    /* Spinner */
    private Spinner spFiltro;
    //private Bundle mBundleSpinner;
    private static final String SPFILTRO_TEXT_KEY = "sp_filtro_escolha";
    private static int escolhaFiltro;

    /*https://hackernoon.com/android-recyclerview-onitemclicklistener-getadapterposition-a-better-way-3c789baab4db*/
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //TODO: Step 4 of 4: Finally call getTag() on the view.
            // This viewHolder will have all required values.
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();

            Comida comida = listComida.get(position);
            /*Toast.makeText(MainActivity.this, "You Clicked: " + thisItem.getNome(), Toast.LENGTH_SHORT).show();*/
            Intent telaReceita = new Intent(getBaseContext(), ReceitaActivity.class);
            telaReceita.putExtra("comida",comida);
            startActivity(telaReceita);
        }
    };


    private AdapterView.OnItemSelectedListener getOnItemSelectedListener() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                listComida = spFiltro.getSelectedItem().toString().equals("Todas") ?
                        comidas.getComidas() :
                        comidas.getComidas(spFiltro.getSelectedItem().toString());

                adapterComida = new AdapterComida(listComida, getBaseContext());
                rvComidas.setAdapter(adapterComida);
                adapterComida.setOnItemClickListener(onItemClickListener);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_baker);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        comidas = new MenuComidas();
        comidas.setComidas();

        rvComidas = findViewById(R.id.rvComidas);
        rvComidas.setHasFixedSize(true);
        rvComidas.setLayoutManager(new LinearLayoutManager(getBaseContext(),
                RecyclerView.VERTICAL,
                false));
        rvComidas.setAdapter(new AdapterComida(comidas.getComidas(),this));

    }
/*
    @Override
    protected void onPause() {
        super.onPause();
        mBundleSpinner = new Bundle();
        mBundleSpinner.putInt(SPFILTRO_TEXT_KEY, spFiltro.getSelectedItemPosition());
    }

    @Override
    protected void onResume() {
        super.onResume();
        escolhaFiltro = mBundleSpinner != null ? mBundleSpinner.getInt(SPFILTRO_TEXT_KEY) : 0;
    }*/

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(SPFILTRO_TEXT_KEY, spFiltro.getSelectedItemPosition());
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        escolhaFiltro = savedInstanceState != null ? savedInstanceState.getInt(SPFILTRO_TEXT_KEY):0;
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.filtro_comida, menu);

        MenuItem item = menu.findItem(R.id.sp_filtro);
        spFiltro = (Spinner) item.getActionView();

        ArrayAdapter<CharSequence> adapterSpFiltro = ArrayAdapter.createFromResource(this,
                R.array.sp_categorias, R.layout.spinner_text);

        adapterSpFiltro.setDropDownViewResource(R.layout.simple_spinner_dropdown);

        spFiltro.setAdapter(adapterSpFiltro);
        spFiltro.setSelection(escolhaFiltro);
        spFiltro.setOnItemSelectedListener(getOnItemSelectedListener());

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
