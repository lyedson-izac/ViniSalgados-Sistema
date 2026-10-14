package br.com.salgados.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String URL = 
    
        "jdbc:mysql://localhost:3306/salgados_stock";
    
    private static final String USUARIO =

        "root";

    private static final String SENHA =

        "201624";

    public static Connection conectar() throws Exception {

        return DriverManager.getConnection( 
            URL,
            USUARIO,
            SENHA
        );
    }


}