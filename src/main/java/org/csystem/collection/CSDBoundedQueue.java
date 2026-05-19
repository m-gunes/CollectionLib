package org.csystem.collection;

import org.csystem.collection.exception.FullStackException;

import java.util.NoSuchElementException;

/**
 * Sınıf Çalışması: Eleman sayısını ctor ile alan ve queue dolduğunda RuntimeException sınıfından türetilmiş FullQueueException fırlatan CSDBoundedQueue sınıfını yazınız ve test ediniz.
 */

public class CSDBoundedQueue<E> {
    // Queue<E> arayüzünü implemente eden demiyor!!!

    private E[] m_elements;
    private int m_size;

    private boolean isEmpty()
    {
        return m_size == 0;
    }

    public CSDBoundedQueue(int size)
    {
        m_elements = (E[]) new Object[size];
    }

    public boolean add(Object o)
    {
        if (m_elements.length == m_size)
            throw new FullStackException("Queue is full!");

        m_elements[m_size++] = (E) o;

        return true;
    }

    public boolean offer(Object o)
    {
        return add(o);
    }

    public Object remove()
    {
        var obj = element();

        for (int i = 0; i < m_size - 1; ++i)
            m_elements[i] = m_elements[i + 1];

        m_elements[--m_size] = null;

        return obj;
    }

    public Object poll()
    {
        var obj = peek();
        System.arraycopy(m_elements, 1, m_elements, 0, --m_size);

        return obj;
    }

    public Object element()
    {
        if (isEmpty())
            throw new NoSuchElementException("Empty queue!");

        return m_elements[0];
    }

    public Object peek()
    {
        if (isEmpty())
            return null;

        return m_elements[0];
    }
}
