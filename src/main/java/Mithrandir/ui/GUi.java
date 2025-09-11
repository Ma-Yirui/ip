package Mithrandir.ui;

import java.io.IOException;

import Mithrandir.ui.MainWindow;
import Mithrandir.ui.Ui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class GUi extends Application {

    private Mithrandir.Application mithrandir;

    public GUi() {
        mithrandir = new Mithrandir.Application();
    }

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(GUi.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setMithrandir(mithrandir);
            stage.show();
            fxmlLoader.<MainWindow>getController().greet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}