package Senac.comidadavovo.models;

public class Ingrediente {
    private final String ingrediente;
    private final Unidade unidade;
    private final double quantidade;

    public Ingrediente(String ingrediente, Unidade unidade, double quantidade) {
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

    public double getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString(){
        if(unidade != Unidade.UNKNOWN)
            if(quantidade > 1)
                return quantidade + " " + unidade.getUnidade() + "s de " + ingrediente + "/n";
            else
                return quantidade + " " + unidade.getUnidade() + " de " + ingrediente + "/n";
        else
            return ingrediente + "/n";
    }
}
