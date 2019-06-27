package Senac.comidadavovo.models;

public class Ingrediente {
    private final String ingrediente;
    private final Unidade unidade;
    private final int quantidade;

    public Ingrediente(String ingrediente, Unidade unidade, int quantidade) {
        this.ingrediente = ingrediente;
        this.unidade = unidade;
        this.quantidade = quantidade;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString(){
        return quantidade + " " + unidade.getUnidade() + " de " + ingrediente;
    }
}
