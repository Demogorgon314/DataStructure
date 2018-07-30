package ds.TestUtil;

import ds.Queue.ArrayQueue;
import ds.Queue.LinkedListQueue;
import ds.Queue.LoopQueue;
import ds.Queue.Queue;

import java.util.LinkedList;
import java.util.Random;

public class TestQueue {
    private static double testQueue(Queue<Integer> q, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }

    private static double testSystemQueue(java.util.Queue<Integer> q, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.offer(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.poll();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {
        int opCount = 100000;

        for (int i = 1; i <= 10; i++) {
            System.out.println("------------第 " + i + " 次----------------");
            LoopQueue<Integer> loopQueue = new LoopQueue<>();
            double time2 = testQueue(loopQueue, opCount);
            System.out.println("LoopQueue, time: " + time2 + "s");

            LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
            double time4 = testQueue(linkedListQueue, opCount);
            System.out.println("LinkedListQueue, time: " + time4 + "s");

            java.util.Queue<Integer> javaQueue = new LinkedList<Integer>();
            double time3 = testSystemQueue(javaQueue, opCount);
            System.out.println("JavaQueue, time: " + time3 + "s");


            ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
            double time1 = testQueue(arrayQueue, opCount);
            System.out.println("ArrayQueue, time: " + time1 + "s");

            System.out.println("LoopQueue : 1" + " ,JavaQueue: " + time3 / time2 + " ,ArrayQueue: " + time1 / time2);
        }


    }

}
