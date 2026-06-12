package Views;

import com.example.Models.Prestador;
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

public class PrestadorView {

    private final ObservableList<Prestador> dados = FXCollections.observableArrayList();

    public void mostrar() {



        // Campos
        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome");

        TextField txtEmail = new TextField();
        txtEmail.setPromptText("Email");

        TextField txtCpf = new TextField();
        txtCpf.setPromptText("CPF");

        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Senha");

        TextField txtEspecialidade = new TextField();
        txtEspecialidade.setPromptText("Especialidade");

        TextField txtTipo = new TextField();
        txtTipo.setPromptText("Tipo");

        // Botões
        Button btnSalvar = new Button("Salvar");
        Button btnExcluir = new Button("Excluir");
        Button btnAtualizar = new Button("Atualizar");
        Button btnVoltar = new Button("Voltar");

        // Tabela
        TableView<Prestador> tabela = new TableView<>();

        TableColumn<Prestador, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Prestador, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Prestador, String> colCpf = new TableColumn<>("CPF");
        colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        TableColumn<Prestador, String> colSenha = new TableColumn<>("Senha");
        colSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));

        TableColumn<Prestador, String> colEspecialidade = new TableColumn<>("Especialidade");
        colEspecialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));

        TableColumn<Prestador, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        tabela.getColumns().addAll(
                colNome,
                colEmail,
                colCpf,
                colSenha,
                colEspecialidade,
                colTipo
        );

        tabela.setItems(dados);

        // Salvar
        btnSalvar.setOnAction(e -> {

            Prestador prestador = new Prestador(
                    txtNome.getText(),
                    txtEmail.getText(),
                    txtCpf.getText(),
                    txtSenha.getText(),
                    txtEspecialidade.getText(),
                    txtTipo.getText()
            );

            dados.add(prestador);

            txtNome.clear();
            txtEmail.clear();
            txtCpf.clear();
            txtSenha.clear();
            txtEspecialidade.clear();
            txtTipo.clear();
        });

        // Excluir
        btnExcluir.setOnAction(e -> {

            Prestador selecionado = tabela.getSelectionModel().getSelectedItem();

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
                txtSenha.setText(novo.getSenha());
                txtEspecialidade.setText(novo.getEspecialidade());
                txtTipo.setText(novo.getTipo());

            }
        });

        // Atualizar
        btnAtualizar.setOnAction(e -> {

            Prestador selecionado = tabela.getSelectionModel().getSelectedItem();

            if (selecionado != null) {
                int indice = dados.indexOf(selecionado);
                Prestador prestadorAtualizado = new Prestador(
                        txtNome.getText(),
                        txtEmail.getText(),
                        txtCpf.getText(),
                        txtSenha.getText(),
                        txtEspecialidade.getText(),
                        txtTipo.getText()
                );

                dados.set(indice, prestadorAtualizado);
                tabela.refresh();

                txtNome.clear();
                txtEmail.clear();
                txtCpf.clear();
                txtSenha.clear();
                txtEspecialidade.clear();
                txtTipo.clear();
            }
        });

        VBox root = new VBox(
                10,
                txtNome,
                txtEmail,
                txtCpf,
                txtSenha,
                txtEspecialidade,
                txtTipo,
                btnSalvar,
                btnAtualizar,
                btnExcluir,
                btnVoltar,
                tabela
        );

        Scene scene = new Scene(root, 700, 500);

        Main.palcoPrincipal.setTitle("CRUD Prestador");
        Main.palcoPrincipal.setScene(scene);
    }
}