package org.csystem.collection;

import java.util.*;

/**
 * Sınıf Çalışması: Yalnızca Object sınıfından türetilen, Queue<E> arayüzünü implemente eden CSDQueue sınıfını dinamik büyüyen dizi implementasyonu olarak yazınız ve test ediniz.
 * @param <E>
 */

public class CSDQueue<E> implements Queue {
    private E [] m_elements;
    private int m_elementSize;
    private final static int FACTOR = 2;

    private void changeCapacity(int capacity)
    {
        m_elements = Arrays.copyOf(m_elements, capacity);
    }

    private void checkCapacity()
    {
        if (m_elements.length == m_elementSize)
            changeCapacity(m_elements.length == 0 ? 1 : m_elements.length * FACTOR);

    }

    @Override
    public int size()
    {
        return m_elementSize;
    }

    @Override
    public boolean isEmpty()
    {
        return m_elementSize == 0;
    }

    @Override
    public boolean contains(Object o)
    {
        return false;
    }

    @Override
    public Iterator iterator()
    {
        return null;
    }


    @Override
    public Object[] toArray()
    {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a)
    {
        return new Object[0];
    }

    @Override
    public boolean add(Object o)
    {
        return offer(o);
    }

    @Override
    public boolean remove(Object o)
    {
        return false;
    }

    @Override
    public boolean addAll(Collection c)
    {
        return false;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < m_elementSize; ++i)
            m_elements[i] = null;

        m_elementSize = 0;
    }

    @Override
    public boolean retainAll(Collection c)
    {
        return false;
    }

    @Override
    public boolean removeAll(Collection c)
    {
        return false;
    }

    @Override
    public boolean containsAll(Collection c)
    {
        return false;
    }

    @Override
    public boolean offer(Object o)
    {
        // check capacity
        checkCapacity();
        m_elements[m_elementSize++] = (E) o;
        return true;
    }

    @Override
    public Object remove()
    {
        var obj = element();

        for (int i = 0; i < m_elementSize - 1; ++i)
            m_elements[i] = m_elements[i + 1];

        m_elements[--m_elementSize] = null;
        return obj;
    }

    @Override
    public Object poll()
    {
        var obj = peek();
        System.arraycopy(m_elements, 1, m_elements, 0, --m_elementSize);

        return obj;
    }

    @Override
    public Object element()
    {
        if (m_elementSize == 0)
            throw new NoSuchElementException("There is no element!");

        return m_elements[0];
    }

    @Override
    public Object peek()
    {
        if (m_elementSize == 0)
            return  null;

        return m_elements[0];
    }
}
