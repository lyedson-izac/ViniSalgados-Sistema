package br.com.salgados;

import java.time.LocalDateTime;

import br.com.salgados.dao.MovimentacaoDAO;
import br.com.salgados.model.Movimentacao;
import br.com.salgados.model.Sabor;
import br.com.salgados.model.TipoMovimentacao;

public class TesteCadastroMovimentacao {

    public static void main(String[] args) {

        Sabor sabor = new Sabor();

        sabor.setId(1);

        Movimentacao movimentacao = new Movimentacao();

        movimentacao.setSabor(sabor);

        movimentacao.setTipo(TipoMovimentacao.PRODUCAO);

        movimentacao.setQuantidade(500);

        movimentacao.setDataMovimentacao(LocalDateTime.now());

        movimentacao.setObservacao("Produto para a festa de sábado");

        MovimentacaoDAO dao = new MovimentacaoDAO();

        dao.cadastrar(movimentacao);

    }

}
