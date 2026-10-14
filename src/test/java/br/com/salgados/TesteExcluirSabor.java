package br.com.salgados;

import br.com.salgados.dao.SaborDAO;

public class TesteExcluirSabor {

    public static void main(String[] args) {

        SaborDAO dao = new SaborDAO();

        dao.excluir(1);

        System.out.println("Sabor excluído com sucesso!");
    }

}
