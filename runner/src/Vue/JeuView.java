package Vue;

import Modele.Piste;
import Modele.bonhomme;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class JeuView {
    private Pane gamePane = new Pane();
    private Scene laScene;
    private PisteView PisteView = new PisteView(new Piste(500,new bonhomme(new Color(0.5,0.5,0.5,0.5),100,100)));


    public Scene getGamePane() {
        Group root = new Group();
        root.getChildren().add(PisteView);

        this.laScene = new Scene(root);
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



