package ds.BST;

import ds.Queue.LinkedListQueue;
import ds.Queue.Queue;
import ds.Stack.LinkedListStack;
import ds.Stack.Stack;

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
    public boolean contains(E e){
        return contains(root,e);
    }
    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }

    }

    public void preOrder(){
        preOrder(root);//
        System.out.println();
    }
    // 前序遍历 递归实现 mid left right
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.e);
        System.out.print(" ");

        preOrder(node.left);
        preOrder(node.right);
    }
    public void preOrderNR(){
        LinkedListStack<Node> stack = new LinkedListStack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.print(cur.e);
            System.out.print(" ");

            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    // 中序遍历 递归实现 left mid right 排序好的树
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.e);
        System.out.print(" ");
        inOrder(node.right);

    }

    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    // 后序遍历 递归实现 left right mid  释放内存用后序比较好
    public void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e);
        System.out.print(" ");

    }
    public void levelOrder(){
        Queue<Node> q = new LinkedListQueue<>();
        q.enqueue(root);
        while(!q.isEmpty()){
            Node cur = q.dequeue();
            System.out.print(cur.e);
            System.out.print(" ");

            if(cur.left != null){
                q.enqueue(cur.left);
            }
            if(cur.right != null){
                q.enqueue(cur.right);
            }

        }
    }
    // 获取最小值
    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }
    // 获取最大值
    public E maximum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
    }
    public E removeMin(){
        E ret = minimum();
        // 移除
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉与node为根的二分搜索树中的最小节点
     * @param node
     * @return 删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    public E removeMax(){
        E ret = maximum();
        // 移除
        root = removeMax(root);
        return ret;
    }
    /**
     * 删除掉与node为根的二分搜索树中的最小节点
     * @param node
     * @return 删除节点后新的二分搜索树的根
     */
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(root,e);
    }

    /**
     * 删除以node
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node,E e){
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }else{
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点，既待删除节点右子树的最小节点
            // 找这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }


    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth)+"null \n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);

    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i< depth; i++){
            res.append("--");
        }
        return res.toString();
    }
}
