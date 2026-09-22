/*
 * Problem: 
--
 *
 * Given the head of a linked list, remove the nth node from the end of 
 * the list and return its head.
 *
 * Constraint: Can you do this in a single pass?
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * 
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Main {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        int counter = 0;
        while(fast != null){
            fast = fast.next;

            if(counter >= n){
                prev = slow;
                slow = slow.next;
            }

            counter++;
        }


        if(prev == null){
            return head.next;
        }

        prev.next = slow.next;
        
        return head;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
// Test cases: [1,2], n = 2; [1,2,3], n = 4; [1,2,3,4,5], n =2