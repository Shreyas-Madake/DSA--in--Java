package NeetCode_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q63_clone_graph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Node cloneUtil(Node node, HashMap<Node,Node> mp){
        Node newNode= new Node(node.val);
        mp.put(node,newNode);

        for(Node neighbor: node.neighbors){
            if(!mp.containsKey(neighbor)){
                newNode.neighbors.add(cloneUtil(neighbor,mp));
            }else{
                newNode.neighbors.add(mp.get(neighbor));
            }
        }
        return newNode;

    }
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node,Node> mp=new HashMap<>();
        return cloneUtil(node,mp);

    }
}
