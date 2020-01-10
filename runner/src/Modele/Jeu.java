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

    private final IntegerProperty score = new SimpleIntegerProperty();
        public Integer getScore() {return score.get();}
        public IntegerProperty scoreProperty() {return score;}
        public void setScore(Integer score) {this.score.set(score);}

    private final IntegerProperty meilleurScore = new SimpleIntegerProperty();
        public Integer getMeilleurScore() {return meilleurScore.get();}
        public IntegerProperty meilleurScoreProperty() {return meilleurScore;}
        public void setMeilleurScore(Integer meilleurScore) {this.meilleurScore.set(meilleurScore);}

    public Jeu(Partie partie,int score , int meilleurScore) {
            this.score.set(score);
            this.meilleurScore.set(meilleurScore);
            this.partie=partie;
    }

    public void setPartie(Partie partie)  {
            this.partie=partie;
    }

}
