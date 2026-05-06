package org.csystem.collection;

import java.util.ArrayList;

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

/**
public class CSDStack<E> {
    public CSDStack()
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
public class CSDStack<E> {
        // rule:
        // before the derived/sub/child class constructor,
        // if there is no indication in derived class constructor,
        // base/super/parent class default constructor will call

        // here when default CSDStack is called, I need to do something like in Vector

        // v1 use ArrayList

    private ArrayList<E> m_arrayListInstance;

    public CSDStack()
    {
        m_arrayListInstance = new ArrayList<E>();
    }

    public E peek()
    {
        return m_arrayListInstance.get(m_arrayListInstance.size() - 1);
    }

    public E pop()
    {
        return m_arrayListInstance.remove(m_arrayListInstance.size() - 1);
    }

    public E push(E item)
    {
        m_arrayListInstance.add(item);
        return item;
    }

    public int search(E item)
    {
        var index = m_arrayListInstance.lastIndexOf(item);
        return index >= 0 ? m_arrayListInstance.size() - index : index;
    }
}
