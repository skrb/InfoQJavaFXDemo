import javafx.application.Application;
import javafx.application.Launcher;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * バインドのデモ
 *
 * 四角の位置とスライダーの値をバインドする
 */
public class BindDemo extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Bind Demo");

        Group container = new Group();
        Scene scene = new Scene(container, 400, 100);

        Rectangle rect = new Rectangle(50, 10, 50, 30);
        rect.setFill(Color.RED);
        container.getChildren().add(rect);

        Slider slider = new Slider(50, 300, 0);
        slider.setPrefSize(300, 30);
        slider.setLayoutX(50);
        slider.setLayoutY(60);
        container.getChildren().add(slider);

        rect.xProperty().bind(slider.valueProperty());

        stage.setScene(scene);
        stage.setVisible(true);
    }

    public static void main(String[] args) {
        Launcher.launch(BindDemo.class, null);
    }
}