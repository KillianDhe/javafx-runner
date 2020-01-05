package Vue;

import Modele.Partie;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class JeuView {

    private Pane gamePane = new Pane();
    private Partie p=new Partie(100);
    private PisteView pisteView = new PisteView(500);
    private PersonnageView persoview = new PersonnageView(300);



    public Scene getGamePane() {

        Group root = new Group();
        Scene laScene = new Scene(root);
        root.getChildren().add(pisteView);
        root.getChildren().add(persoview);
        ObstacleCarreView carre=new ObstacleCarreView(50,new Color(1,0,0,1));
        root.getChildren().add(carre.getCarre());
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



