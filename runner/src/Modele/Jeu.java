package Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Jeu {

    Partie partie;
    public Partie getPartie() {
        return partie;
    }

    public Jeu() {
    }


    public Jeu(Partie partie) {
            this.partie=partie;
    }

    public void setPartie(Partie partie)  {
            this.partie=partie;
    }

}
