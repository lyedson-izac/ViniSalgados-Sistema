package br.com.salgados.service;

import java.util.List;

import br.com.salgados.dao.SaborDAO;
import br.com.salgados.model.Sabor;

public class SaborService {

    public void cadastrarSabor(

        String nome,
        String descricao) {

            if (nome == null || nome.isBlank()) {

                throw new IllegalArgumentException("O nome do sabor é obrigatório");
            }

            Sabor sabor = new Sabor();

            sabor.setNome(nome);

            sabor.setDescricao(descricao);

            SaborDAO dao = new SaborDAO();

            dao.cadastrar(sabor);
        }

    public List<Sabor> listarSabores() {

            SaborDAO dao = new SaborDAO();

            return dao.listarTodos();
        }

    public void atualizarSabor(
        int id,
        String nome,
        String descricao) {

            Sabor sabor = new Sabor(
                id,
                nome,
                descricao);

                SaborDAO dao = new SaborDAO();

                dao.atualizar(sabor);


            }
    public void excluirSabor(int id) {

        SaborDAO dao = new SaborDAO();

        dao.excluir(id);
    }

}
