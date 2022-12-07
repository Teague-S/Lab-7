import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AlienArrayCreator2DTest {

    @Test
    public void testCheckEvilRow() {
        // Instantiating necessary values
        Pane pane = new Pane();
        AlienArrayCreator2D creator2D = new AlienArrayCreator2D(pane);
        // Creating a row of 10 aliens
        Alien[] row = new Alien[10];
        for (int i = 0; i < row.length; i++) {
            Alien alien = new Alien(Color.LIGHTGREEN);
            alien.setIsEvil(false);
            row[i] = alien;
        }
        System.out.println(creator2D.checkEvilAliens(row));
        row[0].setIsEvil(true);
        row[1].setIsEvil(true);
        System.out.println(creator2D.checkEvilAliens(row));
        row[2].setIsEvil(true);
        System.out.println(creator2D.checkEvilAliens(row));
        row[3].setIsEvil(true);
        System.out.println(creator2D.checkEvilAliens(row));

        /*
         * TODO:
         * 1. Populate the row array by creating 10 aliens (for-loop)
         * 2. Use the Alien's setIsEvil method to set them all to be false
         * 3. How many Aliens do you need to set as evil to test the checkEvilAliens
         * method using row
         */
    }
}