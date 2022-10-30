// Given a linked list where in addition to the next pointer, each node has a child pointer, which may or may not point to a separate list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in below figure.You are given the head of the first level of the list. Flatten the list so that all the nodes appear in a single-level linked list. You need to flatten the list in way that all nodes at first level should come first, then nodes of second level, and so on.

// Input
// User task:
// Since this is a functional problem you don't have to worry about input, you just have to complete the function flattenList() that takes the head node of the tree as input.

// Constraints:
// 1 <= N <= 100
// 1 <= Data of Nodes <= 100
// Output
// You don't need to print anything you just need to make the given head as the head of the singly linked list.
// Printing is done by the driver code
// Example
//     Sample Input:-
//     1 → 2 → 3 → 4
//     ↓   ↓   ↓
//     9 → 8   11 → 12  5 → 6 → 7
//     ↓ 
//     13 → 14 → 15

//     Sample Output:-
//     1 2 3 4 9 8 11 12 5 6 7 13 14 15

/*
class Node
{
    int data;
    Node next,Child;

    Node(int item)
    {
        data = item;
        next = Child = null;
    }
}

*/ 
static void flattenList(Node node)  
{  
    if (node == null) 
        return;
         
    Node temp = null;
    Node tail = node;
    while (tail.next != null) 
    {
        tail = tail.next;
    }

    Node current = node;
    while (current != tail) {

        if (current.Child != null) {

            tail.next = current.Child;

            temp = current.Child;
            while (temp.next != null) {
                temp = temp.next;
            }
            tail = temp;
        }
        current = current.next;
    }
}
