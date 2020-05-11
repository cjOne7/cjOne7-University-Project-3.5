package queueNstack;

public interface QueueStack<T> extends Iterable<T> {

    /**
     * test, zda seznam prázdný
     *
     * @return Vrací true, když seznam je prázdný.
     */
    boolean jePrazdny();

    /**
     *
     * @return Reference na odebraný datový element v seznamu.
     */
    T odeber();

    /**
     *
     * @param data Reference na datový element, který se vloží do seznamu.
     */
    void vloz(T data);

    /**
     * Metoda zruší obsah celého seznamu.
     */
    void zrus();
}
