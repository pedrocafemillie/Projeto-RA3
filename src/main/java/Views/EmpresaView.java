package Views;

import com.example.Models.Empresa;
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

public class EmpresaView {

    private final ObservableList<Empresa> dados = FXCollections.observableArrayList();

    public void mostrar() {



        // Campos
        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome");

        TextField txtCnpj = new TextField();
        txtCnpj.setPromptText("Cnpj");

        TextField txtRazaoSocial = new TextField();
        txtRazaoSocial.setPromptText("Razao Social");

        TextField txtAreaAtuacao = new TextField();
        txtAreaAtuacao.setPromptText("Area de atuacao");

        // Botões
        Button btnSalvar = new Button("Salvar");
        Button btnExcluir = new Button("Excluir");
        Button btnAtualizar = new Button("Atualizar");
        Button btnVoltar = new Button("Voltar");

        // Tabela
        TableView<Empresa> tabela = new TableView<>();

        TableColumn<Empresa, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Empresa, String> colCnpj = new TableColumn<>("Cnpj");
        colCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));

        TableColumn<Empresa, String> colRazaoSocial = new TableColumn<>("Razao Social");
        colRazaoSocial.setCellValueFactory(new PropertyValueFactory<>("Razao Social"));

        TableColumn<Empresa, String> colAreaAtuacao = new TableColumn<>("Area de atuacao");
        colAreaAtuacao.setCellValueFactory(new PropertyValueFactory<>("Area de atuacao"));


        tabela.getColumns().addAll(
                colNome,
                colCnpj,
                colRazaoSocial,
                colAreaAtuacao
        );

        tabela.setItems(dados);

        // Salvar
        btnSalvar.setOnAction(e -> {

            Empresa empresa = new Empresa(
                    txtNome.getText(),
                    txtCnpj.getText(),
                    txtRazaoSocial.getText(),
                    txtAreaAtuacao.getText()
            );

            dados.add(empresa);

            txtNome.clear();
            txtCnpj.clear();
            txtRazaoSocial.clear();
            txtAreaAtuacao.clear();
        });

        // Excluir
        btnExcluir.setOnAction(e -> {

            Empresa selecionado = tabela.getSelectionModel().getSelectedItem();

            if (selecionado != null) {
                dados.remove(selecionado);
            }
        });

        btnVoltar.setOnAction(e -> Main.voltarMenu());

        // Preencher campos ao selecionar uma linha
        tabela.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            if (novo != null) {
                txtNome.setText(novo.getNome());
                txtCnpj.setText(novo.getCnpj());
                txtRazaoSocial.setText(novo.getRazaoSocial());
                txtAreaAtuacao.setText(novo.getAreaAtuacao());

            }
        });

        // Atualizar
        btnAtualizar.setOnAction(e -> {

            Empresa selecionado = tabela.getSelectionModel().getSelectedItem();

            if (selecionado != null) {
                int indice = dados.indexOf(selecionado);
                Empresa empresaAtualizado = new Empresa(
                        txtNome.getText(),
                        txtCnpj.getText(),
                        txtRazaoSocial.getText(),
                        txtAreaAtuacao.getText()
                );

                dados.set(indice, empresaAtualizado);
                tabela.refresh();

                txtNome.clear();
                txtCnpj.clear();
                txtRazaoSocial.clear();
                txtAreaAtuacao.clear();
            }
        });

        VBox root = new VBox(
                10,
                txtNome,
                txtCnpj,
                txtRazaoSocial,
                txtAreaAtuacao,
                btnSalvar,
                btnAtualizar,
                btnExcluir,
                btnVoltar,
                tabela
        );

        Scene scene = new Scene(root, 700, 500);

        Main.palcoPrincipal.setTitle("CRUD Empresa");
        Main.palcoPrincipal.setScene(scene);
    }
}