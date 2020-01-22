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
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JeuView {

    /**
     * la vue piste sur laquelle tout va se passer
     */
    private PisteView pisteView = new PisteView(500);

    /**
     * la vue du personnage que l'on va controler
     */
    private PersonnageView persoview;

    /**
     * la liste contenant les obstacles qui vont s'afficher
     */
    private List<ObstacleCarreView> listObstacleView=new ArrayList<>();
    private List<ObstacleRondView> listObstacleRondView=new ArrayList<>();

    private Group root;
    /**
     * l'image d'un obstacle
     */
    Image giftImage = new Image(getClass().getResource("/image/cadeau1.png").toString());
    Image greenImage = new Image(getClass().getResource("/image/vert.png").toString());


    /**
     * le label score que l'on affiche dans la vue
     */
    private Label score;
    /**
     * la valeure du score , bindé sur score de partie
     */

    private Label scoreValue;

    /**
     * bouton pause (sans le focus avec le clavier pour ne pas louvrir en jouant)
     */
    private Button pause=new Button("pause (esc)"){
        public void requestFocus(){}
    };

    /**
     * constructeur de jeuView , instancie le personnageView ,  positionne les labels score et scoreValue , bind scoreValue sur le score de partie , définie l'ction du bouton pause
     */
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

    /**
     * On instancie et prametre une scene en diposant nos élements visuels , label , background
     * on initialise le lisner et demarre l'animation timer
     * on definit le comportement des touches (espace sauter , esc pause)
     * @return
     */
    public Scene getGamePane() {
        root = new Group();
        Scene laScene = new Scene(root);
        ImagePattern image=new ImagePattern(new Image(getClass().getResource("/fxml/background.jpg").toString()));
        laScene.setFill(image);
        root.getChildren().add(pisteView);
        root.getChildren().add(score);
        root.getChildren().add(scoreValue);
        root.getChildren().add(pause);
        root.getChildren().add(persoview);
        laScene.setOnKeyPressed(ke -> {
            KeyCode keyCode = ke.getCode();
            if (keyCode.equals(KeyCode.SPACE)) {
                Main.monJeu.sauter();
            }
            if (keyCode.equals(KeyCode.ESCAPE)) {
                pause.fire();
            }
        });


        this.initializeListener();
        this.rafraichir();
        return laScene;
    }

    /**
     *définit ce quil se passe quand on clique sur pause , on arrete l'animation timer et ouvre la fentre pause
     * @param event
     */
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

    /**
     * l'animation timer du jeu , il raffraichit la position du personnage , fait defiler les obstacles vers la gauche , les supprime , genere des obstacles u fur et a mesure
     */
    AnimationTimer gameLoop = new AnimationTimer() {
        long old = 0;
        double dt;

        @Override
        public void handle(long l) {
            dt = (double) (l - old) / 100000000;
            Main.monJeu.refreshPosition(dt);
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

            for (ObstacleRondView obstacle : listObstacleRondView) {
                    Shape intersect = Shape.intersect(persoview.getRectangle(), obstacle.getCircle());
                    if (intersect.getBoundsInLocal().getWidth() != -1) {
                        perdre();
                        return;

                    }


            }

            Main.monJeu.cleanObstacleList();

            Random r = new Random();
            if (r.nextInt(120) == 50) {
                Main.monJeu.getPartie().getListeObstacle().add(GenerateurObstacle.genererObstacle(Main.monJeu.getPartie().getListeObstacle()));
            }


            old = l;
        }

    };

    /**
     * définit ce qu'il se passe lorsqu'on perds
     * on arrete l'nimation timer
     * on appelle perdre de partie
     * on supprime la lste dobstacleview
     * on affiche un message
     * une fois fermé , on retoure au menu et sauvegarde
     */
    private void perdre() {
        gameLoop.stop();
        Main.monJeu.perdre();
        listObstacleView.clear();
        listObstacleRondView.clear();
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

        Main.monJeu.sauvegarder();
    }

    /**
     * lance l'animation timer
     */
    private void  rafraichir(){
        gameLoop.start();
    }

    /**
     * arrete l'animation timer
     */
    private void arreter()
    {
        gameLoop.stop();
    }

    /**
     * initialize le listener
     * lorsque un obstacle dans Partie est ajouté , on crée un obstacleView (qui s'ajoute a la vue)
     * lorsqu"un obstacle dans Partie est supprimé , on supprime son ObstacleView
     */
    private void initializeListener() {
        Main.monJeu.getPartie().getListeObstacle().addListener(new ListChangeListener<Obstacle>() {
            @Override
            public void onChanged(Change<? extends Obstacle> change) {
                List<ObstacleCarreView> listObstacleViewToDelete = new ArrayList<>();
                List<ObstacleCarreView> listObstacleCarreViewToAdd= new ArrayList<>();
                List<ObstacleRondView> listObstacleRondViewToDelete = new ArrayList<>();
                List<ObstacleRondView> listObstacleRondViewToAdd= new ArrayList<>();
                while (change.next()) {
                    if (change.wasAdded()) {
                        change.getList().forEach(obstacleTmp -> {
                            if (obstacleTmp instanceof ObstacleCarre)
                            {
                                ObstacleCarreView obstacleCarreView = new ObstacleCarreView((ObstacleCarre) obstacleTmp, giftImage);
                            listObstacleCarreViewToAdd.add(obstacleCarreView);
                        }
                            else
                            {
                                ObstacleRondView obstacleRondView = new ObstacleRondView((ObstacleRond) obstacleTmp, greenImage);
                                listObstacleRondViewToAdd.add(obstacleRondView);
                            }
                        });
                    }
                    if(change.wasRemoved()){
                        change.getList().forEach(obstacleTmp -> {
                            if (obstacleTmp instanceof ObstacleCarre) {
                                ObstacleCarreView obstacleViewToRemove = listObstacleView.stream().filter(obstacleViewTmp -> {
                                    return obstacleViewTmp.getObstacleCarre() == obstacleTmp;
                                }).findFirst().orElse(null);
                                listObstacleViewToDelete.add(obstacleViewToRemove);
                            }
                            else{
                                ObstacleRondView obstacleRondViewToRemove = listObstacleRondView.stream().filter(obstacleViewTmp -> {
                                    return obstacleViewTmp.getObstacleRond() == obstacleTmp;
                                }).findFirst().orElse(null);
                                listObstacleRondViewToDelete.add(obstacleRondViewToRemove);
                            }

                        });
                    }
                }
                listObstacleRondView.addAll(listObstacleRondViewToAdd);
                listObstacleRondView.removeAll(listObstacleRondViewToDelete);
                listObstacleView.addAll(listObstacleCarreViewToAdd);
                listObstacleView.removeAll(listObstacleViewToDelete);
                root.getChildren().remove(listObstacleViewToDelete);
                root.getChildren().addAll(listObstacleCarreViewToAdd);
                root.getChildren().remove(listObstacleRondViewToDelete);
                root.getChildren().addAll(listObstacleRondViewToAdd);

            }
        });

    }




}



