import javafx.application.Application;
import javafx.application.Launcher;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * JavaFXでHello, World!
 */
public class Hello extends Application {
    @Override
    public void start(Stage stage) {
        // コンテナ
        Group container = new Group();

        // シーングラフのルート要素を生成し、コンテナを貼る
        Scene scene = new Scene(container, 100, 20);
        stage.setScene(scene);

        // ラベルを生成しコンテナに貼る
        Label label = new Label("Hello, World!");
        container.getChildren().add(label);

        // 表示
        stage.setVisible(true);
    }

    public static void main(String[] args) {
        Launcher.launch(Hello.class, null);
    }
}