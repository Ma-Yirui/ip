package Mithrandir.ui;

import java.util.Objects;

import Mithrandir.Mithrandir;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Ui mithrandir;

    private Image userImage = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/Frodo" +
            ".png")));
    private Image mithrandirImage = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/Gandalf.png")));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    @FXML
    public void handleUserInput() {
        String input = userInput.getText();
        String response = "Dummy Response";
        dialogContainer.getChildren().add(DialogBox.getUserDialog(input, userImage));
        dialogContainer.getChildren().add(DialogBox.getMithrandirDialog(response, mithrandirImage));
        userInput.clear();
    }

    public void setMithrandir(Ui mithrandir) {
        this.mithrandir = mithrandir;
    }
}
