// Problem: Reverse a Linked List

// Given the head of a singly linked list, reverse the list, and return the reversed list.

// Constraint: Solve this using a recursive approach to hit that interview requirement.

// Example 1:

// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]

// Example 2:

// Input: head = [1,2]
// Output: [2,1]

// Example 3:

// Input: head = []
// Output: []

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Main {
	public ListNode reverse(ListNode head){
        return recursion(head, null);
    }

    private ListNode recursion(ListNode curr, ListNode prev){
        if(curr == null){
            return prev;
        }
        
        ListNode next = curr.next;
        curr.next = prev;
        return recursion(next, curr);
    }
}

// Time complexity: O(n)
// Space complexity: O(n)
// Test cases: [], [1,1,1], [1,2,3,4,5]