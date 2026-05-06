package org.csystem.collection;

/**
 * Sınıf Çalışması: <p>
 *   Eleman sayısını ctor ile alan ve stack dolduğunda RuntimeException sınıfından türetilmiş FullStackException fırlatan aşağıdaki CSDBoundedStack sınıfını yazınız.
 *   <p>
 *   Açıklamalar:
 *   <p>
 *     Sınıfın public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz.
 */
// iceride dizi veri yapisi kullan.
// Size doldugunda FullStackException firlatacak

import org.csystem.collection.exception.FullStackException;

import java.util.EmptyStackException;
import java.util.Objects;

/**
public class CSDBoundedStack<E> {
    public CSDBoundedStack(int size)
    {
        throw new UnsupportedOperationException("TODO");
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

public class CSDBoundedStack<E> {
    private E[] m_elements;
    private int m_elementSize;

    public CSDBoundedStack(int size)
    {
        m_elements = (E[]) new Object[size];
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
        if (m_elements.length == m_elementSize)
            throw new FullStackException("Stack is full");

        m_elements[m_elementSize++] = item;
        return item;
    }

    public int search(E item)
    {
        for (int i = m_elementSize - 1; i >= 0; --i)
            if (Objects.equals(item, m_elements[i]))
                return m_elementSize - i;

        return -1;
    }
}
