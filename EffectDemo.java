import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * エフェクトのデモ
 *
 * 代表的な8種類のエフェクトを表示する
 */
public class EffectDemo extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Effect Demo");

        GridPane container = new GridPane();
        container.setHgap(10);
        container.setVgap(10);
        container.setLayoutX(10);
        container.setLayoutY(10);
        
        Scene scene = new Scene(container, 340, 570);

        // オリジナル
        ImageView image = new ImageView(new Image("macarons.jpg"));
        container.add(image, 0, 0);

        Label caption = new Label("Original");
        container.add(caption, 0, 1);

        // Bloom 輝かせるエフェクト
        image = new ImageView(new Image("macarons.jpg"));
        image.setEffect(new Bloom());
        container.add(image, 1, 0);

        caption = new Label("Bloom");
        container.add(caption, 1, 1);

        // BoxBlur ぼかし
        // BoxBlurの他に、GaussianBlurもある
        image = new ImageView(new Image("macarons.jpg"));
        image.setEffect(new BoxBlur(10, 10, 2));
        container.add(image, 2, 0);

        caption = new Label("Box Blur");
        container.add(caption, 2, 1);

        // ColorAdjust 色の調整
        image = new ImageView(new Image("macarons.jpg"));
        ColorAdjust adjust = new ColorAdjust();
        adjust.setBrightness(-.2);
        adjust.setContrast(1.5);
        image.setEffect(adjust);
        container.add(image, 0, 2);

        caption = new Label("Color Adjust");
        container.add(caption, 0, 3);

        // DropShadow ドロップシャドウ
        image = new ImageView(new Image("macarons.jpg"));
        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.BLACK);
        image.setEffect(dropShadow);
        container.add(image, 1, 2);

        caption = new Label("Drop Shadow");
        container.add(caption, 1, 3);

        // InnerShadow 内側に表示するシャドウ
        image = new ImageView(new Image("macarons.jpg"));
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(5.0f);
        innerShadow.setOffsetY(5.0f);
        image.setEffect(innerShadow);
        container.add(image, 2, 2);

        caption = new Label("Inner Shadow");
        container.add(caption, 2, 3);

        // Lighting ライトのエフェクト ここではDistantLightを使用
        image = new ImageView(new Image("macarons.jpg"));
        Lighting lighting = new Lighting();
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0f);
        lighting.setLight(light);
        lighting.setSurfaceScale(5.0f);
        image.setEffect(lighting);
        container.add(image, 0, 4);

        caption = new Label("Lighting");
        container.add(caption, 0, 5);

        // Reflection 反射を行なうエフェクト
        image = new ImageView(new Image("macarons.jpg"));
        Reflection reflection = new Reflection();
        reflection.setFraction(0.2f);
        image.setEffect(reflection);
        container.add(image, 1, 4);

        caption = new Label("Reflection");
        container.add(caption, 1, 5);

        // SepiaTone セピア色にするエフェクト
        image = new ImageView(new Image("macarons.jpg"));
        image.setEffect(new SepiaTone());
        container.add(image, 2, 4);

        caption = new Label("Sepia Tone");
        container.add(caption, 2, 5);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(null);
    }
}