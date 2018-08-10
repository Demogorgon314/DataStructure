package ds.MaxHeap;

import ds.Array.Array;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);

    }
    public MaxHeap(){
        data = new Array<>();
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     * @param index
     * @return
     */
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("index-0 doesn't hava parent.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }
    private int rightChild(int index){
        return index * 2 + 2;
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index){
        while(index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0){  // 比较 交换
            data.swap(index,parent(index));
            index = parent(index);
        }
    }

    public E findMax(){
        if(data.isEmpty()){
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }
    public E extractMax(){
        E ret = findMax();

        data.swap(0,data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }
    private void siftDown(int index){
        while(leftChild(index) < data.getSize()){
            int j = leftChild(index);
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
                j++; // 相当于 j = rightChild(k);

            }
            if(data.get(index).compareTo(data.get(j)) >= 0){
                break;
            }
            data.swap(index,j);
            index = j;
        }
    }





}
