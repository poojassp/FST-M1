package examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class CalculatorTest {

    @Test
    public void iterablesEqual() {
        final List<String> list = Arrays.asList("orange", "mango", "banana");
        final List<String> expected = Arrays.asList("banana", "mango", "orange");
        // Sort array
        Collections.sort(list);

        // Assertion
        assertIterableEquals(expected, list); //Pass
    }
}
