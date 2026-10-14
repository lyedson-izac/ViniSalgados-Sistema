package br.com.salgados;

import java.util.List;

import br.com.salgados.dao.MovimentacaoDAO;
import br.com.salgados.model.Movimentacao;

public class TesteListarPorSabor {

    public static void main(String[] args) {

        MovimentacaoDAO dao = new MovimentacaoDAO();

        List<Movimentacao> lista = dao.listarPorSabor(1);

        System.out.println("quantidade encontrada: " + lista.size());

        for (Movimentacao movimentacao : lista) {

            System.out.println("Tipo: " + movimentacao.getTipo());

            System.out.println("quantidade: " + movimentacao.getQuantidade());

            System.out.println("Observação: " + movimentacao.getObservacao());

            System.out.println("Sabor: " + movimentacao.getSabor().getNome());

            System.out.println("------------------");
        }
      
    }

}
