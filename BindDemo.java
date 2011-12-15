import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
    // モデル
    DoubleProperty x = new SimpleDoubleProperty(50);
            
    @Override
    public void start(Stage stage) {
        stage.setTitle("Bind Demo");

        Group container = new Group();
        Scene scene = new Scene(container, 400, 100);

        Rectangle rect = new Rectangle(50, 10, 50, 30);
        rect.setFill(Color.RED);
        container.getChildren().add(rect);
        
        // バインドにより四角のx座標をモデルxの値に同期
        rect.xProperty().bind(x);

        Slider slider = new Slider(50, 300, 0);
        slider.setPrefSize(300, 30);
        slider.setLayoutX(50);
        slider.setLayoutY(60);
        container.getChildren().add(slider);

        // バインドによりモデルxの値をスライダに同期
        x.bind(slider.valueProperty());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(null);
    }
}