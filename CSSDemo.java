import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * CSSのデモ
 *
 * CSSによって見栄えを定義する
 */
public class CSSDemo extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("CSS Demo");

        HBox container = new HBox(20);
        container.setAlignment(Pos.CENTER);

        Scene scene = new Scene(container, 400, 100);
        // スタイルシートの設定
        scene.getStylesheets().add("/style.css");

        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        // IDを設定する
        button3.setId("button3");

        container.getChildren().add(button1);
        container.getChildren().add(button2);
        container.getChildren().add(button3);

        stage.setScene(scene);
        stage.setVisible(true);
    }

    public static void main(String[] args) {
        Application.launch(CSSDemo.class, null);
    }
}