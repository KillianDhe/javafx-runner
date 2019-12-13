package Modele;
import Vue.ObstacleView;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Partie {

    private int positiony;
    private List<ObstacleView> listeObstacle;
    private Personnage personnage;

    //, Personnage personnage
    //this.personnage=personnage;


    public Partie(int positiony) {
        this.positiony = positiony;
        listeObstacle=new ArrayList<ObstacleView>();
    }

   public void ajouterObstacleView(ObstacleView o)
    {
        listeObstacle.add(o);
    }/*

    public void GeneretEtAjoutergroupeObstacle()
    {
        ajouterGoupeObstacle(genererGroupeObstacle());
    }

    public void supprimerGroupeObstacle(GroupeObstacleView go)
    {

        listeGroupeObstacle.remove(go);
    }

    public GroupeObstacleView genererGroupeObstacle(){

       int nbobstacle= (int)(1+Math.random()*4);

        GroupeObstacleView go=new GroupeObstacleView(10,10);
        int taille;

        for (int i=0;i<nbobstacle;i++){
            taille= (int)((Math.random()*(constantes.getLongueurObstacle())+1)/nbobstacle);
            go.AjouterObstacle(new GroupeObstacleView(taille,new Color(0.5,0.5,0.5,0.5)));
        }

        return go;
    }


    public int getPositiony() {
        return positiony;
    }

    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }


*/

    public List<ObstacleView> getListeObstacle() {
        return listeObstacle;
    }

    public void setListeObstacle(List<ObstacleView> listeObstacle) {
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