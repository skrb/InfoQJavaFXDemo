import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * シーングラフのデモ
 *
 * 複数の描画要素からシーングラフを構成する
 */
public class SceneGraphDemo extends Application {
    private WebEngine webEngine;
    private TextField urlField;

    @Override
    public void start(Stage stage) {
        Group root = new Group();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        // 円
        Circle circle = new Circle(200.0, 200.0, 300.0, Color.PINK);
        root.getChildren().add(circle);

        // ボーダーレイアウト
        BorderPane borderPane = new BorderPane();
        root.getChildren().add(borderPane);

        // ブラウザ
        WebView view = new WebView();
        WebEngine engine = view.getEngine();
        borderPane.setCenter(view);

        // 水平ボックス
        HBox hbox = new HBox(10);
        borderPane.setTop(hbox);

        // ラベル
        Label label = new Label("URL:");
        hbox.getChildren().add(label);

        // テキスト入力
        TextField textField = new TextField();
        textField.setPrefColumnCount(40);
        hbox.getChildren().add(textField);

        // ボタン
        Button button = new Button("Open");
        hbox.getChildren().add(button);

        // プロパティの設定

        stage.setTitle("SceneGraph Demo");

        GaussianBlur blur = new GaussianBlur();
        blur.setRadius(20.0);
        circle.setEffect(blur);

        view.setOpacity(0.8);
        webEngine = engine;

        hbox.setTranslateY(10);
        hbox.setPrefHeight(40);
        hbox.setAlignment(Pos.BASELINE_CENTER);

        label.setStyle("-fx-font-family: 'sans-serif'; -fx-font-size: 16;");
        textField.setStyle("-fx-font-family: 'sans-serif'; -fx-font-size: 16;");
        urlField = textField;
        button.setStyle("-fx-font-family: 'sans-serif'; -fx-font-size: 16;");

        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String url = urlField.getText();
                if (url != null && !url.trim().isEmpty()) {
                    webEngine.load(url);
                }
            }
        });

        // 表示
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(null);
    }
}