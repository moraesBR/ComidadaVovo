package Senac.comidadavovo.models;

import java.util.ArrayList;
import java.util.List;

public class Comida {
    private String comida;
    private List<Ingrediente> ingredientes;

    public Comida(String comida) {
        this.comida = comida;
        ingredientes = new ArrayList<Ingrediente>();
    }

    public void adicionaIngrediente(Ingrediente novo){
        ingredientes.add(novo);
    }

    public String toString(){
        StringBuilder saida = new StringBuilder(comida+"/nIngredientes:/n");
        for (Ingrediente ingrediente : this.ingredientes)
            saida.append(ingrediente.toString());
        return saida.toString();
    }
}