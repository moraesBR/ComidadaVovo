package Senac.comidadavovo.models;

public enum Unidade {
    K("quilograma"),
    L("litro"),
    U("unidade"),
    S("colheres"),
    C("copos");

    private final String unidade;

    private Unidade(String unidade){
        this.unidade = unidade;
    }

    public String getUnidade(){
        return this.unidade;
    }

}
