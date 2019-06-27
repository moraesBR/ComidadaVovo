package Senac.comidadavovo.models;

import java.util.ArrayList;
import java.util.List;

public class Comida {
    private List<Ingrediente> ingredientes;

    public Comida() {
        ingredientes = new ArrayList<Ingrediente>();
    }

    public void adicionaIngrediente(Ingrediente novo){
        ingredientes.add(novo);
    }

    public String toString(){
        StringBuilder saida = new StringBuilder("Ingredi");
        return saida.toString();
    }
}

