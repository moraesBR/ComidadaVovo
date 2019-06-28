package Senac.comidadavovo.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import Senac.comidadavovo.R;

public class MenuComidas implements Parcelable {
    private List<Comida> comidas;

    public MenuComidas(){
        comidas = new ArrayList<Comida>();
    }

    public void setComidas(){
        addFrangoXadrez();
        addSopaAlhoComBatata();
        addStronoff();
    }

    private void addFrangoXadrez(){
        Comida frangoXadrez = new Comida("Frango Xadrez", new Imagem(R.mipmap.frangoxadrez,R.mipmap.ic_frangoxadrez));

        frangoXadrez.adicionaIngrediente(new Ingrediente("azeite de oliva",Unidade.S,2));
        frangoXadrez.adicionaIngrediente(new Ingrediente("cebolas média cortadas",Unidade.U,2));
        frangoXadrez.adicionaIngrediente(new Ingrediente("dentes de alho esmagados",Unidade.S,2));
        frangoXadrez.adicionaIngrediente(new Ingrediente("filé de frango sem pele e cortado em cubos",Unidade.G,500));
        frangoXadrez.adicionaIngrediente(new Ingrediente("Sal a gosto",Unidade.UNKNOWN,0));
        frangoXadrez.adicionaIngrediente(new Ingrediente("pimentão verde cortado em cubos",Unidade.U,1));
        frangoXadrez.adicionaIngrediente(new Ingrediente("pimentão vermelho cortado em cubos",Unidade.U,1));
        frangoXadrez.adicionaIngrediente(new Ingrediente("pimentão amarelo cortado em cubos",Unidade.U,1));
        frangoXadrez.adicionaIngrediente(new Ingrediente("cogumelos em conserva cortados ao meio",Unidade.C,1));
        frangoXadrez.adicionaIngrediente(new Ingrediente("molho shoyu",Unidade.C,0.25));
        frangoXadrez.adicionaIngrediente(new Ingrediente("maisena",Unidade.S,1));
        frangoXadrez.adicionaIngrediente(new Ingrediente("água",Unidade.C,0.5));
        frangoXadrez.adicionaIngrediente(new Ingrediente("amendoim torrado",Unidade.S,2));

        comidas.add(frangoXadrez);
    }

    private void addStronoff(){
        Comida strogonoff = new Comida("Strogonoff",new Imagem(R.mipmap.strogonoffdecarne,R.mipmap.ic_strogonoffdecarne));

        strogonoff.adicionaIngrediente(new Ingrediente("filé mignon",Unidade.G,400));
        strogonoff.adicionaIngrediente(new Ingrediente("Pimenta do reino a gosto",Unidade.UNKNOWN,0));
        strogonoff.adicionaIngrediente(new Ingrediente("Cominho a gosto",Unidade.UNKNOWN,0));
        strogonoff.adicionaIngrediente(new Ingrediente("Sal a gosto",Unidade.UNKNOWN,0));
        strogonoff.adicionaIngrediente(new Ingrediente("cebola cortadas em cubos",Unidade.U,0.5));
        strogonoff.adicionaIngrediente(new Ingrediente("caixa de creme de leite",Unidade.U,1.5));
        strogonoff.adicionaIngrediente(new Ingrediente("sopa de catchup",Unidade.S,3));
        strogonoff.adicionaIngrediente(new Ingrediente("extrato de tomate",Unidade.S,3));
        strogonoff.adicionaIngrediente(new Ingrediente("mostarda",Unidade.S,1));
        strogonoff.adicionaIngrediente(new Ingrediente("óleo vegetal",Unidade.UNKNOWN,0));

        comidas.add(strogonoff);
    }

    private void addSopaAlhoComBatata(){
        Comida sopa = new Comida("Sopa de alho-poró com batata",new Imagem(R.mipmap.sopadebatatacomalhoporo,R.mipmap.ic_sopadebatatacomalhoporo));

        sopa.adicionaIngrediente(new Ingrediente("manteiga",Unidade.S,2));
        sopa.adicionaIngrediente(new Ingrediente("talos de alho-poró",Unidade.U,6));
        sopa.adicionaIngrediente(new Ingrediente("caldo de legumes ou carne",Unidade.L,1.5));
        sopa.adicionaIngrediente(new Ingrediente("batatas médias descascadas",Unidade.S,8));
        sopa.adicionaIngrediente(new Ingrediente("Sal a gosto",Unidade.UNKNOWN,0));
        sopa.adicionaIngrediente(new Ingrediente("Pimenta do reino a gosto",Unidade.UNKNOWN,0));

        comidas.add(sopa);
    }

    public List<String> getComidas(){
        List<String> nomesComidas = new ArrayList<String>();

        for(Comida comida: this.comidas)
            nomesComidas.add(comida.getNome());

        return nomesComidas;
    }

    @Override
    public String toString(){
        StringBuilder saida = new StringBuilder();

        for (Comida comida : comidas)
            saida.append(comida.toString());

        return saida.toString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.comidas);
    }

    protected MenuComidas(Parcel in) {
        this.comidas = new ArrayList<Comida>();
        in.readList(this.comidas, Comida.class.getClassLoader());
    }

    public static final Parcelable.Creator<MenuComidas> CREATOR = new Parcelable.Creator<MenuComidas>() {
        @Override
        public MenuComidas createFromParcel(Parcel source) {
            return new MenuComidas(source);
        }

        @Override
        public MenuComidas[] newArray(int size) {
            return new MenuComidas[size];
        }
    };
}
