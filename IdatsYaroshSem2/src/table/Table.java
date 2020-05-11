package table;

import collection.KolekceException;
import java.util.Iterator;

public interface Table<K extends Comparable<K>, V> extends Iterable<V> {

    void zrus();

    boolean jePrazdny();

    int mohutnost();

    V najdi(K key);

    void vloz(K key, V value) throws KolekceException;

    V odeber(K key) throws IllegalAccessException;

    Iterator<V> vytvorIterator(TypProhlidky typ);
}
