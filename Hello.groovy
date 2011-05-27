import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * GroovyからJavaFXを利用するデモ
 */
class Hello extends Application {
      void start(Stage stage) {
        def scene = new Scene(
            new Group(
                new Label(
                    text: "Hello, World!",
                    font: new Font(20),
                )
            ), 100, 30);

        stage.scene = scene;
        stage.visible = true;
    }

    static main(args) {
        Application.launch(Hello.class, null);
    }
}
