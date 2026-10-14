package br.com.salgados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.salgados.config.Conexao;

public class TesteConsulta {

    public static void main(String[] args) {

        try {

            Connection conexao =
                Conexao.conectar();
            
            Statement comando =
                conexao.createStatement();

            ResultSet resultado =
                comando.executeQuery(
                    "SELECT * FROM sabores"
                );

            System.out.println("LISTA DE SABORES");

            while (resultado.next()) {

                System.out.println(resultado.getInt("id") + " - " + resultado.getString("nome"));
            }

            conexao.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    
}
