package org.csystem.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Sınıf Çalışması: </br>
 * Yalnızca Object sınıfından türetilen ve dinamik olarak büyüyebilen aşağıdaki CSDStack sınıfını yazınız.
 *
 * </br>
 * <strongAçıklamalar:</strong> </br>
 *
 * <ul>
 *      <li>Sınıfın public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz</li>
 *      <li>JavaSE'nin Stack<E> sınıfı kullanılmayacaktır.</li>
 * </ul>
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

    private final List<E> m_list;

    public CSDStack()
    {
        m_list = new ArrayList<E>();
    }

    public E peek()
    {
        return m_list.get(m_list.size() - 1);
    }

    public E pop()
    {
        return m_list.remove(m_list.size() - 1);
    }

    public E push(E item)
    {
        m_list.add(item);
        return item;
    }

    public int search(E item)
    {
        var index = m_list.lastIndexOf(item);
        return index >= 0 ? m_list.size() - index : index;
    }
}
