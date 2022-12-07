import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BasicTest {

    /**
     * Example of testing 1 + 1 = 2
     */

    @Test
    public void testOnePlusOne() {
        assertTrue(1 + 1 == 2);
    }

    /**
     * Broken test
     * TODO: fix this test
     */

    @Test
    public void testTwoTimesThree() {
        assertTrue(2 * 2 == 4);
    }

    /**
     * TODO: Write a test that tests the output of 6 divided by 2
     * TODO: Follow the test method format above
     */
    @Test
    public void testSixDivTwo() {
        assertTrue(6 / 2 == 3);
    }

}