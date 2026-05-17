package org.csystem.collection;

import java.util.*;

public class CSDQueue2<E> implements Queue {
    private List<E> m_arrayList;

    public CSDQueue2()
    {
        m_arrayList = new ArrayList<E>();
    }

    @Override
    public int size()
    {
        return m_arrayList.size();
    }

    @Override
    public boolean isEmpty()
    {
        return m_arrayList.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return m_arrayList.contains(o);
    }

    @Override
    public Iterator iterator()
    {
        return m_arrayList.iterator();
    }

    @Override
    public Object[] toArray()
    {
        return m_arrayList.toArray();
    }

    @Override
    public Object[] toArray(Object[] a)
    {
        return m_arrayList.toArray(a);
    }

    @Override
    public boolean add(Object o)
    {
        return m_arrayList.add((E) o);
    }

    @Override
    public boolean remove(Object o)
    {
        return m_arrayList.remove(o);
    }

    @Override
    public boolean addAll(Collection c)
    {
        return m_arrayList.addAll(c);
    }

    @Override
    public void clear()
    {
        m_arrayList.clear();
    }

    @Override
    public boolean retainAll(Collection c)
    {
        return  m_arrayList.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c)
    {
        return removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c)
    {
        return m_arrayList.containsAll(c);
    }

    @Override
    public boolean offer(Object o)
    {
        return add(o);
    }

    @Override
    public Object remove()
    {
        var obj = element();
        m_arrayList.remove(0);

        return obj;
    }

    @Override
    public Object poll()
    {
        var obj = peek();
        m_arrayList.remove(0);

        return obj;
    }

    @Override
    public Object element()
    {
        if (m_arrayList.isEmpty())
            throw new NoSuchElementException();

        return m_arrayList.get(0);
    }

    @Override
    public Object peek()
    {
        if (m_arrayList.isEmpty())
            return null;

        return m_arrayList.get(0);
    }

}
