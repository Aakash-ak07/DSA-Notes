// There is a singly-linked list head and we want to delete a node node in it.

// You are given the node to be deleted node. You will not be given access to the first node of head.

// All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.

// Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

// The value of the given node should not exist in the linked list.
// The number of nodes in the linked list should decrease by one.
// All the values before node should be in the same order.
// All the values after node should be in the same order.
// Custom testing:

// For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
// We will build the linked list and pass the node to your function.
// The output will be the entire list after calling your function.
 

// Example 1:


// Input: head = [4,5,1,9], node = 5
// Output: [4,1,9]
// Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
// Example 2:


// Input: head = [4,5,1,9], node = 1
// Output: [4,5,9]
// Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
        return;      
    }
}

---------------
// 2 nd method
---------------
class Solution {
    public void deleteNode(ListNode node) {
      ListNode temp = node.next;
        node.val = temp.val;
        if(temp.next == null)
            node.next = null;
        else
            deleteNode(temp);
    }
}



//striver full solution

import java.util.*;
class Node {
        int num;
        Node next;
        Node(int a) {
            num = a;
            next = null;
        }
}
class TUF{
//function to insert node at the end of the list
  static Node insertNode(Node head,int val) {
      Node newNode = new Node(val);
      if(head == null) {
          head = newNode;
          return head;
      }
      Node temp = head;
      while(temp.next != null) temp = temp.next;
      temp.next = newNode;
      return head;
  }
  //function to get reference of the node to delete
  static Node getNode(Node head,int val) {
      if(head==null)
      return null;
      while(head.num != val) head = head.next;

      return head;
  }
  //delete function as per the question
  static void deleteNode(Node t) {
      if(t==null)
      return;
      t.num = t.next.num;
      t.next = t.next.next;
      return;
  }
  //printing the list function
  static void printList(Node head) {
      if(head==null)
      return;
      while(head.next!=null ) {
          System.out.print(head.num+"->");
          head = head.next;
      }
      System.out.println(head.num);
  }

  public static void main(String args[]) {
      Node head = null;
      //inserting node
      head=insertNode(head,1);
      head=insertNode(head,4);
      head=insertNode(head,2);
      head=insertNode(head,3);
      //printing given list
      System.out.println("Given Linked List: ");
      printList(head);
      Node t = getNode(head,2);
      //delete node
      deleteNode(t);
      //list after deletion operation
      System.out.println("Linked List after deletion: ");
      printList(head);
  }
}

// Output:

// Given Linked List:
// 1->4->2->3
// Linked List after deletion:
// 1->4->3

// Time Complexity: O(1)
