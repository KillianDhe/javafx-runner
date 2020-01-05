package Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Jeu {

    private final StringProperty score = new SimpleStringProperty();
        public String getScore() {return score.get();}
        public StringProperty scoreProperty() {return score;}
        public void setScore(String score) {this.score.set(score);}

    private final StringProperty meilleurScore = new SimpleStringProperty();
        public String getMeilleurScore() {return meilleurScore.get();}
        public StringProperty meilleurScoreProperty() {return score;}
        public void setMeilleurScore(String meilleurScore) {this.meilleurScore.set(meilleurScore);}

    public Jeu(String score , String meilleurScore) {
            this.score.set(score);
            this.meilleurScore.set(meilleurScore);

    }
}
