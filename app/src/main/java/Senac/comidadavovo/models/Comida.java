package Senac.comidadavovo.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Comida implements Parcelable {
    private String nome;
    private List<Ingrediente> ingredientes;
    private Imagem foto;

    public Comida(String nome, Imagem foto) {
        this.nome = nome;
        this.foto = foto;
        ingredientes = new ArrayList<Ingrediente>();
    }

    public void adicionaIngrediente(Ingrediente novo){
        ingredientes.add(novo);
    }

    public String toString(){
        StringBuilder saida = new StringBuilder(nome+"/nIngredientes:/n");
        for (Ingrediente ingrediente : this.ingredientes)
            saida.append(ingrediente.toString());
        return saida.toString();
    }

    public Imagem getFoto(){
        return foto;
    }

    public String getNome() {
        return nome;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nome);
        dest.writeTypedList(this.ingredientes);
        dest.writeParcelable(this.foto, flags);
    }

    protected Comida(Parcel in) {
        this.nome = in.readString();
        this.ingredientes = in.createTypedArrayList(Ingrediente.CREATOR);
        this.foto = in.readParcelable(Imagem.class.getClassLoader());
    }

    public static final Creator<Comida> CREATOR = new Creator<Comida>() {
        @Override
        public Comida createFromParcel(Parcel source) {
            return new Comida(source);
        }

        @Override
        public Comida[] newArray(int size) {
            return new Comida[size];
        }
    };
}