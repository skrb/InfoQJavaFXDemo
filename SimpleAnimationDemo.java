import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * シンプルなアニメーションのデモ
 *
 * 四角を移動させるアニメーションを行なう
 */
public class SimpleAnimationDemo extends Application {
    private Rectangle rect;
    private Timeline timeline;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Animation Demo");

        Group container = new Group();
        Scene scene = new Scene(container, 400, 100);

        rect = new Rectangle(10, 60, 50, 30);
        rect.setFill(Color.RED);
        container.getChildren().add(rect);

        timeline = new Timeline();
        timeline.getKeyFrames().addAll(
            new KeyFrame(Duration.ZERO,
                         new KeyValue(rect.translateXProperty(), 0.0)),
            new KeyFrame(new Duration(1000),
                         new KeyValue(rect.translateXProperty(), 320.0)));

        Button button = new Button("Start");
        button.setLayoutX(180);
        button.setLayoutY(10);
        container.getChildren().add(button);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timeline.playFromStart();
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(null);
    }
}