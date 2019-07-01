package Senac.comidadavovo.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Comida implements Parcelable {
    private String nome;
    private Categoria categoria;
    private List<Ingrediente> ingredientes;
    private Imagem foto;

    public Comida(String nome, Categoria categoria ,Imagem foto) {
        this.nome = nome;
        this.foto = foto;
        this.categoria = categoria;
        ingredientes = new ArrayList<>();
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

    public Categoria getCategoria() {
        return categoria;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nome);
        dest.writeInt(this.categoria == null? -1 : this.categoria.ordinal());
        dest.writeTypedList(this.ingredientes);
        dest.writeParcelable(this.foto, flags);
    }

    protected Comida(Parcel in) {
        this.nome = in.readString();
        int tmpCategoria = in.readInt();
        this.categoria = tmpCategoria == -1? null : Categoria.values()[tmpCategoria];
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