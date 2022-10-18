// Given the head of a linked list, rotate the list to the right by k places.
// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

// Input: head = [0,1,2], k = 4
// Output: [2,0,1]

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
        if(k <= 0 || head == null || head.next == null)  return head;
        
        int size = 1;
        ListNode last = head;
        
        while(last.next != null)
        {
            last = last.next;
            size++;
        }
        last.next = head;
        int rotation = k % size;
        
        int skip = size - rotation;
        
        ListNode lastNew = head;
        for(int i = 0; i < skip-1; i++)
        {
            lastNew = lastNew.next;
        }
        head = lastNew.next;        // Now Pointing , new Last to new head;
        lastNew.next = null;        // At last put new last point to null
        
        return head;
    }
}
