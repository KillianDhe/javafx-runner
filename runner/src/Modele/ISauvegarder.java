package Modele;

public interface ISauvegarder {

    /**
     * methode a implementer pour deserialiser une partie
     * @return la partie deserialisée
     */
    public Partie charger();

    /**
     * methode a ipmlementer pour serialiser une partie
     * @param partie la partie a serialiser
     */
    public void sauvegarder(Partie partie);

}
