package Modele;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    Partie partie;
    private ISauvegarder persistance;

    public Manager(ISauvegarder persistance) {
        this.persistance = persistance;
    }

    public void sauvegarder(){
        persistance.sauvegarder(partie);
    }

    public void charger(){
       partie = persistance.charger();
    }



    public void sauter(){
        partie.getPersonnage().sauter();
    }


    public void refreshPosition(double dt) {

        partie.getPersonnage().refreshPosition(dt);
    }

    public void cleanObstacleList() {
        partie.cleanObstacleList();
    }

    public void perdre()
    {
      partie.perdre();
    }

    public void rejouer()
    {
        partie.rejouer();
    }

    public Partie getPartie() {
        return partie;
    }
}
