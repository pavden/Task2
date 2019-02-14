
package ua.training;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Class for unit testing of Model component
 */
public class ModelTest {

    private static Model model;

    @BeforeClass
    public static void initializeModel() {
        model = new Model();
        model.setHiddenNumberRange(0, 100);
    }

    @Test
    public void isHiddenNumberInRange() {
        int[] hiddenNumbersArray = new int[10000];
        boolean hiddenNumberOutOfRange = false;

        for (int i = 0; i < hiddenNumbersArray.length; i++) {
            model.setHiddenNumber();
            hiddenNumbersArray[i] = model.getHiddenNumber();
        }

        for (int hiddenNumber : hiddenNumbersArray) {
            if (hiddenNumber <= 0 || hiddenNumber >= 100) {
                hiddenNumberOutOfRange = true;
                break;
            }
        }

        Assert.assertFalse(hiddenNumberOutOfRange);
    }

    @Test
    public void isHiddenNumberValidatedCorrectly() {
        model.setHiddenNumber();
        Assert.assertTrue(model.isHiddenNumber(model.getHiddenNumber()));
    }
}
