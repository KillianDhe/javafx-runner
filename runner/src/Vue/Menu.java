package Vue;


import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Main;

public class Menu {

    @FXML
    private Label meilleurScore;

    @FXML
    private Label dernierScore;

    /**
     * bind les labels score et meilleureScore a ceux de Partie
     */
    public void initialize() {

        meilleurScore.textProperty().bind(Bindings.convert(Main.monJeu.getPartie().meilleurScoreProperty()));
        dernierScore.textProperty().bind(Bindings.convert(Main.monJeu.getPartie().scoreProperty()));

    }

    /**
     * set la scene de jeuView a la scene actuelle
     * appelle la methode rejouer de partie
     * @param event
     */
    @FXML
    void clicSurJouer(ActionEvent event) {
        Stage stage =(Stage)((Button)event.getSource()).getScene().getWindow();
        stage.setTitle("Runner");
        stage.setWidth(1100);
        stage.setHeight(700);
        stage.setResizable(false);
        stage.setScene(Main.leJeu.getGamePane());
        stage.show();
        Main.monJeu.rejouer();

    }

    /**
     * quitte l'application
     * @param actionEvent
     */
    public void clicSurQuitter(ActionEvent actionEvent) {
        try {
            System.exit(0);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
