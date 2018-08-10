package ds.MaxHeap;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        int n = 1000000;

        MaxHeap<Integer> maxHaep = new MaxHeap<>();
        Random random = new Random();
        for(int i = 0; i < n; i++){
            maxHaep.add(random.nextInt(100));
        }

        int[] arr = new int[n];
        for(int i =0; i<n ;i++){
            arr[i] = maxHaep.extractMax();
        }
        for(int i =1; i<n ;i++){
            if(arr[i-1] < arr[i]){
                System.out.println("Error");
            }
        }


    }
}
