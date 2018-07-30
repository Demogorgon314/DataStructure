package ds.BST;

/**
 * 这个二分搜索树不包含相同元素
 * @param <E>
 */
public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }


    }
    private Node root;
    private int size;
    public BST(){
        root = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 添加一个新的元素
     * @param e
     */
    public void add(E e){
//        if(root == null){
//            root = new Node(e);
//            size ++;
//        }else
        root = add(root,e);


    }

    /**
     * 返回插入新节点后的二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node, E e){
//        if(e.equals(node.e)){
//            return;
//        }else if(e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size ++;
//            return;
//        }else if(e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
        if(node == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){
            node.left  = add(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }

}
