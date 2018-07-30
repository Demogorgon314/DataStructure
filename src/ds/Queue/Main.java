package ds.Queue;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        queue.dequeue();
        System.out.println(queue);
        System.out.println("-------------------------------------------------");
        LoopQueue<Integer> integerLoopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            integerLoopQueue.enqueue(i);
            System.out.println(integerLoopQueue);
            if (i % 3 == 2) {
                integerLoopQueue.dequeue();
                System.out.println(integerLoopQueue);
            }
        }
        integerLoopQueue.dequeue();
        System.out.println(integerLoopQueue);
    }
}
