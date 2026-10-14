package br.com.salgados;

import br.com.salgados.dao.SaborDAO;
import br.com.salgados.model.Sabor;

public class TesteCadastroSabor {

    public static void main (String[] args) {

        Sabor sabor = new Sabor();

        sabor.setNome( "Bolinha de queijo");

        sabor.setDescricao("Massa crocante recheada com quiejo");

        SaborDAO dao = new SaborDAO();

        dao.cadastrar(sabor);

        System.out.print("Sabor cadastrado com sucesso!");
    }

}