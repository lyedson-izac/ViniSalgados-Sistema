package br.com.salgados.service;

import java.time.LocalDateTime;

import br.com.salgados.dao.MovimentacaoDAO;
import br.com.salgados.model.Sabor;
import br.com.salgados.model.Movimentacao;
import br.com.salgados.model.TipoMovimentacao;

public class MovimentacaoService {

    public void registrarProducao(
        int saborId,
        int quantidade,
        String observacao) {

            Sabor sabor = new Sabor();

            sabor.setId(saborId);

            Movimentacao movimentacao = new Movimentacao();

            movimentacao.setSabor(sabor);
            movimentacao.setTipo(TipoMovimentacao.PRODUCAO);

            movimentacao.setQuantidade(quantidade);

            movimentacao.setDataMovimentacao(LocalDateTime.now());

            movimentacao.setObservacao(observacao);

            MovimentacaoDAO dao = new MovimentacaoDAO();

            dao.cadastrar(movimentacao);
        }

    public void registrarVenda(
        
        int saborId,
        int quantidade,
        String observacao) {

            Sabor sabor = new Sabor();

            sabor.setId(saborId);

            Movimentacao movimentacao = new Movimentacao();

            movimentacao.setSabor(sabor);

            movimentacao.setTipo(TipoMovimentacao.VENDA);

            movimentacao.setQuantidade(quantidade);

            movimentacao.setDataMovimentacao(LocalDateTime.now());

            movimentacao.setObservacao(observacao);

            EstoqueService estoqueService = new EstoqueService();

            int estoqueAtual = estoqueService.calcularEstoquePorSabor(saborId);

            if(quantidade > estoqueAtual) {

                System.out.println("Estoque insuficiente!");

                return;
            }

            MovimentacaoDAO dao = new MovimentacaoDAO();

            dao.cadastrar(movimentacao);


        }

        public void registrarPerda(

            int saborId,
            int quantidade,
            String observacao) {

            Sabor sabor = new Sabor();

            sabor.setId(saborId);

            Movimentacao movimentacao = new Movimentacao();

            movimentacao.setSabor(sabor);

            movimentacao.setTipo(TipoMovimentacao.PERDA);

            movimentacao.setQuantidade(quantidade);

            movimentacao.setDataMovimentacao(LocalDateTime.now());

            movimentacao.setObservacao(observacao);

            EstoqueService estoqueService = new EstoqueService();

            int estoqueAtual = estoqueService.calcularEstoquePorSabor(saborId);

            if (quantidade > estoqueAtual) {

                System.out.println("Estoque insuficiente!");

                return;
            }

            MovimentacaoDAO dao = new MovimentacaoDAO();

            dao.cadastrar(movimentacao);


        }

}
