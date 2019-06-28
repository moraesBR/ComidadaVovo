package Senac.comidadavovo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comida, parent, false);

        ComidaViewHolder holder = new ComidaViewHolder(view);

        return holder;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        ComidaViewHolder viewHolder = (ComidaViewHolder) holder;

        Comida comida = comidas.get(position);

        viewHolder.fotoComida.setImageResource(comida.getFoto().getIcon());
        viewHolder.nomeComida.setText(comida.getNome());

    }

    public int getItemCount(){ return comidas.size(); }
}
