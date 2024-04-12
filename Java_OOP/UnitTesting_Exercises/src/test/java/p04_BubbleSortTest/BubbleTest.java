package p04_BubbleSortTest;


import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testBubbleSort() {
        int[] numbers = {124, 2, 4, 1, 34, 53, 3, 78, 13, 9, 0, 65, 15};

        Bubble.sort(numbers);
        int[] expectedSort = {0, 1, 2, 3, 4, 9, 13, 15, 34, 53, 65, 78, 124};

        Assert.assertArrayEquals(expectedSort, numbers);
    }
}