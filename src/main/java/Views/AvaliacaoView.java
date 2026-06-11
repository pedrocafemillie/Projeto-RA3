package Views;

import com.example.Models.Avaliacao;
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


public class AvaliacaoView {

    private final ObservableList<Avaliacao> dados = FXCollections.observableArrayList();

    public void mostrar() {

        Stage stage = new Stage();

        // Campos
        TextField txtNota = new TextField();
        txtNota.setPromptText("Nota");

        TextField txtComentario = new TextField();
        txtComentario.setPromptText("Comentario");

        TextField txtRecomendaria = new TextField();
        txtRecomendaria.setPromptText("Recomendaria");

        // Botões
        Button btnSalvar = new Button("Salvar");
        Button btnExcluir = new Button("Excluir");
        Button btnAtualizar = new Button("Atualizar");

        // Tabela
        TableView<Avaliacao> tabela = new TableView<>();

        TableColumn<Avaliacao, Integer> colNota = new TableColumn<>("Nota");
        colNota.setCellValueFactory(new PropertyValueFactory<>("nota"));

        TableColumn<Avaliacao, String> colComentario = new TableColumn<>("Comentario");
        colComentario.setCellValueFactory(new PropertyValueFactory<>("comentario"));

        TableColumn<Avaliacao, Boolean> colRecomendaria = new TableColumn<>("Recomendaria");
        colRecomendaria.setCellValueFactory(new PropertyValueFactory<>("recomendaria"));


        tabela.getColumns().addAll(colNota, colComentario, colRecomendaria);

        tabela.setItems(dados);

        // Salvar
        btnSalvar.setOnAction(e -> {

            Avaliacao avaliacao = new Avaliacao(
                    Integer.parseInt(txtNota.getText()),
                    txtComentario.getText(),
                    Boolean.parseBoolean(txtRecomendaria.getText()));

            dados.add(avaliacao);

            txtNota.clear();
            txtComentario.clear();
            txtRecomendaria.clear();
        });

        // Excluir
        btnExcluir.setOnAction(e -> {

            Avaliacao selecionado = tabela.getSelectionModel().getSelectedItem();

            if (selecionado != null) {
                dados.remove(selecionado);
            }
        });

        // Preencher campos ao selecionar uma linha
        tabela.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            if (novo != null) {
                txtNota.setText(String.valueOf(novo.getNota()));
                txtComentario.setText(novo.getComentario());
                txtRecomendaria.setText(String.valueOf(novo.getRecomendaria()));
            }
        });

        // Atualizar
        btnAtualizar.setOnAction(e -> {

            Avaliacao selecionado = tabela.getSelectionModel().getSelectedItem();

            if (selecionado != null) {
                int indice = dados.indexOf(selecionado);
                Avaliacao avaliacaoAtualizado = new Avaliacao(
                        Integer.parseInt(txtNota.getText()),
                        txtComentario.getText(),
                        Boolean.parseBoolean(txtRecomendaria.getText())
                );

                dados.set(indice, avaliacaoAtualizado);
                tabela.refresh();

                txtNota.clear();
                txtComentario.clear();
                txtRecomendaria.clear();
            }
        });

        VBox root = new VBox(
                10,
                txtNota,
                txtComentario,
                txtRecomendaria,
                btnSalvar,
                btnAtualizar,
                btnExcluir,
                tabela
        );

        Scene scene = new Scene(root, 700, 500);

        stage.setTitle("CRUD Avaliacao");
        stage.setScene(scene);
        stage.show();
    }
}