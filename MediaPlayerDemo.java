import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * メディアのデモ
 *
 * ムービーを再生する
 */
public class MediaPlayerDemo extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("MediaPlayer Demo");

        Group container = new Group();
        Scene scene = new Scene(container, 400, 400, Color.BLACK);
        stage.setScene(scene);

        // ムービーの再生
        Media movieMedia = new Media("[メディアのURL]");
        MediaPlayer moviePlayer = new MediaPlayer(movieMedia);
        MediaView movieView = new MediaView(moviePlayer);

        moviePlayer.setCycleCount(MediaPlayer.INDEFINITE);
        moviePlayer.setAutoPlay(true);

        movieView.setLayoutX(40);
        movieView.setLayoutY(40);

        container.getChildren().add(movieView);

        Slider slider = new Slider(-180.0, 180.0, 0.0);
        slider.setPrefSize(300, 30);
        slider.setLayoutX(50);
        slider.setLayoutY(360);
        container.getChildren().add(slider);

        movieView.rotateProperty().bind(slider.valueProperty());

        stage.setVisible(true);

    }

    public static void main(String[] args) {
        Application.launch(MediaPlayerDemo.class, null);
    }
}