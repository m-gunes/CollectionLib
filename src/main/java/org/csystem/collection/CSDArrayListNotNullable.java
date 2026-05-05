package org.csystem.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;


/**
 * Sınıf Çalışması:
 * <p>
 * null değeri tutulamayan yani null değeri eklenmeye çalışıldığında IllegalArgumentException fırlatan CSDArrayListNotNullable collection sınıfını yazınız
 *
 * <p><p>
 * Açıklamalar:
 *
 * <p>Bu collection sınıfı ArrayList sınıfından türetilecektir.
 * <p>Çoklu veri eklemede bir tane bile null değer varsa yine ekleme yapılmayacak ve exception fırlatılacaktır.
 * <p>Sınıfın ArrayList sınıfının içerisinde bulunan tüm ctor'ları da olacaktır.
 */
// ekleme yapan metodlari override etmeniz lazim.
// Yani add metotlari override edilecek, set gibi yani eleman ekleyebilen metotlari override edip,
// bu metotlarin null degeri almasi durumundaki ilgili islemleri yapacaksiniz


public class CSDArrayListNotNullable<E> extends ArrayList<E> {
    public CSDArrayListNotNullable(int initialCapacity)
    {
        super(initialCapacity);
    }

    public CSDArrayListNotNullable()
    {
        // otomatik yapilacak, sadece var olmasi icin icini bos biraktik
    }

    public CSDArrayListNotNullable(Collection<? extends E> c)
    {
        // throw new UnsupportedOperationException("TODO:");
        nullCheck(c);
        //...
        // Todo: completed
    }

    private void nullCheck(E element)
    {
        if (element == null)
            throw new IllegalArgumentException("Null value is not acceptable");
    }

    private void nullCheck(Collection<? extends E> elements)
    {
        elements.forEach(this::nullCheck);
    }

    @Override
    public E set(int index, E element)
    {
        nullCheck(element);
        return super.set(index, element);
    }

    @Override
    public boolean add(E e)
    {
        nullCheck(e);
        return super.add(e);
    }

    @Override
    public void add(int index, E element)
    {
        nullCheck(element);
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        nullCheck(c);
        return super.addAll(c);
    }

    // Since null is not exist in the list, we should check if null is searched by user
    // Question is throwing exception is correct in this case?
    // arama null yapiliyor diye exeption firlatmak mantikli olmaz gibi.
    // bunun yerine eger deger null ise donguye girmeden direct -1 donen bir method mantikli olur mu?
    // yani donguye girmeden sonucu olumsuz donmek eger deger null ise
    @Override
    public int indexOf(Object o)
    {
        // indexOf also looks for null if it exists in list. Since we are not allow null value, we need to override here.
//        nullCheck((E) o);
        if (o == null)
            return -1;

        return super.indexOf(o);
    }

    @Override
    public boolean contains(Object o)
    {
        // contains calls indexOf, so we need to override
        // nullCheck((E) o);
        if (o == null)
            return false;

        return super.contains(o);
    }

    @Override
    public int lastIndexOf(Object o)
    {
        // it looks null value.
        // nullCheck((E)o);

        if (o == null)
            return -1;

        return super.lastIndexOf(o);
    }

    /**
     * @param o element to be checked, if null
     */
    @Override
    public boolean remove(Object o)
    {
        if (o == null)
            return false;

        return super.remove(o);
    }

    // Todo: burada bir liste tutulmali mi?
    // cevap: hocanin ctor da super(initialCapacity) 'i kullanmasi aslinda ArrayListing icerisinde list tutulmasi gerektigini gosteriyor.


}
