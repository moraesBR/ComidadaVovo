package Senac.comidadavovo.models;

public enum Unidade {
    G("grama"),
    L("litro"),
    U("unidade"),
    S("colher"),
    C("xícara"),
    UNKNOWN("");

    private final String unidade;

    Unidade(String unidade){
        this.unidade = unidade;
    }

    public String getUnidade(){
        return this.unidade;
    }

    public String getUnidades(){
        String saida = null;
        switch (unidade){
            case "grama": saida = unidade+"s"; break;
            case "litro": saida = unidade+"s"; break;
            case "unidade": saida = unidade+"s"; break;
            case "colher": saida = unidade+"es"; break;
            case "xícara": saida = unidade+"s"; break;
        }
        return saida;
    }


}
