package NeetCode_150;

public class Q33_Remove_nthnode_from_endoflist {
    public class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode phead= new ListNode(0);
        phead.next=head;
        ListNode curr=head;
        ListNode temp=phead;
        int len=0;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        int diff=len-n;
        int i=0;
        while(i<diff){
            temp=temp.next;
            i++;
        }

        temp.next=temp.next.next;
        return phead.next;
    }
}
