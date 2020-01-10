package Vue;


import Modele.Jeu;
import Modele.Partie;
import Modele.Personnage;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;

import java.net.URISyntaxException;

public class Menu {

    @FXML
    private Label meilleurScore;

    @FXML
    private Label dernierScore;

    public void initialize() {

        Jeu j1=new Jeu(new Partie(new Personnage()),30,122);
        meilleurScore.textProperty().bind(Bindings.convert(j1.meilleurScoreProperty()));
        dernierScore.textProperty().bind(Bindings.convert(j1.scoreProperty()));

    }

    @FXML
    void clicSurJouer(ActionEvent event) {
        System.out.println("ca marche");

        JeuView leJeu = new JeuView();
        Stage stage =new Stage();
        stage.setTitle("Jeu");
        stage.setWidth(1100);
        stage.setHeight(700);
        stage.setResizable(true);
        stage.setScene(leJeu.getGamePane());
        stage.show();

    }

    public void clicSurQuitter(ActionEvent actionEvent) {
        try {
            System.exit(0);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
