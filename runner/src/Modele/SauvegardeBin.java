package Modele;

import java.io.*;

public class SauvegardeBin implements ISauvegarder {

    private String fichier = "partie.ser";

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
