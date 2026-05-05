package org.csystem.collection.stack;

import org.csystem.collection.CSDStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CSDStackTest {

    @Test
    void givenValue_whenPushAndPeekTheElement_thenEqual_v1()
    {
        var stack = new CSDStack<String>();
        var str = "gunes";
        stack.push("mustafa");
        Assertions.assertEquals(stack.push(str), stack.peek());
    }

    @Test
    void givenValue_whenPopTheList_thenNotEqual_v1()
    {
        var stack = new CSDStack<String>();
        var str = "gunes";
        stack.push("mustafa");
        stack.push(str);

        Assertions.assertNotEquals(stack.pop(), stack.peek());
    }

    @Test
    void givenValue_whenSearch_thenEqual_v1()
    {
        var stack = new CSDStack<String>();
        var str = "gunes";
        stack.push("mustafa");
        stack.push(str);

        var index = stack.search(str);
        Assertions.assertEquals(2, index);
    }
}
