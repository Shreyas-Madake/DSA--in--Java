package NeetCode_150;

import java.util.HashMap;
import java.util.Map;

public class Q34_Copy_Listwith_RandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Map<Node,Node> map=new HashMap<>();
        Node newhead=new Node(head.val);
        map.put(head,newhead);
        Node curr=head,
                newcurr = newhead;
        while(curr!=null){
            if(curr.random!=null){
                if(map.get(curr.random)!=null){
                    newcurr.random=map.get(curr.random);
                }
                else{
                    Node node=new Node(curr.random.val);
                    map.put(curr.random,node);
                    newcurr.random=node;
                }
            }

            if(curr.next!=null){
                if(map.get(curr.next)!=null){
                    newcurr.next=map.get(curr.next);
                }
                else{
                    Node node=new Node(curr.next.val);
                    map.put(curr.next,node);
                    newcurr.next=node;
                }
            }
            curr=curr.next;
            newcurr=newcurr.next;
        }
        return newhead;


    }
}
