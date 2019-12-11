package Vue;

import Modele.Piste;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.shape.Line;

public class PisteView extends Parent {
    private int hauteurPiste;
    private Line leSol = new Line(0,hauteurPiste,1100,hauteurPiste);


    public PisteView(Piste piste){
        this.hauteurPiste = piste.getPositiony();
        Line line = new Line(0,piste.getPositiony(),1100,piste.getPositiony());
        this.getChildren().add(line);
    }

    public Line getlaPiste() {
        return leSol;
    }

    public void set(Line leSol) {
        this.leSol = leSol;
    }

    @Override
    public Node getStyleableNode() {
        return null;
    }
}

