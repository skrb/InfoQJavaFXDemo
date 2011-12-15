import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * フェードのデモ
 *
 * 円がフェードイン、フェードアウトを繰り返すアニメーション
 */
public class FadeTransitionDemo extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Fade Transtion Demo");

        Group container = new Group();
        Scene scene = new Scene(container, 400, 400);

        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            Circle circle = new Circle(random.nextInt(400),
                                       random.nextInt(400),
                                       random.nextInt(100));
            circle.setFill(new Color(random.nextDouble()*0.5+0.5,
                                       random.nextDouble()*0.5+0.5,
                                     random.nextDouble()*0.5+0.5,
                                     random.nextDouble()*0.8));
            circle.setEffect(new BoxBlur(10, 10, 1));
            
            container.getChildren().add(circle);

            FadeTransition transition 
                = new FadeTransition(new Duration(random.nextInt(4000)+1000),
                                     circle);
            transition.setAutoReverse(true);
            transition.setCycleCount(FadeTransition.INDEFINITE);
            transition.setInterpolator(Interpolator.EASE_BOTH);
            transition.setFromValue(1.0);
            transition.setToValue(0.0);
            transition.play();
        }

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(null);
    }
}