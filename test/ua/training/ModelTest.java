
package ua.training;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Class for unit testing of Model component
 */
public class ModelTest {

    private Model model;

    @Before
    public void initializeModel() {
        model = new Model();
        model.setHiddenNumberRange(Model.INITIAL_RANGE_MIN, Model.INITIAL_RANGE_MAX);
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
            if (hiddenNumber <= Model.INITIAL_RANGE_MIN || hiddenNumber >= Model.INITIAL_RANGE_MAX) {
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
