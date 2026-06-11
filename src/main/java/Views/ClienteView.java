package Views;

import com.example.Models.Cliente;
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

public class ClienteView {

    private final ObservableList<Cliente> dados = FXCollections.observableArrayList();

    public void mostrar() {



        // Campos
        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome");

        TextField txtEmail = new TextField();
        txtEmail.setPromptText("Email");

        TextField txtCpf = new TextField();
        txtCpf.setPromptText("CPF");

        TextField txtTelefone = new TextField();
        txtTelefone.setPromptText("Telefone");

        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Senha");

        // Botões
        Button btnSalvar = new Button("Salvar");
        Button btnExcluir = new Button("Excluir");
        Button btnAtualizar = new Button("Atualizar");
        Button btnVoltar = new Button("Voltar");

        // Tabela
        TableView<Cliente> tabela = new TableView<>();

        TableColumn<Cliente, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Cliente, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Cliente, String> colCpf = new TableColumn<>("CPF");
        colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        TableColumn<Cliente, String> colTelefone = new TableColumn<>("Telefone");
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        TableColumn<Cliente, String> colSenha = new TableColumn<>("Senha");
        colSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));

        tabela.getColumns().addAll(
                colNome,
                colEmail,
                colCpf,
                colTelefone,
                colSenha
        );

        tabela.setItems(dados);

        // Salvar
        btnSalvar.setOnAction(e -> {

            Cliente cliente = new Cliente(
                    txtNome.getText(),
                    txtEmail.getText(),
                    txtCpf.getText(),
                    txtTelefone.getText(),
                    txtSenha.getText()
            );

            dados.add(cliente);

            txtNome.clear();
            txtEmail.clear();
            txtCpf.clear();
            txtTelefone.clear();
            txtSenha.clear();
        });

        // Excluir
        btnExcluir.setOnAction(e -> {

            Cliente selecionado =
                    tabela.getSelectionModel().getSelectedItem();

            if (selecionado != null) {
                dados.remove(selecionado);
            }
        });

        btnVoltar.setOnAction(e -> Main.voltarMenu());

        // Preencher campos ao selecionar uma linha
        tabela.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
                    if (novo != null) {
                        txtNome.setText(novo.getNome());
                        txtEmail.setText(novo.getEmail());
                        txtCpf.setText(novo.getCpf());
                        txtTelefone.setText(novo.getTelefone());
                        txtSenha.setText(novo.getSenha());
                    }
                });

        // Atualizar
        btnAtualizar.setOnAction(e -> {

            Cliente selecionado = tabela.getSelectionModel().getSelectedItem();

            if (selecionado != null) {
                int indice = dados.indexOf(selecionado);
                Cliente clienteAtualizado = new Cliente(
                        txtNome.getText(),
                        txtEmail.getText(),
                        txtCpf.getText(),
                        txtTelefone.getText(),
                        txtSenha.getText()
                );

                dados.set(indice, clienteAtualizado);
                tabela.refresh();

                txtNome.clear();txtEmail.clear();
                txtCpf.clear();
                txtTelefone.clear();
                txtSenha.clear();
            }
        });

        VBox root = new VBox(
                10,
                txtNome,
                txtEmail,
                txtCpf,
                txtTelefone,
                txtSenha,
                btnSalvar,
                btnAtualizar,
                btnExcluir,
                btnVoltar,
                tabela
        );

        Scene scene = new Scene(root, 700, 500);

        Main.palcoPrincipal.setTitle("CRUD Cliente");
        Main.palcoPrincipal.setScene(scene);
    }
}