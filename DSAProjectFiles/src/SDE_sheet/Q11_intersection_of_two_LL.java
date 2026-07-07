package SDE_sheet;

public class Q11_intersection_of_two_LL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Handle empty lists
        if (headA == null || headB == null) return null;

        ListNode tempa = headA;
        ListNode tempb = headB;

        while (tempa != tempb) {
            // If tempa reaches the end, switch to headB; otherwise, move to next
            tempa = (tempa == null) ? headB : tempa.next;

            // If tempb reaches the end, switch to headA; otherwise, move to next
            tempb = (tempb == null) ? headA : tempb.next;
        }

        // This will return either the intersection node or null if they don't intersect
        return tempa;
    }
}
