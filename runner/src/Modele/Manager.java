package Modele;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    /**
     * la partie
     */
    Partie partie;

    /**
     * la persistance que l'on veut utiliser pour sauvegarder/charger
     */
    private ISauvegarder persistance;

    /**
     * constructeur de manager , remplit le champs persistance avec la persistance passée en paramètre
     * @param persistance la persistance que l'on veut utiliser
     */
    public Manager(ISauvegarder persistance) {
        this.persistance = persistance;
    }

    /**
     * sauvegarde la partie en appelant la methode sauvegarder de la persistance
     */
    public void sauvegarder(){
        persistance.sauvegarder(partie);
    }

    /**
     * charge la partie en appelant la méthode charger de la persistance
     */
    public void charger(){
       partie = persistance.charger();
    }

    /**
     * appelle la methode sauter dans partie
     */
    public void sauter(){
        partie.getPersonnage().sauter();
    }

    /**
     * appelle la methode refreshposition du personnage de la classe Partie
     * @param dt différence de temps entre l'entrée et la sortie de l'animation timer
     */
    public void refreshPosition(double dt) {

        partie.getPersonnage().refreshPosition(dt);
    }

    /**
     * apelle la methode cleanObstacleList de la classe Partie
     */
    public void cleanObstacleList() {
        partie.cleanObstacleList();
    }

    /**
     * appelle la methode perdre de la classe partie
     */
    public void perdre()
    {
      partie.perdre();
    }

    /**
     * appelle la methode rejouer de la classe partie
     */
    public void rejouer()
    {
        partie.rejouer();
    }

    /**
     * getter de partie
     * @return la partie
     */
    public Partie getPartie() {
        return partie;
    }
}
