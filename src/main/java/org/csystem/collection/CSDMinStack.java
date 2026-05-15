package org.csystem.collection;

import java.util.*;

/**
  Sınıf Çalışması: <p>
  Tutulan en küçük elemanı O(1) karmaşıklıkta veren ve push ve pop işlemlerinin de en fazla amortized O(1) karmaşıklıkta çalıştığı aşağıdaki CSDMinStack sınıfını yazınız.

  <p>
  Açıklamalar: <p>
     Sınıfın public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz.
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
//    what if before calling min, pop is called ?
//    min stack will be gone! What you can do?
//    Think about another stack to hold minimum elements
    // Teacher notes:
    // `Boyle bir Stack null tutamaz!` Compare yaparken null ile neyi compare edeceksiniz? Bu yuzden kodunuz patlar
public class CSDMinStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int CAPACITY_FACTOR = 2;
    private E[] m_sortedList;
    private int m_sortedListSize;
    private Comparator<? super E> m_comparator;
    private E[] m_elements;
    private int m_elementSize;
    private int lastItemIndex;


    private void addWithComparator(E item)
    {
        int index = m_sortedListSize;

        while (index > 0) {
            var listItem = m_sortedList[index - 1];

            if (m_comparator.compare(item, listItem) >= 0) // trying to add at the end of the list
                break;

            m_sortedList[index--] = listItem;
        }
        m_sortedList[index] = item;
        lastItemIndex = index;
    }

    private void addWithComparable(E item)
    {
        Comparable<E> cmp = (Comparable<E>) item; // downcast
        int index = m_sortedListSize;

        while (index > 0) {
            var listItem = m_sortedList[index - 1];

            if (cmp.compareTo(listItem) >= 0)
                break;

            m_sortedList[index--] = listItem;
        }
        m_sortedList[index] = item;
        lastItemIndex = index;
    }

    private void sort(E item)
    {
       if (m_comparator == null) {
           addWithComparable(item);
       } else {
           addWithComparator(item);
       }
    }

    private void minCheck(E item)
    {
        if (item == null)
            return;

        if (m_sortedListSize == 0)
            m_sortedList[m_sortedListSize] = item;
        else
            sort(item);

        ++m_sortedListSize;
    }

    private void removeItemFromSortedList()
    {
        // from index slide the list to the left
        for (int i = lastItemIndex; i < m_sortedListSize; ++i)
            m_sortedList[i] = m_sortedList[i + 1];

        m_sortedList[--m_sortedListSize] = null;
    }

    private void increaseCapacity(int capacity)
    {
        m_elements = Arrays.copyOf(m_elements, capacity);
        m_sortedList = Arrays.copyOf(m_sortedList, capacity);
    }

    private void capacityCheck()
    {
        if (m_elements.length == m_elementSize)
            increaseCapacity(m_elements.length == 0 ? 1 : m_elements.length * CAPACITY_FACTOR);
    }

    public CSDMinStack()
    {
        //throw new UnsupportedOperationException("TODO: This assume that E is Comparable");
        m_elements = (E[]) new Object[DEFAULT_CAPACITY];
        m_sortedList = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public CSDMinStack(Comparator<? super E> comparator)
    {
        m_comparator = comparator;
        m_elements = (E[]) new Object[DEFAULT_CAPACITY];
        m_sortedList = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public E min()
    {
        if (m_sortedList.length == 0)
            throw new EmptyStackException();

        return m_sortedList[0];
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
        removeItemFromSortedList();

        return oldObj;
    }

    public E push(E item)
    {
        capacityCheck();
        minCheck(item);
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

    public boolean empty()
    {
        return m_elementSize == 0;
    }

}
