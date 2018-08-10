package ds.Map;

import ds.Set.FileOperation;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words);
        System.out.println(words.size());

//        LinkedListMap<String, Integer> map = new LinkedListMap<>();
        Map<String, Integer> map = new BSTMap<>();
        for(String word: words){
            if(map.contains(word)){
                map.set(word,map.get(word) + 1);
            }else{
                map.add(word,1);
            }
        }
        System.out.println(map.get("pride"));
        System.out.println(map.get("this"));
        System.out.println(map.get("the"));
        System.out.println(map.get("me"));
//        for(String key:map.keySet()){
//            System.out.println(key+" : "+map.get(key));
//        }




    }
}
