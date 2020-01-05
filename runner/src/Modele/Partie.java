package Modele;
import Vue.ObstacleView;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class    Partie {

    private int positiony;
    private List<Obstacle> listeObstacle;
    private Personnage personnage;

    //, Personnage personnage
    //this.personnage=personnage;


    public Partie(int positiony) {
        this.positiony = positiony;
        listeObstacle=new ArrayList<Obstacle>();
    }

   public void ajouterObstacle(Obstacle o)
    {
        listeObstacle.add(o);
    }

    public void GeneretEtAjouterObstacle()
    {
        ajouterObstacle(genererObstacle());
    }

    public void supprimerObstacle(Obstacle o)
    {

        listeObstacle.remove(o);
    }

    public Obstacle genererObstacle(){

        int  cote= (int)((Math.random()*(constantes.getLongueurObstacle())+1));
        int y=constantes.getHauteurPiste()-cote;
        if(listeObstacle.isEmpty())
        {
            return new ObstacleCarre(900,y,cote);
        }
        int xmin=listeObstacle.get(listeObstacle.size()-1).getPositionX()+constantes.getLargeurPersonnage()*2;
        int xmax=xmin+200;

        return new ObstacleCarre((int)(Math.random()*(xmax-xmin + 1))+xmin,y,cote);


    }


    public int getPositiony() {
        return positiony;
    }

    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }


    public List<Obstacle> getListeObstacle() {
        return listeObstacle;
    }

    public void setListeObstacle(List<Obstacle> listeObstacle) {
        this.listeObstacle = listeObstacle;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    @Override
    public String toString() {
        return "Piste{" +
                "positiony=" + positiony +
                ", listeGroupeObstacle=" + listeObstacle +
                ", personnage=" + personnage +
                '}';
    }
}