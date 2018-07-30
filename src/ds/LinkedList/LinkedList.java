package ds.LinkedList;

public interface LinkedList<E> {
    boolean isEmpty();
    int getSize();
    void add(int index, E e);
    E get(int index);
    boolean contains(E e);
    E remove(int index);
}
