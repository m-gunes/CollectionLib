package org.csystem.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class CSDArrayListRemoveTest {

    @Test
    void givenValues_whenListAndReference_thenRemoveObject()
    {
        var list = new CSDArrayList<String>();
        var ankara = "ankara";
        list.add(ankara);
        list.add("istanbul");
        list.add("berlin");

        list.remove(ankara);

        Assertions.assertNotEquals(ankara, list.get(0));
    }

    @Test
    void givenValues_whenListAndReference_thenRemoveAll()
    {
        var strSet = new TreeSet<String>();
        strSet.add("mustafa");
        strSet.add("gunes");

        var list = new CSDArrayList<String>();
        list.addAll(strSet);

        list.removeAll(strSet);
        Assertions.assertEquals(0, list.size());
    }
}
