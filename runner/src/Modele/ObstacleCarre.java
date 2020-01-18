package Modele;

public class ObstacleCarre extends Obstacle {

    /**
     * cote de l'obstacle carrée
     */
    private int cote;

    /**
     * vélocité de déplacement de l'obstacle
     */
    private double velocityX = 50;

    /**
     * constructeur de Obstaclecarre , remplit la largeur et la heuteur avec le cote et la position x et y
     * @param positionX position x que l'on veut attribuer au champs positionY
     * @param positionY position y que l'on veut attribuer au champs positionY
     * @param cote  le cote du carre , remplit les champs largeur et hauteur avec sa valeur
     */
    public ObstacleCarre(double positionX, int positionY, int cote) {
        super(positionX, positionY,cote,cote);
        this.cote = cote;
    }

    public int getCote() {
        return cote;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }

    /**
     * déplace l'obstacle vers la gauche , mets le booléeen isOnScreen a false si l'obstacle sort de l"écran
     * @param dt différence de temps entre la sortie et l'entrée de l'animation timer
     */
    public void move(double dt){
        positionXProperty().set(positionXProperty().getValue()-(velocityX*dt));
        if(positionXProperty().getValue() + cote <0){
            this.isOnScreen=false;
        }
    }


}