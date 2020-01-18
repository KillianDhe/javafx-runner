package Modele;

import Vue.ObstacleCarreView;
import javafx.collections.ObservableList;

import java.util.List;

public class GenerateurObstacle {


    /**
     * genere un obstaclecarre d'une taille aleatoire (borné) et d'une distance aléatoire avec le precedent aussi (bornée aussi)
     * @param listObstacle la liste d'obstacle de partie , pour generer en fonction du dernier obstacle
     * @return l'obstacle generé
     */
    public static Obstacle genererObstacle(List<Obstacle> listObstacle) {

        Obstacle lastObstacle = null;
        if (listObstacle != null && !listObstacle.isEmpty()) {
            lastObstacle = listObstacle.get(listObstacle.size() - 1);
        }

        int cote = (int) ((Math.random() * (Constantes.getLongueurObstacle() - 20) + 1) + Constantes.getLongueurObstacle());
        int y = Constantes.getHauteurPiste() - cote;

        Obstacle obstacle;
        if (lastObstacle == null) {
            obstacle = new ObstacleCarre(900, y, cote);
        } else {
            double xmin = lastObstacle.getPositionX() + Constantes.getLargeurPersonnage() * 6;
            double xmax = xmin + 300;
            obstacle = new ObstacleCarre(Math.random() * (xmax - xmin + 1) + xmin, y, cote);
        }

        return obstacle;

    }
}

