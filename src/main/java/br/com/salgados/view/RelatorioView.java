package br.com.salgados.view;

import java.time.LocalDateTime;
import java.util.List;

import br.com.salgados.dao.MovimentacaoDAO;
import br.com.salgados.model.Movimentacao;
import br.com.salgados.model.TipoMovimentacao;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RelatorioView extends Application {

    @Override
    public void start(Stage stage) {

        // Interface
        ComboBox<String> comboPeriodo = new ComboBox<>();

        comboPeriodo.getItems().addAll(
            "Últimos 7 dias",
            "Últimos 15 dias",
            "Últimos 30 dias"
        );

        comboPeriodo.setValue("Últimos 7 dias");
        
       
       // Interface
        Label lblProduzido = new Label("Total Produzido: 0");

        Label lblVendido = new Label("Total Vendido: 0");

        Label lblPerdido = new Label("Total Perdido: 0");

        Label lblSaldo = new Label("Saldo: 0");

        
        // Buscar Movimentações
        MovimentacaoDAO dao = new MovimentacaoDAO();

        List<Movimentacao> movimentacoes = dao.listarTodas();


        // Evento ComboBox
        comboPeriodo.setOnAction(event -> {

            // Descobrir o período
            int dias = 7;

            if (comboPeriodo.getValue().equals("Últimos 15 dias")) {

                dias = 15;
            }

            if (comboPeriodo.getValue().equals("Últimos 30 dias")) {

                dias = 30;
            }

            // Data limite
            LocalDateTime limite = LocalDateTime.now().minusDays(dias);

            // Variáveis acumuladoras
            int totalProduzido = 0;

            int totalVendido = 0;

            int totalPerdido = 0;

            for (Movimentacao movimentacao : movimentacoes) {

                // Filtrar pelo período
                if (movimentacao.getDataMovimentacao().isAfter(limite)) {

                    // Somar os valores
                    if (movimentacao.getTipo() == TipoMovimentacao.PRODUCAO) {

                        totalProduzido += movimentacao.getQuantidade();
                    }

                    if (movimentacao.getTipo() == TipoMovimentacao.VENDA) {

                        totalVendido += movimentacao.getQuantidade();
                    }

                    if (movimentacao.getTipo() == TipoMovimentacao.PERDA) {

                        totalPerdido += movimentacao.getQuantidade();
                    }
                }
            }

            int saldo = totalProduzido - totalVendido - totalPerdido;

            // Atualizar os Labels
            lblProduzido.setText("Total Produzido: " + totalProduzido);

            lblVendido.setText("Total Vendido: " + totalVendido);

            lblPerdido.setText("Total Perdido: " + totalPerdido);

            lblSaldo.setText("Saldo: " + saldo);
        });

        comboPeriodo.fireEvent(new javafx.event.ActionEvent());


        Scene scene = new Scene(new VBox(10, comboPeriodo, lblProduzido, lblVendido, lblPerdido, lblSaldo), 400, 300);

        stage.setTitle("Relatórios");

        stage.setScene(scene);

        stage.show();


    }

}
