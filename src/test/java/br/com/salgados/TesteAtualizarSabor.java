package br.com.salgados;

import br.com.salgados.dao.SaborDAO;
import br.com.salgados.model.Sabor;

public class TesteAtualizarSabor {

    public static void main(String[] args) {

        Sabor sabor = new Sabor();

        sabor.setId(1);

        sabor.setNome("Coxinha Especial");

        sabor.setDescricao("Frango com catupiry");

        SaborDAO dao = new SaborDAO();

        dao.atualizar(sabor);

        System.out.println("Sabor atualizado com sucesso!");
    }

}
