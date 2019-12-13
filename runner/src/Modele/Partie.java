package Modele;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Partie {

    private int positiony;
    private List<GroupeObstacle> listeGroupeObstacle;
    private Personnage personnage;

    //, Personnage personnage
    //this.personnage=personnage;


    public Partie(int positiony) {
        this.positiony = positiony;
        listeGroupeObstacle=new ArrayList<GroupeObstacle>();
    }

    public void ajouterGoupeObstacle(GroupeObstacle go)
    {
        listeGroupeObstacle.add(go);
    }

    public void GeneretEtAjoutergroupeObstacle()
    {
        ajouterGoupeObstacle(genererGroupeObstacle());
    }

    public void supprimerGroupeObstacle(GroupeObstacle go)
    {

        listeGroupeObstacle.remove(go);
    }

    public GroupeObstacle genererGroupeObstacle(){

       int nbobstacle= (int)(1+Math.random()*4);

        GroupeObstacle go=new GroupeObstacle(10,10);
        int taille;

        for (int i=0;i<nbobstacle;i++){
            taille= (int)((Math.random()*(constantes.getLongueurObstacle())+1)/nbobstacle);
            go.AjouterObstacle(new ObstacleCarre(taille,new Color(0.5,0.5,0.5,0.5)));
        }

        return go;
    }


    public int getPositiony() {
        return positiony;
    }

    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }



    public List<GroupeObstacle> getListeGroupeObstacle() {
        return listeGroupeObstacle;
    }

    public void setListeGroupeObstacle(List<GroupeObstacle> listeGroupeObstacle) {
        this.listeGroupeObstacle = listeGroupeObstacle;
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
                ", listeGroupeObstacle=" + listeGroupeObstacle +
                ", personnage=" + personnage +
                '}';
    }
}
*/