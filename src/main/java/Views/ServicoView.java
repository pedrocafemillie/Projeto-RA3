package Views;

import com.example.Models.Servico;
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

public class ServicoView {

    private final ObservableList<Servico> dados = FXCollections.observableArrayList();

    public void mostrar() {



        // Campos
        TextField txtTitulo = new TextField();
        txtTitulo.setPromptText("Titulo");

        TextField txtDescricao = new TextField();
        txtDescricao.setPromptText("Descricao");

        TextField txtData = new TextField();
        txtData.setPromptText("Data");

        TextField txtValor = new TextField();
        txtValor.setPromptText("Valor");

        TextField txtRua = new TextField();
        txtRua.setPromptText("Rua");

        // Botões
        Button btnSalvar = new Button("Salvar");
        Button btnExcluir = new Button("Excluir");
        Button btnAtualizar = new Button("Atualizar");
        Button btnVoltar = new Button("Voltar");

        // Tabela
        TableView<Servico> tabela = new TableView<>();

        TableColumn<Servico, String> colTitulo = new TableColumn<>("Titulo");
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));

        TableColumn<Servico, String> colDescricao = new TableColumn<>("Descricao");
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));

        TableColumn<Servico, String> colData = new TableColumn<>("Data");
        colData.setCellValueFactory(new PropertyValueFactory<>("Data"));

        TableColumn<Servico, Integer> colValor = new TableColumn<>("Valor");
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        TableColumn<Servico, String> colRua = new TableColumn<>("Rua");
        colRua.setCellValueFactory(new PropertyValueFactory<>("rua"));


        tabela.getColumns().addAll(
                colTitulo,
                colDescricao,
                colData,
                colValor,
                colRua
        );

        tabela.setItems(dados);

        // Salvar
        btnSalvar.setOnAction(e -> {

            Servico servico = new Servico(
                    txtTitulo.getText(),
                    txtDescricao.getText(),
                    txtData.getText(),
                    Integer.parseInt(txtValor.getText()),
                    txtRua.getText()
            );

            dados.add(servico);

            txtTitulo.clear();
            txtDescricao.clear();
            txtData.clear();
            txtValor.clear();
            txtRua.clear();
        });

        // Excluir
        btnExcluir.setOnAction(e -> {

            Servico selecionado = tabela.getSelectionModel().getSelectedItem();

            if (selecionado != null) {
                dados.remove(selecionado);
            }
        });

        btnVoltar.setOnAction(e -> Main.voltarMenu());

        // Preencher campos ao selecionar uma linha
        tabela.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            if (novo != null) {

                txtTitulo.setText(novo.getTitulo());
                txtDescricao.setText(novo.getDescricao());
                txtData.setText(novo.getData());
                txtValor.setText(String.valueOf(novo.getValor()));
                txtRua.setText(novo.getRua());

            }
        });

        // Atualizar
        btnAtualizar.setOnAction(e -> {

            Servico selecionado = tabela.getSelectionModel().getSelectedItem();

            if (selecionado != null) {
                int indice = dados.indexOf(selecionado);
                Servico servicoAtualizado = new Servico(
                        txtTitulo.getText(),
                        txtDescricao.getText(),
                        txtData.getText(),
                        Integer.parseInt(txtValor.getText()),
                        txtRua.getText()
                );

                dados.set(indice, servicoAtualizado);
                tabela.refresh();

                txtTitulo.clear();
                txtDescricao.clear();
                txtData.clear();
                txtValor.clear();
                txtRua.clear();
            }
        });

        VBox root = new VBox(
                10,
                txtTitulo,
                txtDescricao,
                txtData,
                txtValor,
                txtRua,
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