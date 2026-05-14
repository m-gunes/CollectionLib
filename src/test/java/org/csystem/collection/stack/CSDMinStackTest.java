package org.csystem.collection.stack;

import org.csystem.collection.CSDMinStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CSDMinStackTest {

    @Test
    void givenValues_whenComparatorConstructor_thenEqual()
    {
        var stack = new CSDMinStack<Integer>(Integer::compare);
        stack.push(7);
        stack.push(11);
        stack.push(3);
        stack.push(5);
        Assertions.assertEquals(3, stack.min());
    }

    @Test
    void givenValues_whenDefaultConstructor_thenEqual()
    {
        var stack = new CSDMinStack<Integer>();
        stack.push(7);
        stack.push(11);
        stack.push(3);
        stack.push(5);
        Assertions.assertEquals(3, stack.min());
    }

    @Test
    void givenValues_whenRemove_thenEqual()
    {
        var stack = new CSDMinStack<Integer>();
        stack.push(7);
        stack.push(5);
        stack.push(11);
        stack.push(3);
        stack.pop();
        Assertions.assertEquals(5, stack.min());
    }
}
