package Senac.comidadavovo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Senac.comidadavovo.R;
import Senac.comidadavovo.models.Comida;

public class AdapterComida extends RecyclerView.Adapter<AdapterComida.ComidaViewHolder> {

    private List<Comida> comidas;
    private Context context;
    private View.OnClickListener mOnItemClickListener;

    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }

    public AdapterComida(List<Comida> comidas, Context context) {
        this.comidas = comidas;
        this.context = context;
    }

    @NonNull
    @Override
    public ComidaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_comida, parent, false);

        return new ComidaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComidaViewHolder holder, int position){
        holder.nomeComida.setText(comidas
                .get(position)
                .getNome());
        holder.fotoComida.setImageDrawable(context
                .getResources()
                .getDrawable(comidas
                        .get(position)
                        .getFoto()
                        .getNormal(),
                        null));

    }

    public int getItemCount(){ return comidas.size(); }

    public class ComidaViewHolder extends RecyclerView.ViewHolder {
        ImageView fotoComida;
        TextView nomeComida;
        LinearLayout header;

        public ComidaViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoComida = itemView.findViewById(R.id.imgComida);
            nomeComida = itemView.findViewById(R.id.tvComida);
            header = itemView.findViewById(R.id.header);

            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }

}
