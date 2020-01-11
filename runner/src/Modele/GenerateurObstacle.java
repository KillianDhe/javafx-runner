package Modele;

import Vue.ObstacleCarreView;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.List;

public class GenerateurObstacle {

    private ObservableList<ObstacleCarreView> listeecarreView;


    public static Obstacle genererObstacle(List<Obstacle> listObstacle){

        Obstacle lastObstacle =null;
        if (listObstacle != null && !listObstacle.isEmpty()) {
            lastObstacle = listObstacle.get(listObstacle.size()-1);
        }

        int cote= (int)((Math.random()*(constantes.getLongueurObstacle()-20)+1)+constantes.getLongueurObstacle());
        int y=constantes.getHauteurPiste()-cote;

        Obstacle obstacle;
        if (lastObstacle == null) {
            obstacle = new ObstacleCarre(900,y,cote);
        }else {
            double xmin=lastObstacle.getPositionX()+constantes.getLargeurPersonnage()*6;
            double xmax=xmin+300;
            obstacle = new ObstacleCarre(Math.random()*(xmax-xmin + 1)+xmin,y,cote);
        }

        return obstacle;

/*        if(listeecarreView.isEmpty())
        {
            listeecarreView.add( new ObstacleCarreView(new ObstacleCarre(900,y,cote),new Image(getClass().getResource("/image/cadeau.jpg").toString())));
        }
        int xmin=listeecarreView.get(listeecarreView.size()-1).getPositionX()+constantes.getLargeurPersonnage()*2;
        int xmax=xmin+200;

        listeecarreView.add(new ObstacleCarreView(new ObstacleCarre((int)(Math.random()*(xmax-xmin + 1))+xmin,y,cote),new Image(getClass().getResource("/image/cadeau.jpg").toString())));*/
    }


  /*  public void genererObstacle(){

        int  cote= (int)((Math.random()*(constantes.getLongueurObstacle()-20)+1)+constantes.getLongueurObstacle());
        int y=constantes.getHauteurPiste()-cote;
        if(listeecarre.isEmpty())
        {
            listeecarre.add( new ObstacleCarre(900,y,cote));
        }
        int xmin=listeecarre.get(listeecarre.size()-1).getPositionX()+constantes.getLargeurPersonnage()*2;
        int xmax=xmin+200;

        listeecarre.add(new ObstacleCarre((int)(Math.random()*(xmax-xmin + 1))+xmin,y,cote));


    }*/

}

