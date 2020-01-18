package Modele;

import java.io.*;

public class SauvegardeBin implements ISauvegarder {

    /**
     * le fichier dans lequel on sauvegarde
     */
    private String fichier = "partie.ser";

    /**
     * charge une partie depuis le fichier
     * @return la partie deserialisée
     */
    @Override
    public Partie charger() {
        Partie partie = null;
        try {
            FileInputStream file = new FileInputStream(fichier);
            ObjectInputStream in = new ObjectInputStream(file);
            partie = (Partie) in.readObject();

            in.close();
            file.close();

        } catch (Exception e) {
            System.out.println("La deserialisation a foiré ");
            e.printStackTrace();
        }

        return partie;

    }


    /**
     * serialise une partie
     * @param partie la partie a serialiser
     */
    @Override
    public void sauvegarder(Partie partie) {

        try {

            FileOutputStream file = new FileOutputStream
                    (fichier);
            ObjectOutputStream out = new ObjectOutputStream
                    (file);

            out.writeObject(partie);

            out.close();
            file.close();

        } catch (Exception e) {
            System.out.println("Erreur serialisation ");
            e.printStackTrace();
        }


    }
}
