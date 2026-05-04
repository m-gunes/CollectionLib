package org.csystem.collection;

import java.util.Comparator;


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

import java.util.Comparator;

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
