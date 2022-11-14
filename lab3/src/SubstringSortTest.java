import customExceptions.EmptyListException;
import customExceptions.NoSuchSubstringException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstringSortTest {
    @Test
    public void defaultCaseTest(){
        MyList<String> expectedResult = new MyList<>("aa", "cac", "deaf", "bca");
        MyList<String> realResult = new MyList<>("deaf", "aa", "bca", "cac");
        try {
            realResult.substringSort("a");
        } catch (EmptyListException e) {
            System.err.println("smth wrong with defaultCaseTest");
        }
        assertEquals(expectedResult, realResult);
    }

    @Test
    public void reverseOrderCase() {
        MyList<String> expectedResult = new MyList<>("aaaaaaa", "fa", "CfSac", "ccCca");
        MyList<String> realResult = new MyList<>("ccCca", "CfSac", "fa", "aaaaaaa");
        try {
            realResult.substringSort("a");
        } catch (EmptyListException e) {
            System.err.println("smth wrong with reverseOrderCase");
        }
        assertEquals(expectedResult, realResult);
    }

    @Test
    public void noIgnoreCaseTest() {
        MyList<String> realResult = new MyList<>("qawaq");
        assertThrows(NoSuchSubstringException.class, ()->realResult.substringSort("Qa"));
    }

    @Test
    public void singleElementTest() {
        MyList<String> expectedResult = new MyList<>("a");
        MyList<String> realResult = new MyList<>("a");
        try {
            realResult.substringSort("a");
        } catch (EmptyListException e) {
            System.err.println("smth wrong with singleElementTest");
        }
        assertEquals(expectedResult, realResult);
    }

    @Test
    public void nullElementInListThrowsNullPointerException() {
        MyList<String> realResult = new MyList<>("bab", "cab", "cac", "ac");
        realResult.add(null);
        assertThrows(NullPointerException.class,() -> realResult.substringSort("a"));
    }

    @Test
    public void nullValueInSubstringThrowsNullPointerException() {
        MyList<String> realResult = new MyList<>("a", "b", "c", "c", "a");
        assertThrows(NullPointerException.class,() -> realResult.substringSort(null));
    }

    @Test
    public void noSubstringInAnyElementThrowsNoSuchSubstringException() {
        MyList<String> realResult = new MyList<>("abc", "cdef", "efg");
        assertThrows(NoSuchSubstringException.class,() -> realResult.substringSort("ef"));
    }

    @Test
    public void emptyListThrowsEmptyListException() {
        MyList<String> realResult = new MyList<>();
        assertThrows(EmptyListException.class, () -> realResult.substringSort("a"));
    }
}