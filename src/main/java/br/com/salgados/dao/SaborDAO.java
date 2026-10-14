package br.com.salgados.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.List;

import br.com.salgados.config.Conexao;
import br.com.salgados.model.Sabor;

public class SaborDAO {

    public List<Sabor> listarTodos() {
        List<Sabor> sabores = new ArrayList<>();

        try {
            Connection conexao =
            Conexao.conectar();

            Statement comando =
            conexao.createStatement();

            ResultSet resultado =
            comando.executeQuery(
                "SELECT * FROM sabores"
            );

            while (resultado.next()) {
                Sabor sabor = new Sabor();

                sabor.setId(resultado.getInt("id")
            );

            sabor.setNome(resultado.getString("Nome")
        );

        sabor.setDescricao(resultado.getString("Descrição")
    );

    sabores.add(sabor);
}

    conexao.close();
            
} catch (Exception e) {

    e.printStackTrace();
}

    return sabores;
}


public void cadastrar(Sabor sabor) {

    try {

        Connection conexao =
        Conexao.conectar();

        String sql =
        "INSERT INTO sabores (Nome, Descrição) VALUES (?, ?)";

        PreparedStatement comando =
        conexao.prepareStatement(sql);

        comando.setString(1, sabor.getNome());

        comando.setString(2, sabor.getDescricao());

        comando.executeUpdate();

        conexao.close();
    
    } catch (Exception e) {

        e.printStackTrace();
    }
    }

    public void atualizar(Sabor sabor) {

        try {

            Connection conexao =
            Conexao.conectar();

            String sql =
            "UPDATE sabores SET Nome = ?, Descrição = ? WHERE id = ?";

            PreparedStatement comando =
            conexao.prepareStatement(sql);

            comando.setString(1, sabor.getNome());

            comando.setString(2, sabor.getDescricao());

            comando.setInt(3, sabor.getId());

            comando.executeUpdate();

            conexao.close();
        
        } catch (Exception e) {

            e.printStackTrace();
        }



        
    }

    public void excluir(int id) {

        try {

            Connection conexao =
            Conexao.conectar();

            String sql =
            "DELETE FROM sabores WHERE id = ?";

            PreparedStatement comando =
            conexao.prepareStatement(sql);

            comando.setInt(1, id);

            comando.executeUpdate();

            conexao.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
