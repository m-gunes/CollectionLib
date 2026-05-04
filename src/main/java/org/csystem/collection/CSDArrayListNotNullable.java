package org.csystem.collection;

import java.util.ArrayList;
import java.util.Collection;


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
        throw new UnsupportedOperationException("TODO:");
    }
}
