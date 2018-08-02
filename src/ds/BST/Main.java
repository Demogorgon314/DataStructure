package ds.BST;
import com.sun.javafx.collections.MappingChange.Map;
public class Main {
    public static void main(String[] args){
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,4,8,2};
        for(int num : nums){
            bst.add(num);
        }
        bst.preOrder();
//        bst.preOrderNR();
//        System.out.println();
//        bst.inOrder();
//        bst.postOrder();
//        System.out.println();
//        bst.levelOrder();
//        System.out.println();
//        System.out.println(bst);
        bst.removeMax();
        bst.preOrder();
        bst.remove(2);
        bst.preOrder();

    }
}
