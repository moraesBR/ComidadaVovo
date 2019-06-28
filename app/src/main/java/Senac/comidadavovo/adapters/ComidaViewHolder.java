package Senac.comidadavovo.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import Senac.comidadavovo.R;

public class ComidaViewHolder extends RecyclerView.ViewHolder {
    final ImageView fotoComida;
    final TextView nomeComida;

    public ComidaViewHolder(@NonNull View itemView) {
        super(itemView);
        fotoComida = itemView.findViewById(R.id.imgComida);
        nomeComida = itemView.findViewById(R.id.tvComida);
    }
}
