import javafx.application.Application;
import javafx.application.Launcher;
import javafx.async.Task;
import javafx.async.TaskEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * 非同期処理のデモ
 * 
 * イメージのロードを非同期に行なう
 */
public class AsyncDemo extends Application {
    private ImageView view;
    private Task<Image> task;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Async Demo");

        Group container = new Group();

        Scene scene = new Scene(container, 332, 500);

        view = new ImageView();
        container.getChildren().add(view);

        task = new Task<Image>() {
            @Override
            protected Image execute() {
                // バックグラウンドで行なう処理
                return new Image("http://farm6.static.flickr.com/5249/5345790221_0e0afe5c71_b.jpg", 
                                 332.0, 500.0, true, true);
            }
        };
        task.setOnDone(new EventHandler<TaskEvent>() {
            // executeメソッドが完了したらコールされる
            public void handle(TaskEvent event) {
                Image image = task.get();
                view.setImage(image);
            }
        });
        // バックグラウンド処理の開始
        task.start();


        stage.setScene(scene);
        stage.setVisible(true);
    }

    public static void main(String[] args) {
        Launcher.launch(AsyncDemo.class, null);
    }
}