/*
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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right) {
            return head;
        }

        // Dummy node handles the case when left == 1
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Node before the left position
        ListNode leftNode = dummy;

        // Move leftNode to one node before 'left'
        for (int i = 1; i < left; i++) {
            leftNode = leftNode.next;
        }

        // First node of the portion to reverse
        ListNode curr = leftNode.next;

        // Reverse nodes from left to right
        for (int i = 0; i < right - left; i++) {

            ListNode nextNode = curr.next;

            curr.next = nextNode.next;

            nextNode.next = leftNode.next;

            leftNode.next = nextNode;
        }

        return dummy.next;
    }
}