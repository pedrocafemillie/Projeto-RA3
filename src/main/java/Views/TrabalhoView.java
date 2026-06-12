package Views;

import com.example.Models.Trabalho;
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

public class TrabalhoView {

    private final ObservableList<Trabalho> dados = FXCollections.observableArrayList();

    public void mostrar() {



        // Campos
        TextField txtTitulo = new TextField();
        txtTitulo.setPromptText("Titulo");

        TextField txtDescricao = new TextField();
        txtDescricao.setPromptText("Descricao");

        TextField txtValor = new TextField();
        txtValor.setPromptText("Valor");

        TextField txtAtuacao = new TextField();
        txtAtuacao.setPromptText("Atuacao");

        // Botões
        Button btnSalvar = new Button("Salvar");
        Button btnExcluir = new Button("Excluir");
        Button btnAtualizar = new Button("Atualizar");
        Button btnVoltar = new Button("Voltar");

        // Tabela
        TableView<Trabalho> tabela = new TableView<>();

        TableColumn<Trabalho, String> colTitulo = new TableColumn<>("Titulo");
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));

        TableColumn<Trabalho, String> colDescricao = new TableColumn<>("Descricao");
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));

        TableColumn<Trabalho, Integer> colValor = new TableColumn<>("Valor");
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        TableColumn<Trabalho, String> colAtuacao = new TableColumn<>("Atuacao");
        colAtuacao.setCellValueFactory(new PropertyValueFactory<>("Atuacao"));


        tabela.getColumns().addAll(
                colTitulo,
                colDescricao,
                colValor,
                colAtuacao
        );

        tabela.setItems(dados);

        // Salvar
        btnSalvar.setOnAction(e -> {

            Trabalho trabalho = new Trabalho(
                    txtTitulo.getText(),
                    txtDescricao.getText(),
                    Integer.parseInt(txtValor.getText()),
                    txtAtuacao.getText()
            );

            dados.add(trabalho);

            txtTitulo.clear();
            txtDescricao.clear();
            txtValor.clear();
            txtAtuacao.clear();
        });

        // Excluir
        btnExcluir.setOnAction(e -> {

            Trabalho selecionado = tabela.getSelectionModel().getSelectedItem();

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
                txtValor.setText(String.valueOf(novo.getValor()));
                txtAtuacao.setText(novo.getAtuacao());

            }
        });

        // Atualizar
        btnAtualizar.setOnAction(e -> {

            Trabalho selecionado = tabela.getSelectionModel().getSelectedItem();

            if (selecionado != null) {
                int indice = dados.indexOf(selecionado);
                Trabalho trabalhoAtualizado = new Trabalho(
                        txtTitulo.getText(),
                        txtDescricao.getText(),
                        Integer.parseInt(txtValor.getText()),
                        txtAtuacao.getText()
                );

                dados.set(indice, trabalhoAtualizado);
                tabela.refresh();

                txtTitulo.clear();
                txtDescricao.clear();
                txtValor.clear();
                txtAtuacao.clear();
            }
        });

        VBox root = new VBox(
                10,
                txtTitulo,
                txtDescricao,
                txtValor,
                txtAtuacao,
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
