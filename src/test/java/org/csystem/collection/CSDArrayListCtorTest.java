package org.csystem.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class CSDArrayListCtorTest {
    @Test
    void givenValues_whenCreated_thenEqual()
    {

        var strSet = new TreeSet<String>();
        strSet.add("mustafa");
        strSet.add("gunes");

        System.out.println(strSet.first());

        var list = new CSDArrayList<>(strSet);
        System.out.println(list);
        Assertions.assertEquals(strSet.first(), list.get(0));

    }
}
