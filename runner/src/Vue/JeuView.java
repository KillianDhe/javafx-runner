package Vue;

import Modele.*;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import sample.Main;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;

public class JeuView {

    private Pane gamePane = new Pane();
    private PisteView pisteView = new PisteView(500);
    private PersonnageView persoview = new PersonnageView(new Personnage(), new Image(getClass().getResource("/image/santa.png").toString()));
    private List<ObstacleCarreView> listObstacleView=new ArrayList<>();
    private Group root;

    public JeuView() {
    }

    public Scene getGamePane() {
        root = new Group();
        Scene laScene = new Scene(root);
        root.getChildren().add(pisteView);
        root.getChildren().add(persoview);
        this.initializeListener();
        Main.monJeu.getPartie().Rafraichir();

        return laScene;
    }

    private void initializeListener() {
        Main.monJeu.getPartie().getListeObstacle().addListener(new ListChangeListener<Obstacle>() {
            @Override
            public void onChanged(Change<? extends Obstacle> change) {
                while (change.next()) {
                    if (change.wasAdded()) {
                        change.getList().forEach(obstacleTmp -> {
                            ObstacleCarreView obstacleCarreView = new ObstacleCarreView((ObstacleCarre) obstacleTmp, new Image(getClass().getResource("/image/cadeau.jpg").toString()));
                            listObstacleView.add(obstacleCarreView);
                            root.getChildren().add(obstacleCarreView);
                        });


                    }
                }
            }
        });

    }
}



