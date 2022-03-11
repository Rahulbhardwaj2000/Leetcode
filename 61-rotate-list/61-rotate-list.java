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
    public ListNode rotateRight(ListNode head, int k) {
        // All in all, we need 3 pointers and size of linked list here, at positions
        // At last, at (size-k), and at (size-k)+1 positions (not index)
        if(head == null || head.next == null) return head;
        
        int s =1;
        ListNode temp = head; // temp stops at the last element
        while(temp.next != null){
            temp = temp.next;
            s++;
        }
        
        k = k%s;
        if(k == 0) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        int i=s-k;
        while(i > 0){
            prev = curr;
            curr = curr.next;
            i--;
        }
        
        prev.next = null;
        temp.next = head;
        head = curr;
        
        return head;
    }
    
    
    
}