package Senac.comidadavovo.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Senac.comidadavovo.R;
import Senac.comidadavovo.models.Comida;

public class AdapterComida extends RecyclerView.Adapter {

    private List<Comida> comidas;
    private Context context;

    public AdapterComida(List<Comida> comidas, Context context) {
        this.comidas = comidas;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comida, parent, false);

        return new ComidaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        ComidaViewHolder viewHolder = (ComidaViewHolder) holder;

        Comida comida = comidas.get(position);

        Log.e(comida.getNome(),String.valueOf(comida.getFoto().getIcon()));


        viewHolder.nomeComida.setText(comida.getNome());
        viewHolder.fotoComida.setImageDrawable(context.getResources().getDrawable(comida.getFoto().getNormal(),null));
        //viewHolder.fotoComida.setImageResource(comida.getFoto().getIcon());

    }

    public int getItemCount(){ return comidas.size(); }
}
