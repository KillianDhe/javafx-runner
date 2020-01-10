package Modele;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;
import java.util.List;

public class Partie {

    private List<ObstacleCarre> listeObstacle;
    private Personnage personnage;



    public Partie(Personnage p) {
        listeObstacle=new ArrayList<ObstacleCarre>();
        this.personnage=personnage;
    }

   public void ajouterObstacle(ObstacleCarre o)
    {
        listeObstacle.add(o);
    }

    public void GeneretEtAjouterObstacle()
    {
        ajouterObstacle(genererObstacle());
    }

    public void supprimerObstacle(ObstacleCarre o)
    {

        listeObstacle.remove(o);
    }

    public ObstacleCarre genererObstacle(){

        int  cote= (int)((Math.random()*(constantes.getLongueurObstacle()-20)+1)+constantes.getLongueurObstacle());
        int y=constantes.getHauteurPiste()-cote;
        if(listeObstacle.isEmpty())
        {
            return new ObstacleCarre(900,y,cote);
        }
        int xmin=listeObstacle.get(listeObstacle.size()-1).getPositionX()+constantes.getLargeurPersonnage()*2;
        int xmax=xmin+200;

        return new ObstacleCarre((int)(Math.random()*(xmax-xmin + 1))+xmin,y,cote);


    }





    public List<ObstacleCarre> getListeObstacle() {
        return listeObstacle;
    }

    public void setListeObstacle(List<ObstacleCarre> listeObstacle) {
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
                ", listeGroupeObstacle=" + listeObstacle +
                ", personnage=" + personnage +
                '}';
    }

    public void Rafraichir(){
        AnimationTimer gameLoop = new AnimationTimer() {

            @Override
            public void handle(long l) {


                for(ObstacleCarre obstacleCarre: listeObstacle){
                    obstacleCarre.positionXProperty().set((obstacleCarre.positionXProperty().getValue())-1);
                }


            }
        };
        gameLoop.start();
    }
}