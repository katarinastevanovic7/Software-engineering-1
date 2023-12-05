package exercise07;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class StringArrayListTest {

    @Test
    public void emptyListHasSizeZero() {
        // GIVEN: nothing

        // WHEN: Empty list is created
        ISimpleStringList list = new StringArrayList();

        // THEN: List has size 0
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void emptyListHasEmptyToCommaSeparatedString() {
        // GIVEN: nothing

        // WHEN: Empty list ist created
        ISimpleStringList list = new StringArrayList();

        // THEN: toCommaSeparatedString() is the empty String
        Assert.assertEquals("", list.toCommaSeparatedString());
    }

    @Test
    public void addingOneElementIncreasesSize() {
        // GIVEN: empty list is created
        ISimpleStringList list = new StringArrayList();

        // WHEN: Element "Hello" is added
        list.add(0, "Hello");

        // THEN: List has size one
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void oneAddedElementCanBeRetrievedWithGet() {
        // GIVEN: empty list is created
        ISimpleStringList list = new StringArrayList();

        // WHEN: Element "Hello" is added
        list.add(0, "Hello");

        // THEN: "Hello" is in the list
        Assert.assertEquals("Hello", list.get(0));
    }

    @Test
    public void oneAddedElementAppearsInCommaSeparatedString() {
        // GIVEN: empty list is created
        ISimpleStringList list = new StringArrayList();

        // WHEN: Element "Hello" is added
        list.add(0, "Hello");

        // THEN: "Hello" is in the comma separated string
        Assert.assertEquals("Hello", list.toCommaSeparatedString());
    }

    @Test
    public void threeElementsIncreaseSize() {
        // GIVEN: empty list is created
        ISimpleStringList list = new StringArrayList();

        // WHEN: three elements are added
        list.add(0, "Hello");
        list.add(1, "World");
        list.add(2, "!");

        // THEN: List has size 3
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void threeAddedElementsCanBeRetrievedWithGet() {
        // GIVEN: empty list is created
        ISimpleStringList list = new StringArrayList();

        // WHEN: three elements are added
        list.add(0, "Hello");
        list.add(1, "World");
        list.add(2, "!");

        // THEN: The elements are in the list at the correct positions
        Assert.assertEquals("Hello", list.get(0));
        Assert.assertEquals("World", list.get(1));
        Assert.assertEquals("!", list.get(2));
    }

    @Test
    public void threeElementsAppearInCommaSeparatedString() {
        // GIVEN: empty list is created
        ISimpleStringList list = new StringArrayList();

        // WHEN: three elements are added
        list.add(0, "Hello");
        list.add(1, "World");
        list.add(2, "!");

        // THEN: elements appear in comma separated string
        Assert.assertEquals("Hello,World,!", list.toCommaSeparatedString());
    }

    @Test
    public void nullElementCanBeAdded() {
        StringArrayList list = new StringArrayList();
        list.add(0, "Hello");
        list.add(1, null);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals("Hello,null", list.toCommaSeparatedString());
    }

    @Test
    public void elementsCanBeInsertedAndLaterElementsAreShifted() {
        // GIVEN: list with three elements is created
        StringArrayList list = new StringArrayList();
        list.add(0, "elem1");
        list.add(1, "elem2");
        list.add(2, "elem3");

        // WHEN: element is added before elem2
        list.add(1, "elem1a");

        // THEN: List has size 4 and elements are in correct position
        Assert.assertEquals(4, list.size());
        Assert.assertEquals("elem1,elem1a,elem2,elem3", list.toCommaSeparatedString());
        Assert.assertEquals("elem1", list.get(0));
        Assert.assertEquals("elem1a", list.get(1));
        Assert.assertEquals("elem2", list.get(2));
        Assert.assertEquals("elem3", list.get(3));
    }

    @Test
    public void hundredElementsCanBeAdded() {
        StringArrayList list = new StringArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i, String.valueOf(i));
        }
        Assert.assertEquals(100, list.size());
        Assert.assertTrue(list.toCommaSeparatedString().startsWith("0,1,2,3,4,5,6,"));
        Assert.assertTrue(list.toCommaSeparatedString().endsWith(",95,96,97,98,99"));
    }

    @Test(expected = NoSuchElementException.class)
    public void getPosThrowsNoSuchElementExceptionOnWrongPosParameterEmtpyList() {
        StringArrayList list = new StringArrayList();
        list.get(0);
    }

    @Test
    public void getWorksWithThreeElementList() {
        StringArrayList list = new StringArrayList();
        list.add(0, "Hello");
        list.add(1, "World");
        list.add(2, "!");

        Assert.assertEquals("Hello", list.get(0));
        Assert.assertEquals("World", list.get(1));
        Assert.assertEquals("!", list.get(2));
    }

    @Test
    public void getPosThrowsNoSuchElementExceptionOnWrongPosParameter() {
        StringArrayList list = new StringArrayList();
        list.add(0, "Hello");
        list.add(1, "World");
        list.add(2, "!");
        try {
            list.get(3);
            Assert.fail("This statement should not be reached. Exception should have been thrown.");
        } catch (NoSuchElementException e) {
            // Expected exception, since list has only elements at places 0, 1 and 2
            // We can assert further properties of the exception, e.g. e.getMessage() equals ...
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void getPosThrowsNoSuchElementExceptionOnNegativePosParameter() {
        StringArrayList list = new StringArrayList();
        list.get(-32);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addThrowsIllegalArgumentExceptionOnTooBigPosParameter() {
        StringArrayList list = new StringArrayList();
        list.add(0, "Hello!");
        list.add(2, "Not valid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addThrowsIllegalArgumentExceptionOnNegativePosParameter() {
        StringArrayList list = new StringArrayList();
        list.add(0, "Hello!");
        list.add(-1, "Not valid");
    }
}