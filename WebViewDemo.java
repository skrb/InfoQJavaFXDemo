import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * ブラウザのデモ
 *
 * カスタムWebブラウザを実現する
 */
public class WebViewDemo extends Application {
    private WebEngine engine;
    private TextField urlField;

    @Override
    public void start(Stage stage) {
        stage.setTitle("WebView Demo");

        BorderPane borderPane = new BorderPane();
        borderPane.setLayoutY(10);
        borderPane.setLayoutX(10);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);

        // ブラウザ
        WebView view = new WebView();
        engine = view.getEngine();
        view.setPrefSize(600,500);
        borderPane.setCenter(view);
        
        // 反射効果を加える
        Reflection reflection = new Reflection();
        reflection.setFraction(0.5);
        view.setEffect(reflection);
        
        // Webページのロードのタスク
        Worker worker = engine.getLoadWorker();

        // ページのロードが終了した時の処理
        worker.stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> state,
                    Worker.State oldValue, Worker.State newValue) {
                if (newValue == Worker.State.SUCCEEDED) {
                    String url = engine.getLocation();
                    if (url != null && !url.isEmpty()) {
                        urlField.setText(url);
                    }
                }
            }
        });        

        // 水平ボックス
        HBox hbox = new HBox(10);
        hbox.setPrefHeight(40);
        hbox.setAlignment(Pos.BASELINE_CENTER);
        borderPane.setTop(hbox);

        // イベントハンドラー
        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                loadUrl();
            }
        };

        // テキスト入力
        urlField = new TextField();
        urlField.setPrefColumnCount(40);
        urlField.setStyle("-fx-font-family: 'sans-serif'; -fx-font-size: 16;");
        hbox.getChildren().add(urlField);
        urlField.setOnAction(handler);

        // ボタン
        Button button = new Button("Open");
        button.setFont(new Font("sanserif", 16));
        hbox.getChildren().add(button);
        button.setOnAction(handler);

        stage.show();
    }

    // ページのロード
    private void loadUrl() {
        String url = urlField.getText();
        if (url != null && !url.trim().isEmpty()) {
            engine.load(url);
        }
    }

    public static void main(String[] args) {
        Application.launch(null);
    }
}