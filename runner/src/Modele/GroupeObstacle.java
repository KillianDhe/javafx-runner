package Modele;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import java.util.List;
import java.util.ArrayList;



public class GroupeObstacle {

    private int positionx;
    private int positiony;
    private int largeur;
    private  List<Obstacle> listeObstacle;


    public GroupeObstacle(int positionx, int positiony) {
        this.setPositionx(positionx);
        this.setPositiony(positiony);
        this.largeur=0;
        listeObstacle=new ArrayList<Obstacle>();
    }

    public void AjouterObstacle(Obstacle o)
    {
        if(this.getLargeur()+o.getLargeur()<constantes.getLongueurGroupeObstacle())
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

    @Override
    public String toString() {
        return "GroupeObstacle{" +
                "positionx=" + positionx +
                ", positiony=" + positiony +
                ", largeur=" + largeur +
                ", listeObstacle=" + listeObstacle +
                '}';
    }
}
