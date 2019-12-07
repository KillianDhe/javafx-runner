package Modele;

public class Jeu {
    private int score;
    private int meilleurScore;

    public Jeu(int score, int meilleurScore) {
        this.score = score;
        this.meilleurScore = meilleurScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMeilleurScore() {
        return meilleurScore;
    }

    public void setMeilleurScore(int meilleurScore) {
        this.meilleurScore = meilleurScore;
    }

}
