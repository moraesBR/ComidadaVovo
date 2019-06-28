package Senac.comidadavovo.models;

public enum Unidade {
    G("grama"),
    L("litro"),
    U("unidade"),
    S("colher"),
    C("xícara"),
    UNKNOWN("");

    private final String unidade;

    private Unidade(String unidade){
        this.unidade = unidade;
    }

    public String getUnidade(){
        return this.unidade;
    }

}
