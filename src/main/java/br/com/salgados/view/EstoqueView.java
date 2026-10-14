package br.com.salgados.view;

import java.util.ArrayList;
import java.util.List;

import br.com.salgados.model.EstoqueDTO;
import br.com.salgados.model.Sabor;
import br.com.salgados.service.EstoqueService;
import br.com.salgados.service.SaborService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EstoqueView extends Application {

    @Override 
    public void start(Stage stage) {

        TableView<EstoqueDTO> tabela = new TableView<>();

        TableColumn<EstoqueDTO, String> colNome = new TableColumn<>("Sabor");

        TableColumn<EstoqueDTO, Integer> colEstoque = new TableColumn<>("Estoque");

        colNome.setCellValueFactory(
            new PropertyValueFactory<>("nome"));

        colEstoque.setCellValueFactory(
            new PropertyValueFactory<>("estoque")
        );

        tabela.getColumns().add(colNome);
        tabela.getColumns().add(colEstoque);

        SaborService saborService = new SaborService();

        EstoqueService estoqueService = new EstoqueService();

        List<Sabor> sabores = saborService.listarSabores();

        List<EstoqueDTO> estoques = new ArrayList<>();

        for (Sabor sabor : sabores) {

            int estoqueAtual = estoqueService.calcularEstoquePorSabor(sabor.getId());

            estoques.add(new EstoqueDTO(sabor.getNome(), estoqueAtual));

        }

        tabela.setItems(FXCollections.observableArrayList(estoques));

        VBox layout = new VBox(10, tabela);

        Scene scene = new Scene(layout, 500, 400);

        stage.setTitle("Estoque Atual");

        stage.setScene(scene);

        stage.show();

    }

    public static void main(String[] args) {

        launch(args);
    }

}
