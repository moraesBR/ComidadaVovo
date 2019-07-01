package Senac.comidadavovo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Senac.comidadavovo.R;
import Senac.comidadavovo.models.Ingrediente;

public class AdapterReceita extends ReceitaViewHolder {
    private List<Ingrediente> ingredientes;
    private Context context;

    public AdapterReceita(@NonNull View itemView, List<Ingrediente> ingredientes, Context context) {
        super(itemView);
        this.ingredientes = ingredientes;
        this.context = context;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_ingrediente,parent,false);

        return new ReceitaViewHolder(view);
    }


}
