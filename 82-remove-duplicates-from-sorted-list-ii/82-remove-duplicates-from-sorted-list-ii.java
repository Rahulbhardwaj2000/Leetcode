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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-200);
        dummy.next = head;
        ListNode temp = head, prev = dummy;
        while(temp != null){
            while(temp.next != null && temp.val == temp.next.val){
                temp = temp.next;
            }
            if(prev.next != temp){ // means temp travelled ahead on finding duplicate
                prev.next = temp.next;
            }else{
                prev = prev.next;
            }
            temp = temp.next;
        }
        
        return dummy.next;
    }
}