package org.csystem.collection.stack;

import org.csystem.collection.CSDMinStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CSDMinStackTest {

    @Test
    void givenValues_whenGettingMinStack_thenEqual()
    {
        var stack = new CSDMinStack<Integer>(Integer::compare);
        stack.push(7);
        stack.push(11);
        stack.push(3);
        stack.push(5);
        Assertions.assertEquals(3, stack.min());
    }
}
