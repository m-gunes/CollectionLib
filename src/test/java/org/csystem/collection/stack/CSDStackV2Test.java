package org.csystem.collection.stack;

import org.csystem.collection.CSDStackV2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CSDStackV2Test {

    @Test
    void givenValue_whenPushAndPeekTheElement_thenEqual_v2()
    {
        var stack = new CSDStackV2<String>();
        var str = "gunes";
        stack.push("mustafa");
        Assertions.assertEquals(stack.push(str), stack.peek());
    }

    @Test
    void givenValue_whenPopTheList_thenNotEqual_v2()
    {
        var stack = new CSDStackV2<String>();
        var str = "gunes";
        stack.push("mustafa");
        stack.push(str);

        Assertions.assertNotEquals(stack.pop(), stack.peek());
    }

    @Test
    void givenValue_whenSearch_thenEqual_v2()
    {
        var stack = new CSDStackV2<String>();
        var str = "gunes";
        stack.push("mustafa");
        stack.push(str);

        var index = stack.search(str);
        Assertions.assertEquals(2, index);
    }
}
