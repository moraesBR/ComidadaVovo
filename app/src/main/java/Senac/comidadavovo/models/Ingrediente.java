package Senac.comidadavovo.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Ingrediente implements Parcelable {
    private final String nome;
    private final Unidade unidade;
    private final double quantidade;

    Ingrediente(String nome, Unidade unidade, double quantidade) {
        this.nome = nome;
        this.unidade = unidade;
        this.quantidade = quantidade;
    }

    public String getIngrediente() {
        return nome;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString(){
        if(unidade != Unidade.UNKNOWN)
            if(quantidade > 1)
                return quantidade + " " + unidade.getUnidades() + " de " + nome + " ";
            else
                return quantidade + " " + unidade.getUnidade() + " de " + nome + " ";
        else
            return nome + " ";
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nome);
        dest.writeInt(this.unidade == null ? -1 : this.unidade.ordinal());
        dest.writeDouble(this.quantidade);
    }

    private Ingrediente(Parcel in) {
        this.nome = in.readString();
        int tmpUnidade = in.readInt();
        this.unidade = tmpUnidade == -1 ? null : Unidade.values()[tmpUnidade];
        this.quantidade = in.readDouble();
    }

    public static final Parcelable.Creator<Ingrediente> CREATOR = new Parcelable.Creator<Ingrediente>() {
        @Override
        public Ingrediente createFromParcel(Parcel source) {
            return new Ingrediente(source);
        }

        @Override
        public Ingrediente[] newArray(int size) {
            return new Ingrediente[size];
        }
    };
}
