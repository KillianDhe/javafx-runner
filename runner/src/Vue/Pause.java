package Vue;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;

public class Pause {


    @FXML
    private Label meilleurScore;
    @FXML
    private Label score;

    /**
     * bind les labels score et meilleureScore a ceux de Partie
     */
    public void initialize() {

        meilleurScore.textProperty().bind(Bindings.convert(Main.monJeu.getPartie().meilleurScoreProperty()));
        score.textProperty().bind(Bindings.convert(Main.monJeu.getPartie().scoreProperty()));

    }

    /**
     * définit ce q'uil se passe a l'appui du bouton reprendre
     * set la scene de JeuView a la scene actuelle
     * @param actionEvent
     */
    @FXML
    public void clicSurReprendre(ActionEvent actionEvent) {
        Stage stage =(Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(Main.leJeu.getGamePane());
    }

    /**
     * définit ce q'uil se passe a l'appui du bouton reprendre
     * sauvegarde et retourne au menu
     * @param actionEvent l'evenement lors du clique sur le bouton
     */
    @FXML
    public void clicSurQuitter(ActionEvent actionEvent) {
        Stage stage =(Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert root != null;
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        Main.monJeu.sauvegarder();
    }

}
