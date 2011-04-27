import javafx.application.Application;
import javafx.application.Launcher;
import javafx.async.Task;
import javafx.async.TaskEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextBox;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewDemo extends Application {
    private WebEngine engine;
    private TextBox urlBox;

    @Override
    public void start(Stage stage) {
        stage.setTitle("WebView Demo");

        BorderPane borderPane = new BorderPane();
        borderPane.setLayoutY(10);
        borderPane.setLayoutX(10);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);

        // ブラウザ
        engine = new WebEngine();
        WebView view = new WebView(engine);
        view.setPrefSize(600,500);
        borderPane.setCenter(view);
        
        // 反射効果を加える
        Reflection reflection = new Reflection();
        reflection.setFraction(0.5);
        view.setEffect(reflection);

        // ページのロードが終了した時の処理
        Task<Void> task = engine.getLoadTask();
        task.setOnDone(new EventHandler<TaskEvent>() {
            public void handle(TaskEvent event) {
                String url = engine.getUrl();
                urlBox.setText(url);
            }
        });

        // 水平ボックス
        HBox hbox = new HBox(10);
        hbox.setPrefHeight(40);
        hbox.setAlignment(Pos.BASELINE_CENTER);
        borderPane.setTop(hbox);

        // テキスト入力
        urlBox = new TextBox(40);
        urlBox.setFont(new Font("sanserif", 16));
        hbox.getChildren().add(urlBox);

        urlBox.setAction(new Runnable() {
            public void run() {
                loadUrl();
            }
        });

        // ボタン
        Button button = new Button("Open");
        button.setFont(new Font("sanserif", 16));
        hbox.getChildren().add(button);

        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                loadUrl();
            }
        });

        stage.setVisible(true);
    }

    // ページのロード
    private void loadUrl() {
        String url = urlBox.getText();
        if (url != null && !url.trim().isEmpty()) {
            engine.load(url);
        }
    }

    public static void main(String[] args) {
        Launcher.launch(WebViewDemo.class, null);
    }
}