package br.com.salgados.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrincipalView extends Application {

    @Override
    public void start(Stage stage) {

        Button btnCadastro = new Button("Cadastrar");

       btnCadastro.setOnAction(event -> {

         CadastroSaborView view = new CadastroSaborView();

        Stage novaJanela = new Stage();

        try {

            view.start(novaJanela);
        
        } catch (Exception e) {

            e.printStackTrace();
        }
       }); 

        
       
       Button btnSabores = new Button("Sabores");

        btnSabores.setOnAction(event -> {

            ListaSaboresView view = new ListaSaboresView();

            Stage novaJanela = new Stage();

            try {

                view.start(novaJanela);

            } catch (Exception e) {

                e.printStackTrace();;
            }
        });

        
        
        Button btnMovimentacoes = new Button("Movimentações");

        btnMovimentacoes.setOnAction(event -> {

            MovimentacaoView view = new MovimentacaoView();

            Stage novaJanela = new Stage();

            try{

                view.start(novaJanela);

            } catch (Exception e) {

                e.printStackTrace();
            }
        });

        
        
        Button btnEstoque = new Button("Estoque");

        btnEstoque.setOnAction(event -> {

            EstoqueView view = new EstoqueView();

            Stage novaJanela = new Stage();

            try {

                view.start(novaJanela);
            
            } catch (Exception e) {

                e.printStackTrace();
            }
        });

        Button btnHistoricoMovimentacao = new Button("Histórico de movimentação");

        btnHistoricoMovimentacao.setOnAction(event -> {

            HistoricoMovimentacaoView view = new HistoricoMovimentacaoView();

            Stage novaJanela = new Stage();

            try {

                view.start(novaJanela);

            } catch (Exception e) {

                e.printStackTrace();
            }

        });

        Button btnRelatorio = new Button("Relatório");

            btnRelatorio.setOnAction(event -> {

                RelatorioView view = new RelatorioView();

                Stage novaJanela = new Stage();

                try {

                    view.start(novaJanela);

                } catch (Exception e) {

                    e.printStackTrace();
                }

            });

        
        
        VBox layout = new VBox(10, btnCadastro, btnSabores, btnMovimentacoes, btnEstoque, btnHistoricoMovimentacao, btnRelatorio);

        Scene scene = new Scene(layout, 400, 300);

        stage.setTitle("Sistema de Estoque - Vini Salgados");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

}