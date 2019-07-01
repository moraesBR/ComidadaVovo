package Senac.comidadavovo.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import Senac.comidadavovo.R;

class ComidaViewHolder extends RecyclerView.ViewHolder {
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
