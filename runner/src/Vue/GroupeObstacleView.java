package Vue;

import Modele.constantes;
import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.List;

public class GroupeObstacleView extends Parent {

    private int positionx;
    private int positiony;
    private int largeur;

    public GroupeObstacleView(int positionx, int positiony) {
        this.setPositionx(positionx);
        this.setPositiony(positiony);
        this.largeur=0;
        ArrayList<ObstacleView> listeObstacle = new ArrayList<ObstacleView>();
    }



    public void AjouterObstacle(ObstacleView o)
    {
        if(this.getLargeur()+o.getLargeur()< constantes.getLongueurGroupeObstacle())
        {
            listeObstacle.add(o);
            this.setLargeur(this.getLargeur()+o.getLargeur());
        }

    }

    public void SupprimerObstacle(Obstacle o)
    {
        listeObstacle.remove(o);
    }


    public int getPositionx() {
        return positionx;
    }

    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }

    public int getPositiony() {
        return positiony;
    }

    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        if (largeur>constantes.getLongueurGroupeObstacle())
            this.largeur=constantes.getLongueurGroupeObstacle();
        else this.largeur = largeur;
    }

    public List<Obstacle> getListeObstacle() {
        return listeObstacle;
    }

    public void setListeObstacle(List<Obstacle> listeObstacle) {
        this.listeObstacle = listeObstacle;
    }


}
