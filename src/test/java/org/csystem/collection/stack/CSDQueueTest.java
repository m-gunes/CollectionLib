package org.csystem.collection.stack;

import org.csystem.collection.CSDQueue;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class CSDQueueTest {
    /**
     *
     Summary of Queue methods

     Throws exception	Returns special value

     Insert	add(e)	          offer(e)
     Remove	remove()	      poll()
     Examine element()	      peek()

     */

    @Test
    void givenValues_WhenCallingAddAndOfferMethods_thenEqual()
    {
        CSDQueue<String> queue = new CSDQueue();
        String first = "first";
        queue.add(first);
        queue.offer("second");
        queue.add("third");
        queue.offer("forth");
        // first, second, third, forth

        assertEquals(first, queue.peek());
        assertEquals(first, queue.element());
    }

    @Test
    void callElementMethod_whenEmptyQueue_thenThrowException()
    {
        CSDQueue<Integer> queue = new CSDQueue<>();
        assertThrows(NoSuchElementException.class, queue::element);
    }

    @Test
    void callElementMethod_whenNotEmptyQueue_thenNotThrowException()
    {
        CSDQueue<Integer> queue = new CSDQueue<>();
        queue.offer(600);
        assertDoesNotThrow(queue::element);
    }

    @Test
    void callPeekMethod_whenEmptyQueue_thenReturnNull()
    {
        CSDQueue<Integer> queue = new CSDQueue<>();
        assertNull(queue.peek());
    }


    @Test
    void givenValues_WhenCallingRemoveAndPoll_thenEqual()
    {
        CSDQueue<String> queue = new CSDQueue();
        String first = "first";
        String second = "second";
        queue.add(first);
        queue.offer(second);
        // first, second
        assertEquals(first, queue.remove());
        assertEquals(second, queue.poll());
    }

    @Test
    void callRemove_whenEmptyQueue_thenThrowException()
    {
       CSDQueue<String> queue = new CSDQueue<>();
       assertThrows(NoSuchElementException.class, queue::remove);
    }
}
