package br.com.salgados.view;

import java.util.List;
import java.time.format.DateTimeFormatter;

import br.com.salgados.dao.MovimentacaoDAO;
import br.com.salgados.model.Movimentacao;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HistoricoMovimentacaoView extends Application {

    @Override
    public void start(Stage stage) {

        TableView<Movimentacao> tabela = new TableView<>();

        TableColumn<Movimentacao, Integer> colId = new TableColumn<>("Id");

        TableColumn<Movimentacao, Integer> colQuantidade = new TableColumn<>("Quantidade");

        TableColumn<Movimentacao, String> colObservacao = new TableColumn<>("Observação");

        TableColumn<Movimentacao, String> colSabor = new TableColumn<>("Sabor");

        TableColumn<Movimentacao, String> colTipo = new TableColumn<>("Tipo");

        TableColumn<Movimentacao, String> colData = new TableColumn<>("Data");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


        
        colId.setCellValueFactory( new PropertyValueFactory<>("id"));

        colQuantidade.setCellValueFactory( new PropertyValueFactory<>("quantidade"));

        colObservacao.setCellValueFactory( new PropertyValueFactory<>("observacao"));

        colSabor.setCellValueFactory(cellData ->
            new SimpleStringProperty(

                cellData.getValue().getSabor().getNome()
            )
        );

        colTipo.setCellValueFactory( new PropertyValueFactory<>("tipo"));

        colData.setCellValueFactory(cellData -> 

            new SimpleStringProperty(cellData.getValue().getDataMovimentacao().format(formatter))
        );



        tabela.getColumns().add(colId);
        tabela.getColumns().add(colQuantidade);
        tabela.getColumns().add(colObservacao);
        tabela.getColumns().add(colSabor);
        tabela.getColumns().add(colTipo);
        tabela.getColumns().add(colData);



        MovimentacaoDAO dao = new MovimentacaoDAO();

        List<Movimentacao> movimentacoes = dao.listarTodas();



        tabela.setItems(FXCollections.observableArrayList(movimentacoes));



        Scene scene = new Scene(new VBox(tabela), 800, 400);

        stage.setScene(scene);
        stage.show();
    }


}
