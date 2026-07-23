package SDE_sheet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q21_LRU_Cache {

    private int  capacity;
    private Map<Integer,requirement> map;
    private LinkedList<requirement> ll;

    private class requirement{
        int key;
        int value;
        public requirement(int key,int value){
            this.key=key;
            this.value=value;
        }

    }
    public Q21_LRU_Cache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        ll=new LinkedList<>();

    }

    public int get(int key) {
        if(map.containsKey(key)){
            requirement node=map.get(key);// to store from the map
            ll.remove(node);
            ll.addFirst(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            requirement node=map.get(key);
            ll.remove(node);
            node.value=value;
            ll.addFirst(node);
        }
        else{
            if(map.size()>=capacity){
                requirement node=ll.removeLast();
                map.remove(node.key);

            }
            requirement node=new requirement(key,value);
            ll.addFirst(node);
            map.put(key,node);
        }
    }
}
