package ds.Set;

import ds.LinkedList.LinkedList;
import ds.LinkedList.SinglyLinkedList;

public class LinkedListSet<E> implements Set<E> {
    private SinglyLinkedList<E> list;

    LinkedListSet(){
        list = new SinglyLinkedList<E>();
    }
    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
