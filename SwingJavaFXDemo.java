import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * SwingとJavaFXの連携デモ
 *
 * SwingにJavaFXのシーングラフを貼る
 */
public class SwingJavaFXDemo extends Application {
    // シーングラフを貼るSwingコンポーネント
    private JFXPanel jfxPanel;

    // initSwingメソッドはSwingのスレッドで処理する
    public void initSwing() {
        JFrame frame = new JFrame("Swing-JavaFX Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 120);
        frame.setLayout(new GridLayout(2, 0));

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(280, 60));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel("Swing: Label");
        JTextField textField = new JTextField("Text Box");
        JButton button = new JButton("Button");
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        frame.add(panel);

        // シーングラフを貼るコンポーネントを生成
        jfxPanel = new JFXPanel();
        jfxPanel.setPreferredSize(new Dimension(280, 60));
        frame.add(jfxPanel);

        frame.setVisible(true);
    }

    // startメソッドはJavaFXのスレッドで処理する
    @Override
    public void start(Stage stage) {
        try {
            // Swingのスレッドで処理する
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    initSwing();
                }
            });
        } catch (InvocationTargetException ex) {
            return;
        } catch (InterruptedException ex) {
            return;
        }

        FlowPane container = new FlowPane(10, 10);
        container.setAlignment(Pos.CENTER);
        Scene scene = new Scene(container);

        Label label = new Label("JavaFX: Label");
        TextField textField = new TextField("Text Box");
        Button button = new Button("Button");
        container.getChildren().addAll(label, textField, button);

        // Swingにシーングラフを貼る
        jfxPanel.setScene(scene);
    }

    public static void main(String[] args) {
        // JavaFXのスレッドを起動
        Application.launch(null);
    }
}