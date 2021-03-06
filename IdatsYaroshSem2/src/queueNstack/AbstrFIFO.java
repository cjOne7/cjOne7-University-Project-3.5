package queueNstack;

import collection.AbstrDoubleList;
import collection.DoubleList;
import java.util.Iterator;

public final class AbstrFIFO<T> implements QueueStack<T> {

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
        if (data == null){
            throw new NullPointerException();
        }
        list.vlozPosledni(data);
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
