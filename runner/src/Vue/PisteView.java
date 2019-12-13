package Vue;

import javafx.scene.Parent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class PisteView extends Parent {

    private int positiony;
    private Line leSol;

    PisteView(Integer posY) {
        positiony=posY;
        leSol= new Line(0,positiony,1100,positiony);
        this.getChildren().add(leSol);
    }

    public Line getLeSol() {
        return leSol;
    }

    public void setLeSol(Line leSol) {
        this.leSol = leSol;
    }
}
