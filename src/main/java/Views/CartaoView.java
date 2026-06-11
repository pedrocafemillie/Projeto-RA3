package Views;

import com.example.Models.Cartao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class CartaoView {

    private final ObservableList<Cartao> dados = FXCollections.observableArrayList();

    public void mostrar() {

        Stage stage = new Stage();

        // Campos
        TextField txtNumero = new TextField();
        txtNumero.setPromptText("Numero");

        TextField txtCvv = new TextField();
        txtCvv.setPromptText("Cvv");

        TextField txtValidade = new TextField();
        txtValidade.setPromptText("MM-AA");

        TextField txtTipo = new TextField();
        txtTipo.setPromptText("Tipo");

        TextField txtTitular = new TextField();
        txtTitular.setPromptText("Titular");

        // Botões
        Button btnSalvar = new Button("Salvar");
        Button btnExcluir = new Button("Excluir");
        Button btnAtualizar = new Button("Atualizar");

        // Tabela
        TableView<Cartao> tabela = new TableView<>();

        TableColumn<Cartao, String> colNumero = new TableColumn<>("Numero");
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));

        TableColumn<Cartao, String> colCvv = new TableColumn<>("Cvv");
        colCvv.setCellValueFactory(new PropertyValueFactory<>("cvv"));

        TableColumn<Cartao, String> colValidade = new TableColumn<>("Validade");
        colValidade.setCellValueFactory(new PropertyValueFactory<>("validade"));

        TableColumn<Cartao, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        TableColumn<Cartao, String> colTitular = new TableColumn<>("Titular");
        colTitular.setCellValueFactory(new PropertyValueFactory<>("titular"));


        tabela.getColumns().addAll(colNumero, colCvv, colValidade, colTipo, colTitular);

        tabela.setItems(dados);

        // Salvar
        btnSalvar.setOnAction(e -> {

            Cartao cartao = new Cartao(
                    txtNumero.getText(),
                    txtCvv.getText(),
                    txtValidade.getText(),
                    txtTipo.getText(),
                    txtTitular.getText());

            dados.add(cartao);

            txtNumero.clear();
            txtCvv.clear();
            txtValidade.clear();
            txtTipo.clear();
            txtTitular.clear();
        });

        // Excluir
        btnExcluir.setOnAction(e -> {

            Cartao selecionado = tabela.getSelectionModel().getSelectedItem();

            if (selecionado != null) {
                dados.remove(selecionado);
            }
        });

        // Preencher campos ao selecionar uma linha
        tabela.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            if (novo != null) {
                txtNumero.setText(novo.getNumero());
                txtCvv.setText(novo.getCvv());
                txtValidade.setText(novo.getValidade());
                txtTipo.setText(novo.getTipo());
                txtTitular.setText(novo.getTitular());


            }
        });

        // Atualizar
        btnAtualizar.setOnAction(e -> {

            Cartao selecionado = tabela.getSelectionModel().getSelectedItem();

            if (selecionado != null) {
                int indice = dados.indexOf(selecionado);
                Cartao cartaoAtualizado = new Cartao(
                        txtNumero.getText(),
                        txtCvv.getText(),
                        txtValidade.getText(),
                        txtTipo.getText(),
                        txtTitular.getText()
                );

                dados.set(indice, cartaoAtualizado);
                tabela.refresh();

                txtNumero.clear();
                txtCvv.clear();
                txtValidade.clear();
                txtTipo.clear();
                txtTitular.clear();

            }
        });

        VBox root = new VBox(
                10,
                txtNumero,
                txtCvv,
                txtValidade,
                txtTipo,
                txtTitular,
                btnSalvar,
                btnAtualizar,
                btnExcluir,
                tabela
        );

        Scene scene = new Scene(root, 700, 500);

        stage.setTitle("CRUD Cartao");
        stage.setScene(scene);
        stage.show();
    }
}