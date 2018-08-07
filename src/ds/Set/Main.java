package ds.Set;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("a-tale-of-two-cities.txt",words1);
        System.out.println(words1.size());
        LinkedListSet<String> set1 = new LinkedListSet<>();
        for(String word:words1){
            set1.add(word);
        }
        System.out.println(set1.getSize());
    }
}
