package ds.Array;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        System.out.println("test");
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
//        arr.add(1, 100);
//        System.out.println(arr);
//        arr.addFirst(-1);
//        System.out.println(arr);
//        arr.remove(2);
//        System.out.println(arr);
//        arr.removeElement(4);
//        System.out.println(arr);
        for (int i = 10; i < 20; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        for (int i = 0; i < 10; i++) {
            arr.removeLast();
        }
        System.out.println(arr);

    }
}
