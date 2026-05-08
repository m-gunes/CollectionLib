package org.csystem.collection;

import java.util.*;

/**
 * Sınıf Çalışması:
 * <p>
 * Tutulan en küçük elemanı O(1) karmaşıklıkta veren ve push ve pop işlemlerinin de en fazla amortized O(1) karmaşıklıkta çalıştığı aşağıdaki CSDMinStack sınıfını yazınız.
 * <p>
 *
 *  Açıklamalar:
 * <p>
 *  Sınıfın public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz.
 *
 */

/**
public class CSDMinStack<E> {
    public CSDMinStack()
    {
        throw new UnsupportedOperationException("TODO: This assume that E is Comparable");
    }

    public CSDMinStack(Comparator<? super E> comparator)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public E min()
    {
        throw new UnsupportedOperationException("TODO: Must be O(1) cost");
    }

    public E peek()
    {
        throw new UnsupportedOperationException("TODO");
    }

    public E pop()
    {
        throw new UnsupportedOperationException("TODO");
    }

    public E push(E item)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public int search(E item)
    {
        throw new UnsupportedOperationException("TODO");
    }
}
*/

// ArrayList'ten turete bilir yada iceride ArrayList kullanabilirsiniz. yada dogrudan stack sinifinida kullanabilirsiniz. Cunku bir kisit koymamis
public class CSDMinStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int CAPACITY_FACTOR = 2;
    private E m_min;
    private Comparator<E> m_comparator;
    private E[] m_elements;
    private int m_elementSize;

    private void minCheck(E item)
    {
        if (item == null)
            return;

        if (m_min == null) // for the first value
            m_min = item;

//        else if (m_comparator != null)
        else if (m_comparator.compare(item, m_min) < 0)
            m_min = item;
    }

    private void increaseCapacity(int capacity)
    {
        m_elements = Arrays.copyOf(m_elements, capacity);
    }

    private void capacityCheck()
    {
        if (m_elements.length == m_elementSize)
            increaseCapacity(m_elements.length == 0 ? 1 : m_elements.length * CAPACITY_FACTOR);
    }

//    public CSDMinStack()
//    {
//        //throw new UnsupportedOperationException("TODO: This assume that E is Comparable");
//        m_elements = (E[]) new Object[DEFAULT_CAPACITY];
//    }

    public CSDMinStack(Comparator<? super E> comparator)
    {
        m_comparator = (Comparator<E>) comparator;
        m_elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public E min()
    {
        return m_min;
    }

    public E peek()
    {
        if (m_elementSize == 0)
            throw new EmptyStackException();

        return m_elements[m_elementSize - 1];
    }

    public E pop()
    {
        var oldObj = peek();
        m_elements[--m_elementSize] = null;

        return oldObj;
    }


    public E push(E item)
    {
        capacityCheck();
        m_elements[m_elementSize++] = item;
        minCheck(item);

        return item;
    }

    public int search(E item)
    {
        for (int i = m_elementSize - 1; i >= 0; --i)
            if (Objects.equals(item, m_elements[i]))
                return m_elementSize - i;

        return -1;
    }

    public boolean empty()
    {
        return m_elementSize == 0;
    }

}
