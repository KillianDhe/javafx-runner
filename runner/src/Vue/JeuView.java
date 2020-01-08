package Vue;

import Modele.ObstacleCarre;
import Modele.Partie;
import Modele.Personnage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


import java.net.URISyntaxException;

public class JeuView {

    private Pane gamePane = new Pane();
    private PisteView pisteView = new PisteView(500);
    private PersonnageView persoview=new PersonnageView(new Personnage(),new Image(getClass().getResource("/image/santa.png").toString()));
    private ObstacleCarreView obstacleCarreView=new ObstacleCarreView(new ObstacleCarre(300,450,50),new Image(getClass().getResource("/image/cadeau.jpg").toString()));
    private ObstacleCarreView obstacleCarreView2=new ObstacleCarreView(new ObstacleCarre(500,450,50),new Image(getClass().getResource("/image/cadeau.jpg").toString()));
    private ObstacleCarreView obstacleCarreView3=new ObstacleCarreView(new ObstacleCarre(700,450,50),new Image(getClass().getResource("/image/cadeau.jpg").toString()));






    public Scene getGamePane() {

        Group root = new Group();
        Scene laScene = new Scene(root);
        root.getChildren().add(pisteView);
        root.getChildren().add(persoview.getRectangle());
        root.getChildren().add(obstacleCarreView.getRectangle());
        root.getChildren().add(obstacleCarreView2.getRectangle());
        root.getChildren().add(obstacleCarreView3.getRectangle());

        return laScene;

    }
}

    /*
    private int hauteurPiste;
    private Line leSol = new Line(0,hauteurPiste,1100,hauteurPiste);

    public Piste(int hauteur) {
        this.hauteurPiste=hauteur;
        laPiste.getChildren().add(leSol);
    }

    public Pane getLaPiste() {
        return laPiste;
    }

    public void setLaPiste(Pane laPiste) {
        this.laPiste = laPiste;
    }

    public Line getLeSol() {
        return leSol;
    }

    public void setLeSol(Line leSol) {
        this.leSol = leSol;
    }

    public void AjouterObstacle(Obstacle obstacle){
        this.laPiste.getChildren().add(obstacle);
    }


    private int cote;
    private Rectangle unObstacle = new Rectangle(50,25,cote,cote);

    public ObstacleCarre(int cote){
        this.setCote(cote);
    }

    public int getCote() {
        return cote;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }


*/



