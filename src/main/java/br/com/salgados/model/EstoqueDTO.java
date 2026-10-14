package br.com.salgados.model;

public class EstoqueDTO {

    private String nome;

    private int estoque;

    public EstoqueDTO(String nome, int estoque) {

        this.nome = nome;
        this.estoque = estoque;
    }

    public String getNome() {

        return nome;

    }

    public int getEstoque() {

        return estoque;
    }

}
