package sample;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class KeyController {


    private void BouttonSauter(Scene scene) {
        scene.setOnKeyPressed(ke -> {
            KeyCode keyCode = ke.getCode();
            if (keyCode.equals(KeyCode.SPACE)) {
                //appelle fonction sauter du personnage
                return;
            }
        });
    }
}
