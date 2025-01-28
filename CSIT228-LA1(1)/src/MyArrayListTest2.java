import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest2 {
    MyArrayList<String> list;

    @BeforeEach
    public void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    public void testAdd() {
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.add("Jazz");
        });
        assertEquals(3, list.size());
        assertEquals("Cathy", list.get(1));
        assertEquals("Lea", list.get(2));
        assertEquals("Jazz", list.get(3));
    }
    @Test
    public void testFullOnAdd() {
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.add("Jazz");
            list.add("Path");
            list.add("Nat");
        });
        assertThrows(ArrayFullException.class, () -> list.add("Vaughn"));
    }

    @Test
    public void testAddAt1() {
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.addAt("Jazz",2);
            list.addAt("Path",2);
        });
        assertEquals(4, list.size());
        assertEquals("Cathy", list.get(1));
        assertEquals("Path", list.get(2));
        assertEquals("Jazz", list.get(3));
        assertEquals("Lea", list.get(4));
    }

    @Test
    public void testAddAt2() {
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.addAt("Jazz",1);
            list.addAt("Path",4);
        });
        assertEquals(4, list.size());
        assertEquals("Jazz", list.get(1));
        assertEquals("Cathy", list.get(2));
        assertEquals("Lea", list.get(3));
        assertEquals("Path", list.get(4));
    }

    @Test
    public void testAddAt3() {
        assertDoesNotThrow(() -> {
            list.addAt("Jazz",1);
            list.addAt("Path",2);
            list.add("Cathy");
            list.add("Lea");
        });
        assertEquals(4, list.size());
        assertEquals("Jazz", list.get(1));
        assertEquals("Path", list.get(2));
        assertEquals("Cathy", list.get(3));
        assertEquals("Lea", list.get(4));
    }

    @Test
    public void testFullOnAddAt() {
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.addAt("Jazz",1);
            list.addAt("Path",2);
            list.addAt("Nat",1);
        });
        assertThrows(ArrayFullException.class, () -> list.addAt("Vaughn", 3));
    }

    @Test
    public void testRemove1() {
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.add("Jazz");
        });
        assertTrue(list.remove("Cathy"));
        assertFalse(list.remove("Cathy"));
        assertEquals(2, list.size());
        assertEquals("Lea", list.get(1));
        assertEquals("Jazz", list.get(2));
    }

    @Test
    public void testRemove2() {
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.add("Jazz");
            list.add("Path");
            list.add("Nat");
        });
        assertTrue(list.remove("Jazz"));
        assertDoesNotThrow(() -> {
            list.add("Vaughn");
        });
        assertEquals(5, list.size());
        assertEquals("Cathy", list.get(1));
        assertEquals("Lea", list.get(2));
        assertEquals("Path", list.get(3));
        assertEquals("Nat", list.get(4));
        assertEquals("Vaughn", list.get(5));
    }
    @Test
    public void testRemove3() {
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.add("Jazz");
            list.add("Path");
            list.add("Nat");
        });
        assertTrue(list.remove("Jazz"));
        assertDoesNotThrow(() -> {
            list.addAt("Vaughn", 5);
        });
        assertEquals(5, list.size());
        assertEquals("Cathy", list.get(1));
        assertEquals("Lea", list.get(2));
        assertEquals("Path", list.get(3));
        assertEquals("Nat", list.get(4));
        assertEquals("Vaughn", list.get(5));
    }
    @Test
    public void testRemoveAt1() {
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.add("Jazz");
        });
        assertEquals("Cathy", list.removeAt(1));
        assertEquals("Lea", list.removeAt(1));
        assertEquals(1, list.size());
        assertEquals("Jazz", list.get(1));
        assertThrows(InvalidPositionException.class, () -> list.get(2));
    }

    @Test
    public void testRemoveAt2() {
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.add("Jazz");
            list.add("Path");
            list.add("Nat");
        });
        assertEquals("Jazz", list.removeAt(3));
        assertDoesNotThrow(() -> {
            list.add("Vaughn");
        });
        assertEquals(5, list.size());
        assertEquals("Cathy", list.get(1));
        assertEquals("Lea", list.get(2));
        assertEquals("Path", list.get(3));
        assertEquals("Nat", list.get(4));
        assertEquals("Vaughn", list.get(5));
    }
    @Test
    public void testRemoveAt3() {
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.add("Jazz");
            list.add("Path");
            list.add("Nat");
        });
        assertEquals("Jazz", list.removeAt(3));
        assertDoesNotThrow(() -> {
            list.addAt("Vaughn", 5);
        });
        assertEquals(5, list.size());
        assertEquals("Cathy", list.get(1));
        assertEquals("Lea", list.get(2));
        assertEquals("Path", list.get(3));
        assertEquals("Nat", list.get(4));
        assertEquals("Vaughn", list.get(5));
    }

    @Test
    public void testContains() {
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.add("Jazz");
        });
        assertTrue(list.contains("Cathy"));
        assertTrue(list.remove("Cathy"));
        assertFalse(list.contains("Cathy"));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.add("Jazz");
        });
        assertFalse(list.isEmpty());
        assertDoesNotThrow(() -> {
            list.removeAt(1);
            list.removeAt(2);
            list.removeAt(1);
        });
        assertTrue(list.isEmpty());
    }

    @Test
    public void testSet1() {
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.add("Jazz");
        });
        assertEquals("Lea", list.set(2, "Nat"));
        assertEquals("Nat", list.set(2, "Roadeghn"));
    }

    @Test
    public void testSet2() {
        assertDoesNotThrow(() -> {
            list.add("Cathy");
            list.add("Lea");
            list.add("Jazz");
        });
        assertThrows(InvalidPositionException.class, () -> list.set(4, "Path"));
    }

    @Test
    public void testInvalidPos1() {
        assertDoesNotThrow(() -> {
            list.add("Eugenio");
            list.add("Migan");
        });
        assertThrows(InvalidPositionException.class, () -> list.addAt("Roadeghn", 4));
        assertThrows(InvalidPositionException.class, () -> list.addAt("Roadeghn", 7));
    }

    @Test
    public void testInvalidPos2() {
        assertDoesNotThrow(() -> {
            list.add("Eugenio");
            list.add("Migan");
        });
        assertThrows(InvalidPositionException.class, () -> list.addAt("Roadeghn", 0));
        assertThrows(InvalidPositionException.class, () -> list.addAt("Roadeghn", -1));
    }

    @Test
    public void testInvalidPos3() {
        assertDoesNotThrow(() -> {
            list.add("Eugenio");
            list.add("Migan");
        });
        assertThrows(InvalidPositionException.class, () -> list.removeAt(0));
        assertThrows(InvalidPositionException.class, () -> list.removeAt(3));
    }

    @Test
    public void testInvalidPos4() {
        assertDoesNotThrow(() -> {
            list.add("Eugenio");
            list.add("Migan");
        });
        assertThrows(InvalidPositionException.class, () -> list.get(0));
        assertThrows(InvalidPositionException.class, () -> list.get(3));
    }

    @Test
    public void testArrayFullIsChecked() {
        assertTrue(Exception.class.isAssignableFrom(ArrayFullException.class));
        assertFalse(RuntimeException.class.isAssignableFrom(ArrayFullException.class));
    }

    @Test
    public void testInvalidPosIsUnchecked() {
        assertTrue(Exception.class.isAssignableFrom(InvalidPositionException.class));
        assertTrue(RuntimeException.class.isAssignableFrom(InvalidPositionException.class));
    }

    @Test
    public void testFieldsPrivate() {
        Field[] fields = MyArrayList.class.getDeclaredFields();
        for (Field f : fields) {
            int modifiers = f.getModifiers();
            assertTrue(Modifier.isPrivate(modifiers));
        }
    }

    @Test
    public void testExceptionMessage1() {
        try {
            list.addAt("Roadeghn", 2);
        } catch (InvalidPositionException e) {
            assertEquals("Position must be between 1 and 1", e.getMessage());
        } catch (ArrayFullException e) {
            fail("Array is not full");
        }
    }

    @Test
    public void testExceptionMessage2() {
        try {
            list.add("Cathy");
            list.add("Lea");
            list.add("Jazz");
            list.add("Path");
            list.add("Nat");
            list.add("Jay Vince");
        } catch (ArrayFullException e) {
            assertEquals("The array is full and Jay Vince cannot be inserted.", e.getMessage());
        }
    }
}
