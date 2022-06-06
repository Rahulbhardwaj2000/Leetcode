/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size1 = getSize(headA);
        int size2 = getSize(headB);
        int diff = size1-size2;
        if(diff < 0) diff = -diff;
        
        while(size1 > size2){
            headA = headA.next;
            size1--;
        }
        
        while(size1 < size2){
            headB = headB.next;
            size2--;
        }
        
        while(headA != null && headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
    
    public int getSize(ListNode head){
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }
}