package ds.LinkedList;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node dummyHead;  // 虚拟头结点
    private int size;
    public SinglyLinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {


        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;


    }

    //在链表头添加元素e
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        head = new Node(e,head); //优雅~
//        size ++;
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node curNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node curNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        curNode.e = e;
    }

    public boolean contains(E e) {
        Node curNode = dummyHead.next;
        while (curNode != null) {
            if (curNode.e.equals(e)) {
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        if (isEmpty()) {
            throw new IllegalArgumentException("Remove failed. LinkedList is empty.");
        }
        Node prevNode = dummyHead;
        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
        }
        Node retNode = prevNode.next;
        prevNode.next = retNode.next;
        size--;
        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node curNode = dummyHead.next;
        res.append("null->");
        while (curNode != null) {
            res.append(curNode + "->");
            curNode = curNode.next;
        }
        res.append("null");

        return res.toString();
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

}
