package queueNstack;

import java.util.Iterator;
import collection.AbstrDoubleList;
import collection.DoubleList;

public final class AbstrLIFO<T> implements QueueStack<T> {

    private final DoubleList<T> list = new AbstrDoubleList<>();

    @Override
    public boolean jePrazdny() {
        return list.jePrazdny();
    }

    @Override
    public T odeber() {
        return list.odeberPrvni();
    }

    @Override
    public void vloz(final T data) {
        list.vlozPrvni(data);
    }

    @Override
    public void zrus() {
        list.zrus();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
