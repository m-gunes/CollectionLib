package org.csystem.collection.stack;

import org.csystem.collection.CSDBoundedQueue;
import org.csystem.collection.exception.FullStackException;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


public class CSDBoundedQueueTest {
    /**
     *
     Summary of Queue methods

     Throws exception	Returns special value

     Insert	add(e)	          offer(e)
     Remove	remove()	      poll()
     Examine element()	      peek()

     */

    @Test
    void givenValues_whenCapacityRestricted_thenThrowException()
    {

        CSDBoundedQueue<String> queue = new CSDBoundedQueue<>(3);
        queue.add("mustafa");
        queue.add("gunes");
        queue.add("berlin");

        assertThrows(FullStackException.class, () -> queue.add("groningen"));
    }

    @Test
    void givenValues_WhenCallingAddAndOfferMethods_thenEqual()
    {
        CSDBoundedQueue<String> queue = new CSDBoundedQueue<>(10);
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
        CSDBoundedQueue<String> queue = new CSDBoundedQueue<>(10);
        assertThrows(NoSuchElementException.class, queue::element);
    }

    @Test
    void callElementMethod_whenNotEmptyQueue_thenNotThrowException()
    {
        CSDBoundedQueue<String> queue = new CSDBoundedQueue<>(10);
        queue.offer(600);
        assertDoesNotThrow(queue::element);
    }

    @Test
    void callPeekMethod_whenEmptyQueue_thenReturnNull()
    {
        CSDBoundedQueue<String> queue = new CSDBoundedQueue<>(10);
        assertNull(queue.peek());
    }

    @Test
    void givenValues_WhenCallingRemoveAndPoll_thenEqual()
    {
        CSDBoundedQueue<String> queue = new CSDBoundedQueue<>(10);
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
        CSDBoundedQueue<String> queue = new CSDBoundedQueue<>(10);
        assertThrows(NoSuchElementException.class, queue::remove);
    }
}
