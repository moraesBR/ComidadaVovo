package Senac.comidadavovo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Senac.comidadavovo.R;
import Senac.comidadavovo.models.Ingrediente;

public class AdapterReceita extends RecyclerView.Adapter {
    private List<Ingrediente> ingredientes;
    private Context context;

    public AdapterReceita(List<Ingrediente> ingredientes, Context context) {
        this.ingredientes = ingredientes;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_ingrediente,parent,false);

        return new ReceitaViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        ReceitaViewHolder viewHolder = (ReceitaViewHolder) holder;

        Ingrediente ingrediente = ingredientes.get(position);

        viewHolder.tvIngredientes.setText(ingrediente.toString());
    }

    public int getItemCount(){ return ingredientes.size(); }



   class ReceitaViewHolder extends RecyclerView.ViewHolder{
        TextView tvIngredientes;
        TextView tvIngredienteTitulo;

        public ReceitaViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvIngredientes = (TextView) itemView.findViewById(R.id.tvIngredientes);
            this.tvIngredienteTitulo = (TextView) itemView.findViewById(R.id.tvIngredientesTitulo);
        }
    }

}
