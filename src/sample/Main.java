package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        // Spinner doesn't working..
//        final Spinner<Integer> score1 = new Spinner<Integer>();
//        final Spinner<Integer> score2 = new Spinner<Integer>();
//        final int initialValue = 0;
//        // Value factory.
//        SpinnerValueFactory<Integer> valueFactory = //
//                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20, initialValue);
//
//        score1.setValueFactory(valueFactory);
//        score2.setValueFactory(valueFactory);




        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Big European 6");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}
