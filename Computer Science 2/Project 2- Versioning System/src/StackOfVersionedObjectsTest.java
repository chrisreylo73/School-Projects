import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackOfVersionedObjectsTest {

    @Test
    public void simpleStackTest() {
        StackOfVersionedObjects stack = new StackOfVersionedObjects("test", "how are you?");
        assertFalse(stack.isEmpty());
        stack.put("How are you?");
        assertFalse(stack.isEmpty());
        String obj = (String) stack.get();
        assertEquals("How are you?", obj);
        String out = stack.toString();
        String expected = "key: test\n" +
                "\tVersionedObject{object=How are you?, version=1}\n" +
                "\tVersionedObject{object=how are you?, version=0}";
        assertEquals(expected, out);
        stack.delete();
        assertFalse(stack.isEmpty());
        out = stack.toString();
        expected = "key: test\n" +
                "\tVersionedObject{object=how are you?, version=0}";
        assertEquals(expected, out);
        obj = (String) stack.get();
        assertEquals("how are you?", obj);
        stack.delete();
        assertTrue(stack.isEmpty());
        out = stack.toString();
        expected = "key: test; this stack is empty!";
        assertEquals(expected, out);
        assertThrows(EmptyStackException.class, () -> {
            stack.get();
            stack.put("Hi!");
            stack.delete();
        });
    }
}