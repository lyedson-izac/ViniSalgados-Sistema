package br.com.salgados.model;

import java.time.LocalDateTime;

public class Movimentacao {

    private int id;
    private Sabor sabor;
    private TipoMovimentacao tipo;
    private int quantidade;
    private LocalDateTime dataMovimentacao;
    private String observacao;

    public Movimentacao() {

    }

    public Movimentacao(

        int id,
        Sabor sabor,
        TipoMovimentacao tipo,
        int quantidade,
        LocalDateTime dataMovimentacao,
        String observacao
    ) {

        this.id = id;
        this.sabor = sabor;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.dataMovimentacao = dataMovimentacao;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}