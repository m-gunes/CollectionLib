package org.csystem.collection;

import java.util.Arrays;
import java.util.Objects;

/**
 * Sınıf Çalışması: <p>
 * Yalnızca Object sınıfından türetilen ve dinamik olarak büyüyebilen aşağıdaki CSDStack sınıfını yazınız.
 *
 * <p>
 * Açıklamalar: <p>
 *
 * <p>Sınıfın public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz
 * <p>JavaSE'nin Stack<E> sınıfı kullanılmayacaktır.
 */
// herhangi bir collection siniftan turemeyecek ama iceride kullanabilirsiniz. stack disinda
public class CSDStackV2<E> {
        // rule:
        // before the derived/sub/child class constructor,
        // if there is no indication in derived class constructor,
        // base/super/parent class default constructor will call

        // here when default CSDStack is called, I need to do something like in Vector

        // v2 use its own list. dizi veri yapisi kullan
    private final static int DEFAULT_CAPACITY = 10;
    private final static int CAPACITY_INCREMENT_FACTOR = 2;
    private E[] m_elements;
    private int m_elementSize;

    private void increaseCapacity()
    {
        int newCapacity = m_elements.length == 0 ? 1 : m_elements.length * CAPACITY_INCREMENT_FACTOR;
        m_elements = Arrays.copyOf(m_elements, newCapacity);

        // Another solution
        // copy the current element to the new list
//        var n_elements = (E[]) new Object[newCapacity];
//        for (int i = 0; i < m_elements.length; ++i)
//            n_elements[i] = m_elements[i];
//        m_elements = n_elements;
    }

    public CSDStackV2()
    {
         // throw new UnsupportedOperationException("TODO");
        m_elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public E peek()
    {
         // throw new UnsupportedOperationException("TODO");
        return m_elements[m_elementSize-1];
    }

    public E pop()
    {
         // throw new UnsupportedOperationException("TODO");
        var oldObj = peek();
        m_elements[--m_elementSize] = null;
        return oldObj;
    }

    public E push(E item)
    {
         // throw new UnsupportedOperationException("TODO");
        // check if list capacity is enough
        if (m_elements.length == m_elementSize)
            increaseCapacity();

        m_elements[m_elementSize++] = item;
        return item;
    }

    public int search(E item)
    {
         // throw new UnsupportedOperationException("TODO");

//        if (item == null) {
//            for (int i = m_elementSize - 1; i >= 0; --i)
//                if (m_elements[i] == null)
//                    return i+1;
//        } else {
//           for (int i = m_elementSize - 1; i >= 0; --i)
//               if (item.equals(m_elements[i]))
//                   return i+1;
//        }

        for (int i = m_elementSize - 1; i >= 0; --i)
            if (Objects.equals(item, m_elements[i]))
                return i+1;

        return -1;
    }
}
