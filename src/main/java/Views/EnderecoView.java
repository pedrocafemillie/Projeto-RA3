package Views;

import com.example.Models.Endereco;
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

public class EnderecoView {

    private final ObservableList<Endereco> dados = FXCollections.observableArrayList();

    public void mostrar() {



        // Campos
        TextField txtRua = new TextField();
        txtRua.setPromptText("Rua");

        TextField txtNumero = new TextField();
        txtNumero.setPromptText("Numero");

        TextField txtBairro = new TextField();
        txtBairro.setPromptText("Bairro");

        TextField txtCep = new TextField();
        txtCep.setPromptText("CEP");

        TextField txtComplemento = new TextField();
        txtComplemento.setPromptText("Complemento");

        // Botões
        Button btnSalvar = new Button("Salvar");
        Button btnExcluir = new Button("Excluir");
        Button btnAtualizar = new Button("Atualizar");
        Button btnVoltar = new Button("Voltar");

        // Tabela
        TableView<Endereco> tabela = new TableView<>();

        TableColumn<Endereco, String> colRua = new TableColumn<>("Rua");
        colRua.setCellValueFactory(new PropertyValueFactory<>("rua"));

        TableColumn<Endereco, Integer> colNumero = new TableColumn<>("Numero");
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));

        TableColumn<Endereco, String> colBairro = new TableColumn<>("Bairro");
        colBairro.setCellValueFactory(new PropertyValueFactory<>("Bairro"));

        TableColumn<Endereco, String> colCep = new TableColumn<>("CEP");
        colCep.setCellValueFactory(new PropertyValueFactory<>("CEP"));

        TableColumn<Endereco, String> colComplemento = new TableColumn<>("Complemento");
        colComplemento.setCellValueFactory(new PropertyValueFactory<>("Complemento"));


        tabela.getColumns().addAll(
                colRua,
                colNumero,
                colBairro,
                colCep,
                colComplemento
        );

        tabela.setItems(dados);

        // Salvar
        btnSalvar.setOnAction(e -> {

            Endereco endereco = new Endereco(
                    txtRua.getText(),
                    Integer.parseInt(txtNumero.getText()),
                    txtBairro.getText(),
                    txtCep.getText(),
                    txtComplemento.getText()
            );

            dados.add(endereco);

            txtRua.clear();
            txtNumero.clear();
            txtBairro.clear();
            txtCep.clear();
            txtComplemento.clear();
        });

        // Excluir
        btnExcluir.setOnAction(e -> {

            Endereco selecionado = tabela.getSelectionModel().getSelectedItem();

            if (selecionado != null) {
                dados.remove(selecionado);
            }
        });

        btnVoltar.setOnAction(e -> Main.voltarMenu());

        // Preencher campos ao selecionar uma linha
        tabela.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            if (novo != null) {
                txtRua.setText(novo.getRua());
                txtNumero.setText(String.valueOf(novo.getNumero()));
                txtBairro.setText(novo.getBairro());
                txtCep.setText(novo.getCep());
                txtComplemento.setText(novo.getComplemento());

            }
        });

        // Atualizar
        btnAtualizar.setOnAction(e -> {

            Endereco selecionado = tabela.getSelectionModel().getSelectedItem();

            if (selecionado != null) {
                int indice = dados.indexOf(selecionado);
                Endereco enderecoAtualizado = new Endereco(
                        txtRua.getText(),
                        Integer.parseInt(txtNumero.getText()),
                        txtBairro.getText(),
                        txtCep.getText(),
                        txtComplemento.getText()
                );

                dados.set(indice, enderecoAtualizado);
                tabela.refresh();

                txtRua.clear();
                txtNumero.clear();
                txtBairro.clear();
                txtCep.clear();
                txtComplemento.clear();
            }
        });

        VBox root = new VBox(
                10,
                txtRua,
                txtNumero,
                txtBairro,
                txtCep,
                txtComplemento,
                btnSalvar,
                btnAtualizar,
                btnExcluir,
                btnVoltar,
                tabela
        );

        Scene scene = new Scene(root, 700, 500);

        Main.palcoPrincipal.setTitle("CRUD Endereco");
        Main.palcoPrincipal.setScene(scene);
    }
}