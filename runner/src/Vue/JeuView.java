package Vue;

import Modele.*;
import javafx.animation.AnimationTimer;
import javafx.beans.binding.Bindings;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JeuView {

     private Pane gamePane = new Pane();
    private PisteView pisteView = new PisteView(500);
    private PersonnageView persoview;
    private List<ObstacleCarreView> listObstacleView=new ArrayList<>();
    private Group root;
    Image giftImage = new Image(getClass().getResource("/image/cadeau1.png").toString());
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
       pause.setOnAction((event)->clicSurPause(event));
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
                pause.fire();
            }
        });

        Main.monJeu.getPartie().setScore(0);
        this.initializeListener();
        this.rafraichir();

        return laScene;
    }


    private void clicSurPause(ActionEvent event){

        this.arreter();
        Main.monJeu.getPartie().getListeObstacle().clear();
        listObstacleView.clear();
        Stage stage =(Stage)((Button)event.getSource()).getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/pause.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert root != null;
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    AnimationTimer gameLoop = new AnimationTimer() {
        long old = 0;
        double dt;

        @Override
        public void handle(long l) {
            dt = (double) (l - old) / 100000000;
            Main.monJeu.getPartie().getPersonnage().refreshPosition(dt);
            for (Obstacle obstacle : Main.monJeu.getPartie().getListeObstacle()) {
                obstacle.move(dt);
            }
            for (ObstacleCarreView obstacle : listObstacleView) {
                if (obstacle.getRectangle() != persoview.getRectangle()) {
                    Shape intersect = Shape.intersect(persoview.getRectangle(), obstacle.getRectangle());
                    if (intersect.getBoundsInLocal().getWidth() != -1) {
                        perdre();
                       return;

                    }
                }
            }

            Main.monJeu.getPartie().cleanObstacleList();

            Random r = new Random();
            if (r.nextInt(100) == 50) {
                Main.monJeu.getPartie().getListeObstacle().add(GenerateurObstacle.genererObstacle(Main.monJeu.getPartie().getListeObstacle()));
            }


            old = l;
        }

    };

    private void perdre() {


        gameLoop.stop();
        Main.monJeu.getPartie().perdre();
        listObstacleView.clear();
        Alert al=new Alert(Alert.AlertType.WARNING,"T NUL");
        al.show();


        al.setOnHidden(evt -> {
            Stage stage = (Stage) pause.getScene().getWindow();
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
        });

    }

    private void  rafraichir(){
        gameLoop.start();
    }

    private void arreter()
    {
        gameLoop.stop();
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



