package Vue;

import javafx.scene.Parent;
import javafx.scene.shape.Rectangle;

public class PersonnageView extends Parent {

        private Rectangle perso;
        private int PositionY;

    public PersonnageView(int posY) {
        PositionY = posY;
        perso = new Rectangle(100,posY,50,200);
        this.getChildren().add(perso);
    }

    public Rectangle getPerso() {
        return perso;
    }

    public void setPerso(Rectangle perso) {
        this.perso = perso;
    }

    public int getPositionY() {
        return PositionY;
    }
}
