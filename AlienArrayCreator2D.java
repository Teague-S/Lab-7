import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AlienArrayCreator2D {

    private Pane alienPane;
    private Alien[][] alienArray2D; // here's the declaration of the array variable!

    public AlienArrayCreator2D(Pane alienPane) {
        this.alienPane = alienPane;
        alienArray2D = new Alien[7][5];
    }

    public void generateAliens() {
        this.reset(); // don't worry about this! it's just to make sure you don't double generate
        for (int i = 0; i < alienArray2D.length; i++) {
            for (int j = 0; j < alienArray2D[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    Alien alien = new Alien(Color.BLUE);
                    alienArray2D[i][j] = alien;
                    alienArray2D[i][j].addToPane(this.alienPane);
                } else {
                    Alien alien = new Alien(Color.GREEN);
                    alienArray2D[i][j] = alien;
                    alienArray2D[i][j].addToPane(this.alienPane);
                }
            }
        }
    }

    public void lineUpAliens() {
        for (int i = 0; i < alienArray2D.length; i++) {
            for (int j = 0; j < alienArray2D[i].length; j++) {
                if (alienArray2D[i][j] != null && i % 2 == 0) {
                    alienArray2D[i][j].setColor(Color.LIGHTGREEN);
                    alienArray2D[i][j].setXPos((j * (Constants.PANEL_W / 5)) + 30);
                    alienArray2D[i][j].setYPos((i * (Constants.PANEL_H / 7)) + 30);
                } else {
                    if (alienArray2D[i][j] != null) {
                        alienArray2D[i][j].setColor(Color.SKYBLUE);
                        alienArray2D[i][j].setXPos((j * (Constants.PANEL_W / 5)) + 30);
                        alienArray2D[i][j].setYPos((i * (Constants.PANEL_H / 7)) + 30);
                    }
                }
            }
        }
    }

    public void rowToCol() {
        for (int i = 0; i < alienArray2D[i].length; i++) {
            for (int j = 0; j < alienArray2D.length; j++) {
                if (alienArray2D[j][i] != null && i % 2 == 0) {
                    alienArray2D[j][i].setColor(Color.SKYBLUE);
                    alienArray2D[j][i].setXPos((i * (Constants.PANEL_W / 5)) + 30);
                    alienArray2D[j][i].setYPos((j * (Constants.PANEL_H / 7)) + 30);
                } else {
                    if (alienArray2D[j][i] != null) {
                        alienArray2D[j][i].setColor(Color.LIGHTGREEN);
                        alienArray2D[j][i].setXPos((i * (Constants.PANEL_W / 5)) + 30);
                        alienArray2D[j][i].setYPos((j * (Constants.PANEL_H / 7)) + 30);
                    }
                }
            }
        }
    }

    public boolean checkEvilAliens(Alien[] aliens) {
        int evilNum = 0;
        for (int i = 0; i < aliens.length; i++) {
            if (aliens[i].getIsEvil() == true) {
                evilNum++;
            }
        }
        if (evilNum >= 3) {
            return true;
        }
        return false;
    }

    public void revealEvil() {
        // checks if row major
        if (alienArray2D[0][0].getColor() == alienArray2D[0][1].getColor()) {
            for (int i = 0; i < alienArray2D.length; i++) {
                if (checkEvilAliens(alienArray2D[i])) {
                    for (int j = 0; j < alienArray2D[i].length; j++) {
                        alienArray2D[i][j].setColor(Color.RED);
                    }
                }
            }
        } else {
            for (int i = 0; i < alienArray2D[i].length; i++) {
                Alien[] temp = new Alien[7];
                for (int j = 0; j < alienArray2D.length; j++) {
                    temp[j] = alienArray2D[j][i];
                }
                if (checkEvilAliens(temp)) {
                    for (int j = 0; j < temp.length; j++) {
                        temp[j].setColor(Color.RED);
                    }
                }
            }
        }
    }

    /**
     * These are helper methods that we call in your code. Feel free to read through
     * them but please
     * don't change anything!
     **/

    public void reset() {
        this.alienArray2D = new Alien[7][5];
        this.alienPane.getChildren().clear();
    }
}