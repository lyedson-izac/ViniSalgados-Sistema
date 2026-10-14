package br.com.salgados.service;

import java.util.List;


import br.com.salgados.dao.MovimentacaoDAO;
import br.com.salgados.model.Movimentacao;
import br.com.salgados.model.TipoMovimentacao;

public class EstoqueService {

    public int calcularEstoquePorSabor(int saborId) {

        int estoque = 0;

        MovimentacaoDAO dao = new MovimentacaoDAO();

        List<Movimentacao> movimentacoes = dao.listarTodas();

        for (Movimentacao movimentacao : movimentacoes) {

            if (movimentacao.getSabor().getId() == saborId) {

                if (movimentacao.getTipo() == TipoMovimentacao.PRODUCAO) {

                    estoque += movimentacao.getQuantidade();
                } else {
                    estoque -= movimentacao.getQuantidade();
                }
            }
        }
        return estoque;

    }

}

