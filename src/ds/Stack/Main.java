package ds.Stack;

import java.util.Random;

public class Main {
    private static double testQueue(Stack<Integer> stack, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }
    public static void main(String[] args) {
//        LinkedListStack<Integer> stack = new LinkedListStack<>();
//
//        for (int i = 0; i < 5; i++) {
//            stack.push(i);
//            System.out.println(stack);
//        }
//
//        stack.pop();
//        System.out.println(stack);

        // 性能测试
        int opCount = 1000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testQueue(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + "s");
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testQueue(linkedListStack, opCount);
        System.out.println("linkedListStack, time: " + time2 + "s");
    }
}
