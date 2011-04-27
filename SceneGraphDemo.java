import javafx.application.Application;
import javafx.application.Launcher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextBox;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class SceneGraphDemo extends Application {
    private WebEngine webEngine;
    private TextBox urlBox;

    @Override
    public void start(Stage stage) {
        Group root = new Group();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        // �~
        Circle circle = new Circle(200.0, 200.0, 300.0, Color.PINK);
        root.getChildren().add(circle);

        // �{�[�_�[���C�A�E�g
        BorderPane borderPane = new BorderPane();
        root.getChildren().add(borderPane);

        // �u���E�U
        WebEngine engine = new WebEngine();
        WebView view = new WebView(engine);
        borderPane.setCenter(view);

        // �����{�b�N�X
        HBox hbox = new HBox(10);
        borderPane.setTop(hbox);

        // ���x��
        Label label = new Label("URL:");
        hbox.getChildren().add(label);

        // �e�L�X�g����
        TextBox textBox = new TextBox(40);
        hbox.getChildren().add(textBox);

        // �{�^��
        Button button = new Button("Open");
        hbox.getChildren().add(button);

        // �v���p�e�B�̐ݒ�

        stage.setTitle("SceneGraph Demo");

        GaussianBlur blur = new GaussianBlur();
        blur.setRadius(20.0);
        circle.setEffect(blur);

        view.setOpacity(0.8);
        webEngine = engine;

        hbox.setTranslateY(10);
        hbox.setPrefHeight(40);
        hbox.setAlignment(Pos.BASELINE_CENTER);

        label.setFont(new Font("sanserif", 16));
        textBox.setFont(new Font("sanserif", 16));
        urlBox = textBox;
        button.setFont(new Font("sanserif", 16));

        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String url = urlBox.getText();
                if (url != null && !url.trim().isEmpty()) {
                    webEngine.load(url);
                }
            }
        });

        // �\��
        stage.setVisible(true);
    }

    public static void main(String[] args) {
        Launcher.launch(SceneGraphDemo.class, null);
    }
}