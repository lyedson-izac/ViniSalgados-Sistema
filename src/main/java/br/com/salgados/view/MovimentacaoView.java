package br.com.salgados.view;

import java.util.List;

import br.com.salgados.model.Sabor;
import br.com.salgados.model.TipoMovimentacao;
import br.com.salgados.service.MovimentacaoService;
import br.com.salgados.service.SaborService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MovimentacaoView extends Application {

    @Override
    public void start(Stage stage) {

        Label lblSabor = new Label("Sabor");

        Label lblTipo = new Label("Tipo de Movimentação");

        Label lblQuantidade = new Label("Quantidade");

        ComboBox<Sabor> comboSabores = new ComboBox<>();

        ComboBox<TipoMovimentacao> comboTipo = new ComboBox<>();

        TextField txtQuantidade = new TextField();

        txtQuantidade.setPromptText("Digite a quantidade");

        Button btnRegistrar = new Button("Registrar");

        MovimentacaoService movimentacaoService = new MovimentacaoService();

        btnRegistrar.setOnAction( evet -> {

            Sabor saborSelecionado = comboSabores.getValue();

            TipoMovimentacao tipoSelecionado = comboTipo.getValue();

            int quantidade = Integer.parseInt(txtQuantidade.getText());

            if (tipoSelecionado == TipoMovimentacao.PRODUCAO) {

                movimentacaoService.registrarProducao(saborSelecionado.getId(),
                quantidade,
                ""

                );
            }

            if (tipoSelecionado == TipoMovimentacao.VENDA) {

                movimentacaoService.registrarVenda(saborSelecionado.getId(),
            quantidade,
        "");
            }

            if (tipoSelecionado == TipoMovimentacao.PERDA) {

                movimentacaoService.registrarPerda(saborSelecionado.getId(),
            quantidade,
        "");
            }

            txtQuantidade.clear();


        });

        SaborService saborService = new SaborService();

        List<Sabor> sabores = saborService.listarSabores();

        comboSabores.setItems(FXCollections.observableArrayList(sabores));

        comboTipo.getItems().addAll(
            TipoMovimentacao.PRODUCAO,
            TipoMovimentacao.VENDA,
            TipoMovimentacao.PERDA
        );



        VBox layout = new VBox(
            10, 
            
            lblSabor, 
            comboSabores, 
            
            lblTipo,
            comboTipo, 
            
            lblQuantidade,
            txtQuantidade, 
            
            btnRegistrar);

        Scene scene = new Scene(layout, 400, 300);

        stage.setTitle("Movimentações");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }



}
