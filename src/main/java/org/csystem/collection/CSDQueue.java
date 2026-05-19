package org.csystem.collection;

import java.util.*;

/**
 * Sınıf Çalışması: Yalnızca Object sınıfından türetilen, Queue<E> arayüzünü implemente eden CSDQueue sınıfını dinamik büyüyen dizi implementasyonu olarak yazınız ve test ediniz.
 * @param <E>
 */

public class CSDQueue<E> implements Queue<E> {
    private E [] m_elements;
    private int m_size;
    private final static int FACTOR = 2;
    private static final int INITIAL_CAPACITY = 10;

    private void changeCapacity(int capacity)
    {
        m_elements = Arrays.copyOf(m_elements, capacity);
    }

    private void checkCapacity()
    {
        if (m_elements.length == m_size)
            changeCapacity(m_elements.length == 0 ? 1 : m_elements.length * FACTOR);
    }

    private int indexOf(Object o)
    {
        for (int i = 0; i < m_size; ++i)
            if (Objects.equals(o, m_elements[i]))
                return i;

        return -1;
    }

    public CSDQueue()
    {
        m_elements = (E[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public int size()
    {
        return m_size;
    }

    @Override
    public boolean isEmpty()
    {
        return m_size == 0;
    }

    @Override
    public boolean contains(Object o)
    {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<E>() {
            int index;

            @Override
            public boolean hasNext()
            {
                return index < m_size;
            }

            @Override
            public E next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No more item");

                return m_elements[index++];
            }
        };
    }

    @Override
    public Object[] toArray()
    {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        return null;
    }

    @Override
    public boolean add(E o)
    {
        return offer(o);
    }

    @Override
    public boolean remove(Object o)
    {
        int indexToRemove = indexOf(o);
        for (int i = indexToRemove; i < m_size - 1; ++i)
            m_elements[i] = m_elements[i + i];

        m_elements[--m_size] = null;

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        for (var item : c)
            add(item);

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        c.forEach(e -> e = null);

//        for (int i = 0; i < m_size; ++i)
//            m_elements[i] = null;
//
//        m_size = 0;

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        return false;
    }


    @Override
    public boolean containsAll(Collection<?> c)
    {
        for (var item : c)
            if (!contains(item))
                return false;

        return true;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < m_size; ++i)
            m_elements[i] = null;

        m_size = 0;
    }

    @Override
    public boolean offer(E o)
    {
        // check capacity
        checkCapacity();
        m_elements[m_size++] = o;
        return true;
    }

    @Override
    public E remove()
    {
        var obj = element();

        for (int i = 0; i < m_size - 1; ++i)
            m_elements[i] = m_elements[i + 1];

        m_elements[--m_size] = null;
        return obj;
    }

    @Override
    public E poll()
    {
        var obj = peek();
        System.arraycopy(m_elements, 1, m_elements, 0, --m_size);

        return obj;
    }

    @Override
    public E element()
    {
        if (m_size == 0)
            throw new NoSuchElementException("There is no element!");

        return m_elements[0];
    }

    @Override
    public E peek()
    {
        if (m_size == 0)
            return  null;

        return m_elements[0];
    }
}
