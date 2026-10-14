package br.com.salgados.view;

import br.com.salgados.model.Sabor;
import br.com.salgados.service.SaborService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;


public class ListaSaboresView extends Application {

    @Override
    public void start(Stage stage) {

        TableView<Sabor> tabela = new TableView<>();

        TableColumn<Sabor, Integer> colId = new TableColumn<>("ID");
        
        TableColumn<Sabor, String> colNome = new TableColumn<>("Nome");

        TableColumn<Sabor, String> colDescricao = new TableColumn<>("Descrição");

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        tabela.getColumns().add(colId);
        tabela.getColumns().add(colNome);
        tabela.getColumns().add(colDescricao);

        SaborService service = new SaborService();

        List<Sabor> sabores = service.listarSabores();

        tabela.setItems(FXCollections.observableArrayList(sabores));

        TextField txtNome = new TextField();

        TextField txtDescricao = new TextField();

        final Sabor[] saborSelecionado = new Sabor[1];

        tabela.getSelectionModel().selectedItemProperty().addListener((observable, valorAntigo, novoValor) -> {

            if (novoValor != null) {

                saborSelecionado[0] = novoValor;

                txtNome.setText(novoValor.getNome());

                txtDescricao.setText(novoValor.getDescricao());
            }
        }
    );

        Button btnExcluir = new Button("Excluir");

        Button btnAtualizar = new Button("ATUALIZAR");

        btnExcluir.setOnAction(event -> {


             if (saborSelecionado != null) {

                service.excluirSabor(saborSelecionado[0].getId());

                tabela.getItems().remove(saborSelecionado[0]);
             }
        });

        btnAtualizar.setOnAction(event -> {

            if (saborSelecionado[0] != null) {

                service.atualizarSabor(saborSelecionado[0].getId(), txtNome.getText(), txtDescricao.getText());

                saborSelecionado[0].setNome(txtNome.getText());

                saborSelecionado[0].setDescricao(txtDescricao.getText());

                tabela.refresh();
            }
        });



        VBox layout = new VBox(10, txtNome, txtDescricao, btnAtualizar, tabela, btnExcluir);

        Scene scene = new Scene(layout, 600, 400);

        stage.setTitle("Lista de Sabores");

        stage.setScene(scene);

        stage.show();
    }
     public static void main(String[] args) {

        launch(args);
     }

}