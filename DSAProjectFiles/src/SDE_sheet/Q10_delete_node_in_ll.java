package SDE_sheet;

public class Q10_delete_node_in_ll {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;

    }
}
