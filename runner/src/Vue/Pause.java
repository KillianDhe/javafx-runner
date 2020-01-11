package Vue;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Main;

public class Pause {

@FXML
private Button quitterButton;


    public Pause() {
       //Main.monJeu.getPartie().arreterRafraichir();
    }

    @FXML
    public void clicSurReprendre(ActionEvent actionEvent) {
        //Main.monJeu.getPartie().rafraichir();
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void clicSurQuitter(ActionEvent actionEvent) {
        System.exit(0);
    }
}
