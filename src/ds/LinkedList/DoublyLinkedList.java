package ds.LinkedList;

public class DoublyLinkedList<E> implements LinkedList<E> {
    private class Node{
        E e;
        Node next, prev;
        public Node(E e, Node prev, Node next){
            this.e = e;
            this.prev = prev;
            this.next = next;
        }
        public Node(){
            this(null,null,null);
        }
        public Node(E e){
            this(e,null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node dummyHead,dummyTail;
    private int size;

    /**
     * 加了一个虚拟头结点 and 虚拟尾节点
     */
    public DoublyLinkedList(){
        dummyHead = new Node(null,null,new Node());
        dummyTail = dummyHead.next;
        dummyTail.prev = dummyHead;
//        dummyTail = new Node();
        size = 0;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void add(int index, E e) {
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
//        if(index == 0){
//            dummyHead.next = new Node(e,dummyHead,dummyHead.next);
//            dummyHead.next.next;
//            return;
//        }
        if(index == size){
            dummyTail.prev = new Node(e,dummyTail.prev,dummyTail);
            dummyTail.prev.prev.next = dummyTail.prev;
            size ++;
            return;
        }
        Node prevNode = dummyHead;
        for(int i = 0;i<index;i++){
            prevNode = prevNode.next;
        }
        prevNode.next = new Node(e,prevNode,prevNode.next);
        prevNode.next.next.prev = prevNode.next;
        size ++;
    }
    public void addFirst(E e){
        add(0,e);
    }
    public void addLast(E e){
        add(size,e);
    }
    @Override
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        if(index == size - 1){
            return dummyTail.prev.e;
        }
        Node curNode = dummyHead.next;
        for(int i = 0; i< index; i++){
            curNode = curNode.next;
        }

        return curNode.e;
    }
    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size - 1);
    }
    /**
     * 判断是否存在这个元素
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {
        Node curNode = dummyHead.next;
        while(curNode.next != null){
            if(curNode.e.equals(e)){
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        if (isEmpty()) {
            throw new IllegalArgumentException("Remove failed. LinkedList is empty.");
        }
        if(index == size-1){
            Node remNode = dummyTail.prev;
            dummyTail.prev = remNode.prev;
            remNode.prev.next = dummyTail;
            E ret = remNode.e;
            remNode = null;
            size--;
            return ret;
        }
        Node curNode = dummyHead.next;

        for(int i = 0; i< index; i++){
            curNode = curNode.next;
        }
        E ret = curNode.e;
        curNode.prev.next = curNode.next;
        curNode.next.prev = curNode.prev;
        curNode = null;
        size --;
        return ret;
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("DoublyLinkedList: ");
        res.append("Size: ");
        res.append(getSize());
        res.append("\n");
        res.append("dummyHead<-> ");
        Node curNode = dummyHead.next;
        while(curNode.next != null){
            res.append(curNode.e);
            if(curNode.next.next != null){
                res.append(" <-> ");
            }
            curNode = curNode.next;
        }
        res.append(" <->dummyTail");
        return res.toString();
    }
    public static void main(String[] args){
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
//        doublyLinkedList.addLast(1);
//        System.out.println(doublyLinkedList);
//        doublyLinkedList.addFirst(2);
//        System.out.println(doublyLinkedList);
        for (int i = 0;i<10;i++){
            doublyLinkedList.addLast(i);
            System.out.println(doublyLinkedList);
        }
//        doublyLinkedList.add(4,1000);
//        System.out.println(doublyLinkedList);
//        System.out.println(doublyLinkedList.contains(null));
//        doublyLinkedList.removeFirst();
//        System.out.println(doublyLinkedList);
//        doublyLinkedList.removeLast();
//        System.out.println(doublyLinkedList);
//        doublyLinkedList.remove(4);
//        System.out.println(doublyLinkedList);
//        doublyLinkedList.addLast(100);
//        System.out.println(doublyLinkedList);
//        doublyLinkedList.removeLast();
//        System.out.println(doublyLinkedList);
//        doublyLinkedList.addLast(1);
        doublyLinkedList.removeLast();
//        doublyLinkedList.removeLast();
        System.out.println(doublyLinkedList);
//        System.out.println(doublyLinkedList.getFirst());
//        System.out.println(doublyLinkedList.getLast());
//        System.out.println(doublyLinkedList.get(3));


    }
}
