package br.com.salgados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

import br.com.salgados.config.Conexao;
import br.com.salgados.model.Movimentacao;
import br.com.salgados.model.Sabor;
import br.com.salgados.model.TipoMovimentacao;

public class MovimentacaoDAO {

    public void cadastrar(
        Movimentacao movimentacao) {

            try { 

                Connection conexao =
                Conexao.conectar();

                String sql = """
                        INSERT INTO movimentacoes
                        (sabor_id,
                        tipo,
                        quantidade,
                        data_movimentacao,
                        observacao
                        )
                        VALUES
                        (?, ?, ?, ?, ?)
                        """;

                PreparedStatement comando =
                conexao.prepareStatement(sql);

                comando.setInt(1, movimentacao.getSabor().getId());

                comando.setString(2, movimentacao.getTipo().name());

                comando.setInt(
                    3, movimentacao.getQuantidade()
                );

                comando.setTimestamp(4, java.sql.Timestamp.valueOf(movimentacao.getDataMovimentacao())
            );

            comando.setString(
                5, movimentacao.getObservacao()
            );

            comando.executeUpdate();

            comando.close();
            conexao.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
    
        }
    public List<Movimentacao> listarTodas() {

        List<Movimentacao> movimentacoes = new ArrayList<>();

        String sql = """
                SELECT 
                m.id,
                m.tipo,
                m.quantidade,
                m.data_movimentacao,
                m.observacao,
                s.id AS sabor_id,
                s.Nome,
                s.Descrição
                FROM movimentacoes m INNER JOIN sabores s ON m.sabor_id = s.id
                """;

                try {

                    Connection conexao = Conexao.conectar();

                    PreparedStatement comando = conexao.prepareStatement(sql);

                    ResultSet resultado = comando.executeQuery();

                    while (resultado.next()) {

                        Sabor sabor = new Sabor();

                        sabor.setId(resultado.getInt("sabor_id"));

                        sabor.setNome(resultado.getString("Nome"));

                        sabor.setDescricao(resultado.getString("Descrição"));

                        Movimentacao movimentacao = new Movimentacao();

                        movimentacao.setId(resultado.getInt("id"));

                        movimentacao.setSabor(sabor);

                        movimentacao.setTipo(TipoMovimentacao.valueOf(resultado.getString("tipo")));

                        movimentacao.setQuantidade(resultado.getInt("quantidade"));

                        movimentacao.setDataMovimentacao(resultado.getTimestamp("data_movimentacao").toLocalDateTime());

                        movimentacao.setObservacao(resultado.getString("observacao"));

                        movimentacoes.add(movimentacao);

                    }
                    conexao.close();
                } catch (Exception e) {

                    e.printStackTrace();
                }
                return movimentacoes;
    }


    public List<Movimentacao> listarPorSabor(
        int saborId) {

            List<Movimentacao> movimentacoes = new ArrayList<>();

            String sql = """
                    SELECT
                    m.id,
                    m.tipo,
                    m.quantidade,
                    m.data_movimentacao,
                    m.observacao,
                    s.id AS sabor_id,
                    s.Nome,
                    s.Descrição
                    FROM movimentacoes m INNER JOIN sabores s on m.sabor_id = s.id
                    WHERE s.id = ?
                    """;

            try { Connection conexao = Conexao.conectar();

                PreparedStatement comando = conexao.prepareStatement(sql);

                comando.setInt(1, saborId);

                ResultSet resultado = comando.executeQuery();

                while (resultado.next()) {

                    Sabor sabor = new Sabor();

                    sabor.setId(resultado.getInt("Sabor_id"));

                    sabor.setNome(resultado.getString("Nome"));

                    sabor.setDescricao(resultado.getString("Descrição"));


                    Movimentacao movimentacao = new Movimentacao();

                    movimentacao.setId(resultado.getInt("id"));

                    movimentacao.setSabor(sabor);

                    movimentacao.setTipo(TipoMovimentacao.valueOf(resultado.getString("tipo")));

                    movimentacao.setQuantidade(resultado.getInt("quantidade"));

                    movimentacao.setObservacao(resultado.getString("observacao"));

                    movimentacoes.add(movimentacao);
                    
                }

            } catch (Exception e) {

                e.printStackTrace();
            }

            return movimentacoes;
        }

}