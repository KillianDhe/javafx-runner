package Vue;

import Modele.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import sample.Main;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;

public class JeuView {

    private Pane gamePane = new Pane();
    private PisteView pisteView = new PisteView(500);
    private PersonnageView persoview;
    private List<ObstacleCarreView> listObstacleView=new ArrayList<>();
    private Group root;
    Image giftImage = new Image(getClass().getResource("/image/cadeau.jpg").toString());

    public JeuView() {
        persoview = new PersonnageView(Main.monJeu.getPartie().getPersonnage(),new Image(getClass().getResource("/image/santa.png").toString()));
    }

    public Scene getGamePane() {
        root = new Group();
        Scene laScene = new Scene(root);
        root.getChildren().add(pisteView);
        root.getChildren().add(persoview);
        laScene.setOnKeyPressed(ke -> {
            KeyCode keyCode = ke.getCode();
            if (keyCode.equals(KeyCode.SPACE)) {
                Main.monJeu.getPartie().getPersonnage().sauter();
            }
        });

        this.initializeListener();
       // this.initializeListener2();
        Main.monJeu.getPartie().Rafraichir();

        Rectangle r=new Rectangle(200,400,50,50);

        return laScene;
    }

    private void initializeListener() {
        Main.monJeu.getPartie().getListeObstacle().addListener(new ListChangeListener<Obstacle>() {
            @Override
            public void onChanged(Change<? extends Obstacle> change) {
                List<ObstacleCarreView> listObstacleViewToDelete = new ArrayList<>();
                List<ObstacleCarreView> listObstacleCarreViewToAdd= new ArrayList<>();
                while (change.next()) {
                    if (change.wasAdded()) {
                        change.getList().forEach(obstacleTmp -> {
                            ObstacleCarreView obstacleCarreView = new ObstacleCarreView((ObstacleCarre) obstacleTmp,giftImage );
                            listObstacleCarreViewToAdd.add(obstacleCarreView);
                        });
                    }
                    if(change.wasRemoved()){
                        change.getList().forEach(obstacleTmp -> {
                            ObstacleCarreView obstacleViewToRemove = listObstacleView.stream().filter(obstacleViewTmp -> {
                               return obstacleViewTmp.getObstacleCarre() == obstacleTmp;
                            }).findFirst().orElse(null);
                            listObstacleViewToDelete.add(obstacleViewToRemove);
                        });
                    }
                }
                listObstacleView.addAll(listObstacleCarreViewToAdd);
                listObstacleView.removeAll(listObstacleViewToDelete);
                root.getChildren().remove(listObstacleViewToDelete);
                root.getChildren().addAll(listObstacleCarreViewToAdd);
            }
        });
    }
}



