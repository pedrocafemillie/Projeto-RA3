package Views;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage palcoPrincipal;

    @Override
    public void start(Stage stage) {

        palcoPrincipal = stage;

        Button btnCliente = new Button("Cliente");
        Button btnEmpresa = new Button("Empresa");
        Button btnEndereco = new Button("Endereço");
        Button btnPrestador = new Button("Prestador");
        Button btnServico = new Button("Serviço");
        Button btnTrabalho = new Button("Trabalho");
        Button btnCartao = new Button("Cartão");
        Button btnAvaliacao = new Button("Avaliação");

        btnCliente.setOnAction(e -> new ClienteView().mostrar());

        VBox root = new VBox(
                10,
                btnCliente,
                btnEmpresa,
                btnEndereco,
                btnPrestador,
                btnServico,
                btnTrabalho,
                btnCartao,
                btnAvaliacao
        );

        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 400);

        stage.setTitle("Sistema de Serviços");
        stage.setScene(scene);
        stage.show();
    }
    public static void voltarMenu() {

        Button btnCliente = new Button("Cliente");
        Button btnEmpresa = new Button("Empresa");
        Button btnEndereco = new Button("Endereço");
        Button btnPrestador = new Button("Prestador");
        Button btnServico = new Button("Serviço");
        Button btnTrabalho = new Button("Trabalho");
        Button btnCartao = new Button("Cartão");
        Button btnAvaliacao = new Button("Avaliação");

        btnAvaliacao.setOnAction(e -> new AvaliacaoView().mostrar());
        btnCartao.setOnAction(e -> new CartaoView().mostrar());
        btnCliente.setOnAction(e -> new ClienteView().mostrar());

        VBox root = new VBox(
                10,
                btnCliente,
                btnEmpresa,
                btnEndereco,
                btnPrestador,
                btnServico,
                btnTrabalho,
                btnCartao,
                btnAvaliacao
        );

        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 400);

        palcoPrincipal.setScene(scene);
    }
}