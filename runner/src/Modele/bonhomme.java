package Modele;

import javafx.scene.paint.Color;

public class bonhomme {
    private Color couleur;

    public bonhomme(Color couleur) {
        this.couleur = couleur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
