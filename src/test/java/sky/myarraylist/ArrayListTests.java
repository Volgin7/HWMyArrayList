package sky.myarraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sky.myarraylist.exception.ElementNotFoundException;
import sky.myarraylist.exception.OutOfArrayLimitsException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListTests {

    @Test
    @DisplayName("Test of add method")
    void addTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        String expected = "First String";

        Assertions.assertEquals(expected, stringList.add(expected));
    }
    @Test
    @DisplayName("Test of add method exceptions")
    void addOutOfLimitsExceptionTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");
        stringList.add("Str 1");
        stringList.add("Str 2");
        stringList.add("Str 3");

        assertDoesNotThrow(() -> stringList.add("Str 4"));
        assertThrows(OutOfArrayLimitsException.class, () -> stringList.add("Out of Limit"));
        assertThrows(OutOfArrayLimitsException.class, () -> stringList.add(4,"Out of Limit"));
    }

    @Test
    @DisplayName("Test of add by Index method")
    void addToIndexTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");
        stringList.add("Str 1");
        String expected = "Str 1 new";

        Assertions.assertEquals(expected, stringList.add(1,expected));
    }

    @Test
    @DisplayName("Test of set method")
    void setTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");
        stringList.add("Str 1");
        String expected = "Str 1 too";

        Assertions.assertEquals(expected, stringList.set(0,expected));
    }

    @Test
    @DisplayName("Test of set method exceptions")
    void setExceptionsTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");
        String item = null;

        Assertions.assertThrows(OutOfArrayLimitsException.class, ()->stringList.set(1,"Out of limits"));
        Assertions.assertDoesNotThrow(()->stringList.set(0,"Out of limits"));
    }

    @Test
    @DisplayName("Test of remove by index method")
    void removeByIndexTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        String item = "Str 0";
        stringList.add(item);

        Assertions.assertEquals(item, stringList.remove(0));
    }
    @Test
    @DisplayName("Test of remove by index method exception")
    void removeByIndexExceptionTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        String item = "Str 0";
        stringList.add(item);

        Assertions.assertDoesNotThrow(()->stringList.remove(0));
        Assertions.assertThrows(OutOfArrayLimitsException.class, ()->stringList.remove(1));
    }

    @Test
    @DisplayName("Test of remove by value method")
    void removeByValueTest() throws ElementNotFoundException, OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        String item = "Str 0";
        stringList.add(item);

        Assertions.assertEquals(item, stringList.remove(item));
    }

    @Test
    @DisplayName("Test of remove by value method exception")
    void removeByValueExceptionTest() throws ElementNotFoundException, OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        String item = "Str 0";
        stringList.add(item);

        Assertions.assertThrows(ElementNotFoundException.class, ()->stringList.remove("another string"));
    }
    @Test
    @DisplayName("Test of contains method - positive")
    void containsPositiveTest() throws ElementNotFoundException, OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");

        Assertions.assertTrue(()->stringList.contains("Str 0"));
    }

    @Test
    @DisplayName("Test of contains method - negative")
    void containsNegativeTest() throws ElementNotFoundException, OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");

        Assertions.assertFalse(()->stringList.contains("another string"));
    }

    @Test
    @DisplayName("Test of index method")
    void indexOfTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");
        stringList.add("Str 1");
        stringList.add("Str 0");

        Assertions.assertEquals(0, stringList.indexOf("Str 0"));
        Assertions.assertEquals(2, stringList.lastIndexOf("Str 0"));
        Assertions.assertEquals(-1, stringList.indexOf("another string"));
        Assertions.assertEquals(-1, stringList.lastIndexOf("another string"));
    }

    @Test
    @DisplayName("Test of get method")
    void getTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");
        stringList.add("Str 1");

        Assertions.assertEquals("Str 1", stringList.get(1));
    }
    @Test
    @DisplayName("Test of get method exception")
    void getExceptionTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");
        stringList.add("Str 1");

        Assertions.assertThrows(OutOfArrayLimitsException.class,()->stringList.get(3));
    }

    @Test
    @DisplayName("Test of equals method - positive")
    void equalsPositiveTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");
        stringList.add("Str 1");

        Assertions.assertTrue(stringList.equals(stringList));
    }
    @Test
    @DisplayName("Test of equals method - negative")
    void equalsNegativeTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");
        stringList.add("Str 1");

        ArrayList stringList2 = new ArrayList();
        stringList2.add("Str 0");
        stringList2.add("another string");

        Assertions.assertFalse(stringList.equals(stringList2));
    }

    @Test
    @DisplayName("Test of size method")
    void getSize() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");
        stringList.add("Str 1");

        Assertions.assertEquals(2, stringList.size());
    }
    @Test
    @DisplayName("Test of isEmpty method - negative")
    void isEmptyNegativeTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");
        stringList.add("Str 1");

        Assertions.assertFalse(stringList.isEmpty());
    }

    @Test
    @DisplayName("Test of isEmpty method - positive")
    void isEmptyPositiveTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();

        Assertions.assertTrue(stringList.isEmpty());
    }

    @Test
    @DisplayName("Test of clear method")
    void clearTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");
        stringList.add("Str 1");

        stringList.clear();
        Assertions.assertEquals(0,stringList.size());
    }

    @Test
    @DisplayName("Test of clear method - exception")
    void clearExceptionTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");
        stringList.add("Str 1");

        stringList.clear();
        Assertions.assertThrows(OutOfArrayLimitsException.class, ()->stringList.get(0));
    }

    @Test
    @DisplayName("Test of toArray method")
    void toArrayTest() throws OutOfArrayLimitsException {
        ArrayList stringList = new ArrayList();
        stringList.add("Str 0");
        stringList.add("Str 1");

        String[] newArray = stringList.toArray();
        Assertions.assertEquals(stringList.get(1), newArray[1]);
    }
}
