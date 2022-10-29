// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
// Example 1:
// Input: head = [1,2,2,1]
// Output: true

// Example 2:
// Input: head = [1,2]
// Output: false
 
// Constraints:
// The number of nodes in the list is in the range [1, 105].
// 0 <= Node.val <= 9

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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        
        ListNode midNode = findMid(head);       //1- find mid
        
        ListNode prev = null;                       //2- reverse 2nd half
        ListNode current = midNode;
        ListNode next;
        
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        ListNode right= prev;
        ListNode left = head;
        
        while(right != null)        //3- check right half and left half
        {
            if(left.val != right.val)
                return false;
            
            left = left.next;
            right = right.next;
        }
        return true;
    }
    
    public ListNode findMid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
