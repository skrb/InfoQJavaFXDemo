import javafx.application.Application;
import javafx.application.Launcher;
import javafx.binding.ObjectBinding;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 低レベルバインドAPIのデモ
 *
 * 3つのスライダと四角の色をバインドする
 */
public class LowLevelBindDemo extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("LowLevelBind Demo");

        Group container = new Group();
        Scene scene = new Scene(container, 400, 200);

        Rectangle rect = new Rectangle(50, 10, 300, 70);
        rect.setStroke(Color.BLACK);
        container.getChildren().add(rect);

        Label redLabel = new Label("Red: ");
        redLabel.setPrefSize(40, 30);
        redLabel.setLayoutX(20);
        redLabel.setLayoutY(100);
        container.getChildren().add(redLabel);

        Label greenLabel = new Label("Green: ");
        greenLabel.setPrefSize(40, 30);
        greenLabel.setLayoutX(20);
        greenLabel.setLayoutY(130);
        container.getChildren().add(greenLabel);

        Label blueLabel = new Label("Blue: ");
        blueLabel.setPrefSize(40, 30);
        blueLabel.setLayoutX(20);
        blueLabel.setLayoutY(160);
        container.getChildren().add(blueLabel);

        final Slider red = new Slider(0, 254, 254);
        red.setPrefSize(300, 30);
        red.setLayoutX(50);
        red.setLayoutY(100);
        container.getChildren().add(red);

        final Slider green = new Slider(0, 254, 254);
        green.setPrefSize(300, 30);
        green.setLayoutX(50);
        green.setLayoutY(130);
        container.getChildren().add(green);

        final Slider blue = new Slider(0, 254, 254);
        blue.setPrefSize(300, 30);
        blue.setLayoutX(50);
        blue.setLayoutY(160);
        container.getChildren().add(blue);

        ObjectBinding<Color> binding = new ObjectBinding<Color>() {
            {
                // スライダの値とバインドする
                super.bind(red.valueProperty());
                super.bind(green.valueProperty());
                super.bind(blue.valueProperty());
            }

            @Override
            protected Color computeValue() {
                // スライダの値が変更されたら、
                // computeValueメソッドがコールされるので
                // Colorオブジェクトを生成して返す
                return Color.rgb((int)red.getValue(),
                                 (int)green.getValue(),
                                 (int)blue.getValue());
            }
        };
        
        // 四角の色とbindingをバインドする
        rect.fillProperty().bind(binding);

        stage.setScene(scene);
        stage.setVisible(true);
    }

    public static void main(String[] args) {
        Launcher.launch(LowLevelBindDemo.class, null);
    }
}