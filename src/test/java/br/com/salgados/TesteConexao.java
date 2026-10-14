package br.com.salgados;

import java.sql.Connection;

import br.com.salgados.config.Conexao;

public class TesteConexao {

    public static void main(String[] args) {

        try {

            Connection conexao =
             Conexao.conectar();
            
            System.out.println(
                "Conectado com sucesso!"
            );

            conexao.close();

        } catch (Exception e) {

            System.out.println(
                "Erro na coxexão"
            );

            e.printStackTrace();
        }
    }
    
}