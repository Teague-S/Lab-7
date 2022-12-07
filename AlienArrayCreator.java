import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AlienArrayCreator {

    private Alien[] alienArray; // we're declaring the array variable here!
    private Pane alienPane;

    public AlienArrayCreator(Pane alienPane) {
        this.alienPane = alienPane;
        this.alienArray = new Alien[10];
    }

    public void generateAliens() {
        this.reset(); // don't worry about this! it's just to make sure you don't double generate
        for (int i = 0; i < alienArray.length; i++) {
            Alien alien = new Alien(Color.GREEN);
            alienArray[i] = alien;
            alien.addToPane(this.alienPane);
        }
    }

    public void alternateAlienColors() {
        for (int i = 0; i < alienArray.length; i++) {
            if (alienArray[i] != null && i % 2 == 1) {
                alienArray[i].setColor(Color.SKYBLUE);
            } else {
                if (alienArray[i] != null) {
                    alienArray[i].setColor(Color.GREEN);
                }
            }
        }
    }

    public void lineUpAliens() {
        for (int i = 0; i < alienArray.length; i++) {
            if (alienArray[i] != null) {
                alienArray[i].setYPos(250);
                alienArray[i].setXPos(i * (Constants.PANEL_W / 10) + 30);
            }
        }
    }

    public void removeBlue() {
        for (int i = 0; i < alienArray.length; i++) {
            if (alienArray[i] != null && alienArray[i].getColor() == Color.SKYBLUE) {
                alienArray[i].removeFromPane(alienPane);
                alienArray[i] = null;

            }
        }
    }

    /**
     * This is a helper method that we call in your code. Feel free to read through
     * it but please
     * don't change anything!
     **/
    public void reset() {
        this.alienArray = new Alien[10];
        this.alienPane.getChildren().clear();
    }

}