package Senac.comidadavovo.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import Senac.comidadavovo.R;

public class ComidaViewHolder extends RecyclerView.ViewHolder {
    ImageView fotoComida;
    TextView nomeComida;
    LinearLayout header;

    public ComidaViewHolder(@NonNull View itemView) {
        super(itemView);
        fotoComida = itemView.findViewById(R.id.imgComida);
        nomeComida = itemView.findViewById(R.id.tvComida);
        header = itemView.findViewById(R.id.header);
    }
}

class LoadingViewHolder extends RecyclerView.ViewHolder {
    public ProgressBar progressBar;

    public LoadingViewHolder(View view) {
        super(view);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
    }
}

class ReceitaViewHolder extends RecyclerView.ViewHolder{
    TextView tvIngredientes;
    TextView tvIngredienteTitulo;

    public ReceitaViewHolder(@NonNull View itemView) {
        super(itemView);
        this.tvIngredientes = (TextView) itemView.findViewById(R.id.tvIngredientes);
        this.tvIngredienteTitulo = (TextView) itemView.findViewById(R.id.tvIngredientesTitulo);
    }
}