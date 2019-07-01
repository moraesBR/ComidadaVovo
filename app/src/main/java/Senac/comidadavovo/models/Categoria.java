package Senac.comidadavovo.models;

public enum Categoria {
    CV("carnes vermelhas"),
    CB("carnes brancas"),
    CD("caldos"),
    MS("massas"),
    UNKNOWN("");

    private final String categoria;

    Categoria(String categoria){
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public static Categoria fromString(String text) {
        for (Categoria b : Categoria.values()) {
            if (b.categoria.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
