package Vue;

import Modele.*;
import javafx.beans.binding.Bindings;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JeuView {

     private Pane gamePane = new Pane();
    private PisteView pisteView = new PisteView(500);
    private PersonnageView persoview;
    private List<ObstacleCarreView> listObstacleView=new ArrayList<>();
    private Group root;
    Image giftImage = new Image(getClass().getResource("/image/cadeau.jpg").toString());
    private Label score;
    private Label scoreValue;
    private Button pause=new Button("pause (esc)"){
        public void requestFocus(){}
    };


    public JeuView() {
        persoview = new PersonnageView(Main.monJeu.getPartie().getPersonnage(),new Image(getClass().getResource("/image/santa.png").toString()));
        score=new Label("Score :");
        score.setLayoutX(200);
        score.setLayoutY(100);
        scoreValue=new Label();
        scoreValue.setLayoutX(260);
        scoreValue.setLayoutY(100);
        scoreValue.textProperty().bind(Bindings.convert(Main.monJeu.getPartie().scoreProperty()));
       pause.setOnAction((event)->clicSurPause());
    }


    public Scene getGamePane() {
        root = new Group();
        Scene laScene = new Scene(root);
        ImagePattern image=new ImagePattern(new Image(getClass().getResource("/image/background.jpg").toString()));
        laScene.setFill(image);
        root.getChildren().add(pisteView);
        root.getChildren().add(score);
        root.getChildren().add(scoreValue);
        root.getChildren().add(pause);
        root.getChildren().add(persoview);
        laScene.setOnKeyPressed(ke -> {
            KeyCode keyCode = ke.getCode();
            if (keyCode.equals(KeyCode.SPACE)) {
                Main.monJeu.getPartie().getPersonnage().sauter();
            }
            if (keyCode.equals(KeyCode.ESCAPE)) {
                clicSurPause();
            }
        });


        this.initializeListener();
        Main.monJeu.getPartie().rafraichir(persoview.getRectangle(),listObstacleView);
        checkShapeIntersection(persoview.getRectangle());


        return laScene;
    }

    private void checkShapeIntersection(Shape block) {
        boolean collisionDetected = false;
        for (ObstacleCarreView static_bloc : listObstacleView) {
            if (static_bloc.getRectangle() != block) {
                Shape intersect = Shape.intersect(block, static_bloc.getRectangle());
                if (intersect.getBoundsInLocal().getWidth() != -1) {
                    collisionDetected = true;
                }
            }
        }

        if (collisionDetected) {
            System.out.println("-----------------------------PUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU-----------------------------------------");
        }
    }


    private void clicSurPause(){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/pause.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        Stage stage =new Stage();
        stage.setScene(scene);
        stage.show();
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


   /*     void checkCollision(StackPane pane, final Rectangle rect1, Rectangle rect2){

            rect2.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
                @Override
                public void changed(ObservableValue<? extends Bounds> arg0,Bounds oldValue, Bounds newValue) {
                    if(rect1.intersects(newValue)){
                        System.out.println("Collide ============= Collide");
                    }
                }
            });*/
    }
}



