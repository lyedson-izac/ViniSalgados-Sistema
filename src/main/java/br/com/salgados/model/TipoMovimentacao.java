package br.com.salgados.model;

public enum TipoMovimentacao {

    PRODUCAO,
    VENDA,
    PERDA;

@Override 
public String toString() {

    switch (this) {

        case PRODUCAO:
            return "Produção";

        case VENDA:
            return "Venda";
        
        case PERDA:
            return "Perda";

        default:
            return super.toString();
    }
}
    
}


