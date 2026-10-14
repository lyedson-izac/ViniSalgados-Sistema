package br.com.salgados.service;

import java.util.List;

import br.com.salgados.dao.SaborDAO;
import br.com.salgados.model.Sabor;

public class RelatorioService {

    public void exibirMaiorEstoque() { 

        SaborDAO saborDAO = new SaborDAO();

        EstoqueService estoqueService = new EstoqueService();

        List<Sabor> sabores = saborDAO.listarTodos();

        Sabor saborMaiorEstoque = null;

        int maiorEstoque = Integer.MIN_VALUE;

        for (Sabor sabor : sabores) {

            int estoque = estoqueService.calcularEstoquePorSabor(sabor.getId());

            if (estoque > maiorEstoque) {

                maiorEstoque = estoque;

                saborMaiorEstoque = sabor;
            }
        }

        if (saborMaiorEstoque != null) {

            System.out.println("sabor com maior estoque:");

            System.out.println(saborMaiorEstoque.getNome());

            System.out.println("quantidade: " + maiorEstoque);
        }


    }


public void exibirMenorEstoque() {

     SaborDAO sabordao = new SaborDAO();

    EstoqueService estoqueService = new EstoqueService();

    List<Sabor> sabores = sabordao.listarTodos();

    Sabor saborMenorEstoque = null;

    int menorEstoque = Integer.MIN_VALUE;

    for (Sabor sabor : sabores) {

        int estoque = estoqueService.calcularEstoquePorSabor(sabor.getId());

        if (estoque < menorEstoque) {

            estoque = menorEstoque;

            saborMenorEstoque = sabor;
        }

        if (saborMenorEstoque != null) {

            System.out.println("sabor com menor estoque");

            System.out.println(saborMenorEstoque.getNome());

            System.out.println("quantidade: " + menorEstoque);
        }
    }

}
 
    public void exibirSaboresSemEstoque() {

        SaborDAO saborDAO = new SaborDAO();

        EstoqueService estoqueService = new EstoqueService();

        List<Sabor> sabores = saborDAO.listarTodos();

        System.out.println( "===== SABORES SEM ESTOQUE =====");

        for ( Sabor sabor : sabores) {

            int estoque = estoqueService.calcularEstoquePorSabor(sabor.getId());

            if (estoque == 0) {

            System.out.println(sabor.getNome());
            }
        
        
        }

    
    }

    public void exibirEstoqueAtual() {

        SaborDAO saborDAO = new SaborDAO();

        EstoqueService estoqueService = new EstoqueService();

        List<Sabor> sabores = saborDAO.listarTodos();

        System.out.println("===== ESTOQUE ATUAL =====");

        for (Sabor sabor : sabores) {

            int estoque = estoqueService.calcularEstoquePorSabor(sabor.getId());

            System.out.println(sabor.getNome() + "->" + estoque);

        }
    
    
    }


}
