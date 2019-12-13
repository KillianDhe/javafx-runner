package Vue;

import Modele.Partie;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class JeuView {
    private Pane gamePane = new Pane();
   // private ImageView mv = new ImageView(new Image("background.jpg"));
    private Scene laScene;
    private Partie laPiste = new Partie(100);


    public Scene getGamePane() {
        Group root = new Group();
        //root.getChildren().add(mv);
        PisteView pisteView = new PisteView(100);
        root.getChildren().add(pisteView);
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



