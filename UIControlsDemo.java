import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class UIControlsDemo extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("UIControls Demo");

        VBox vbox = new VBox(10);
        vbox.setLayoutY(10);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BASELINE_CENTER);
        
        // ラベル
        Label label = new Label("Label");
        hbox.getChildren().add(label);

        // チェックボックス
        CheckBox checkBox = new CheckBox("CheckBox");
        hbox.getChildren().add(checkBox);

        // ラジオボタン
        RadioButton radioButton = new RadioButton("RadioButton");
        hbox.getChildren().add(radioButton);
        
        // テキストボックス
        TextBox textBox = new TextBox("TextBox");
        hbox.getChildren().add(textBox);
        
        // ボタン
        Button button = new Button("Button");
        hbox.getChildren().add(button);
        
        vbox.getChildren().add(hbox);

        hbox = new HBox(10);
        hbox.setAlignment(Pos.BASELINE_CENTER);

        // リスト
        ListView<String> listView = new ListView<String>();
        ObservableList<String> list
            = FXCollections.observableArrayList("ListView 1", 
                                                "ListView 2", 
                                                "ListView 3");
        listView.setItems(list);
        listView.setPrefHeight(80);
        hbox.getChildren().add(listView);

        // コンボボックス
        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        list = FXCollections.observableArrayList("ChoiceBox 1", 
                                                 "ChoiceBox 2", 
                                                 "ChoiceBox 3");
        choiceBox.setItems(list);
        hbox.getChildren().add(choiceBox);
        
        vbox.getChildren().add(hbox);

        hbox = new HBox(10);
        hbox.setAlignment(Pos.BASELINE_CENTER);
        
        // プログレスバー
        label = new Label("ProgressBar");
        hbox.getChildren().add(label);
        ProgressBar progressBar = new ProgressBar(0.8);
        hbox.getChildren().add(progressBar);

        // スライダー
        label = new Label("Slider");
        hbox.getChildren().add(label);
        Slider slider = new Slider(0, 1, 0.5);
        hbox.getChildren().add(slider);

        vbox.getChildren().add(hbox);

        // バーグラフ
        String[] items = {"item1", "item2", "item3"};
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(items));
        NumberAxis yAxis = new NumberAxis(0.0, 200.0, 50.0);
        @SuppressWarnings("unchecked")
        ObservableList<BarChart.Series<String, Number>> barChartData
            = FXCollections.observableArrayList(
            new BarChart.Series<String, Number>(FXCollections.observableArrayList(
               new BarChart.Data<String, Number>(items[0], 60.0),
               new BarChart.Data<String, Number>(items[1], 80.0),
               new BarChart.Data<String, Number>(items[2], 120.0)
            )),
            new BarChart.Series<String, Number>(FXCollections.observableArrayList(
               new BarChart.Data<String, Number>(items[0], 10.0),
               new BarChart.Data<String, Number>(items[1], 160.0),
               new BarChart.Data<String, Number>(items[2], 50.0)
            )),
            new BarChart.Series<String, Number>(FXCollections.observableArrayList(
               new BarChart.Data<String, Number>(items[0], 120.0),
               new BarChart.Data<String, Number>(items[1], 90.0),
               new BarChart.Data<String, Number>(items[2], 80.0)
            ))
        );
        BarChart<String, Number> chart 
            = new BarChart<String, Number>(xAxis, yAxis, barChartData);
        chart.setPrefSize(400, 300);
        
        vbox.getChildren().add(chart);

        stage.setVisible(true);
    }

    public static void main(String[] args) {
        Application.launch(UIControlsDemo.class, null);
    }
}