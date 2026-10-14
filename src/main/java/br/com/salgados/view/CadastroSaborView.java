package br.com.salgados.view;

import br.com.salgados.service.SaborService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class CadastroSaborView extends Application {

    @Override
    public void start(Stage stage) {

        Label lblNome = new Label("Nome:");

        TextField txtNome = new TextField("Digite o nome do Sabor");

        Label lblDescricao = new Label("Descrição:");

        TextField txtDescricao = new TextField("Digite a descrição");

        Button btnCadastrar = new Button("Cadastrar");

        btnCadastrar.setOnAction(event -> {

            try {

                SaborService service = new SaborService();

                service.cadastrarSabor(txtNome.getText(), txtDescricao.getText());

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);

                alerta.setTitle("sucesso");

                alerta.setHeaderText(null);

                alerta.setContentText("Sabor cadastrado com sucesso!");

                alerta.showAndWait();
            
            txtNome.clear();

            txtDescricao.clear();
        
        } catch (Exception e) {

            Alert alerta = new Alert(Alert.AlertType.ERROR);

            alerta.setTitle("Erro");

            alerta.setHeaderText(null);

            alerta.setContentText(e.getMessage());

            alerta.showAndWait();
        }

        });

        VBox layout = new VBox();

        layout.setSpacing(10);

        layout.setPadding(new Insets(10));

        layout.getChildren().addAll(
            lblNome,
            txtNome,
            lblDescricao,
            txtDescricao,
            btnCadastrar
        );

        Scene scene = new Scene(layout, 400, 250);

        stage.setTitle("Cadastro de sabores");

        stage.setScene(scene);

        stage.show();


    }

    public static void main(String[] args) {

        launch(args);
    }

}
