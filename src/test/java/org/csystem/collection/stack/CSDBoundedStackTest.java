package org.csystem.collection.stack;

import org.csystem.collection.CSDBoundedStack;
import org.csystem.collection.exception.FullStackException;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class CSDBoundedStackTest {

    @Test
    void givenValue_whenStackSizeExceeded_thenThrowException()
    {
        var stack = new CSDBoundedStack<String>(3);
        stack.push("Berlin");
        stack.push("Amsterdam");
        stack.push("Paris");
        assertThrows(FullStackException.class, () -> stack.push("Groningen"));
    }

    @Test
    void callPeekMethod_whenEmpyStack_thenThrowException()
    {
        var stack = new CSDBoundedStack<String>(3);
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    @Test
    void callPeekMethod_whenNotEmpyStack_thenNotThrowException()
    {
        var stack = new CSDBoundedStack<String>(3);
        stack.push("istanbul");
        assertDoesNotThrow(() -> stack.peek());
    }

    @Test
    void givenValue_whenSearch_thenEqualIndex()
    {
        var stack = new CSDBoundedStack<String>(4);

        stack.push("istanbul");
        stack.push("ankara");
        stack.push("izmir");
        stack.push("aksaray");

        int index = stack.search("izmir");
        assertEquals(2, index);
    }

    @Test
    void givenValue_whenPop_thenNotEqual()
    {
        var stack = new CSDBoundedStack<String>(3);
        stack.push("mustafa");
        stack.push("gunes");
        assertNotEquals(stack.pop(), stack.peek());
    }
}
