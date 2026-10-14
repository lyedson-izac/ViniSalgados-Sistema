package br.com.salgados;

import java.util.List;

import br.com.salgados.dao.SaborDAO;
import br.com.salgados.model.Sabor;
import br.com.salgados.service.EstoqueService;

public class TesteConsultaEstoque {

    public static void main(String[] args) {

        SaborDAO saborDAO = new SaborDAO();

        EstoqueService estoqueService = new EstoqueService();

        List<Sabor> sabores = saborDAO.listarTodos();

        System.out.println("===== ESTOQUE ATUAL =====");

        for (Sabor sabor : sabores) {

            int estoque = estoqueService.calcularEstoquePorSabor(sabor.getId());

            System.out.println(sabor.getNome() + " - " + estoque + " unidades");
        }
    }

}
