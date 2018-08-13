package ds.SegmentTree;

public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger; // 两个节点融合的方式
    public SegmentTree(E[] arr, Merger<E> merger){
        data = (E[])new Object[arr.length];
        this.merger = merger;
        for(int i = 0; i<arr.length; i++){
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length]; // 4n
        buildSegmentTree(0,0,data.length - 1); //递归实现 根据data中的数据填充tree(创建线段树)
    }
    // 在treeIndex的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r){
        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }
    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length){
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    /**
     * 输入index 返回 该index的左孩子index
     * @param index 当前index
     * @return index的左孩子节点的index
     */
    private int leftChild(int index){
        return 2 * index + 1;
    }

    /**
     * 输入index 返回 该index的右孩子index
     * @param index 当前index
     * @return index的右孩子节点的index
     */
    private int rightChild(int index){
        return 2 * index + 2;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');

        for(int i = 0; i < tree.length; i++){
            if(tree[i] != null){
                res.append(tree[i]);
            }else{
                res.append("null");
            }

            if(i != tree.length - 1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

}
