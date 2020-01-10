package Vue;

import Modele.Jeu;
import Modele.ObstacleCarre;
import Modele.Partie;
import Modele.Personnage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class JeuView {

    private Pane gamePane = new Pane();
    private PisteView pisteView = new PisteView(500);
    private PersonnageView persoview = new PersonnageView(new Personnage(), new Image(getClass().getResource("/image/santa.png").toString()));


    Jeu j1=new Jeu(new Partie(new Personnage()),30,120);



    public Scene getGamePane() {


        Group root = new Group();
        Scene laScene = new Scene(root);
        root.getChildren().add(pisteView);
        root.getChildren().add(persoview);
        for (int i = 0; i < 20; i++) {
            j1.getPartie().GeneretEtAjouterObstacle();
        }

            j1.getPartie().Rafraichir();
            for(ObstacleCarre obstacleCarre: j1.getPartie().getListeObstacle()){
                ObstacleCarreView ob=new ObstacleCarreView(obstacleCarre, new Image(getClass().getResource("/image/cadeau.jpg").toString()));
                root.getChildren().add(ob.getRectangle());
            }

        return laScene;


}
}



