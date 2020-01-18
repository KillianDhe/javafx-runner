package Vue;

import javafx.scene.Parent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class PisteView extends Parent {

    /**
     * une ligne
     */
    private Line leSol;

    /**
     * constructeur de pisteView , instancie une ligne et l'ajoute a parent
     * @param posY
     */
    public PisteView(int posY) {
        leSol= new Line(0, posY,10000, posY);
        this.getChildren().add(leSol);
    }

    /**
     * getter de leSol
     * @return leSol
     */
    public Line getLeSol() {
        return leSol;
    }

    /**
     * setter de leSol
     * @param leSol leSol que l'on veut set
     */
    public void setLeSol(Line leSol) {
        this.leSol = leSol;
    }
}
