/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode d = new ListNode(-1);
        ListNode head = d;
        
        while(l1 != null || l2 != null || c!=0){
            int sum = c;
            sum += (l1 != null ? l1.val : 0);
            sum += (l2 != null ? l2.val : 0);
            c = sum/10;
            
            d.next = new ListNode(sum%10);
            d = d.next;
            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
        }
        
        return head.next;
    }
}