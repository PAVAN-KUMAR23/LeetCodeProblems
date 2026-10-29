package day2;

public class AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *            Example 1:
     *            Input: l1 = [2,4,3], l2 = [5,6,4]
     *            Output: [7,0,8]
     *            Explanation: 342 + 465 = 807.
     *            Example 2:
     *            Input: l1 = [0], l2 = [0]
     *            Output: [0]
     *            Example 3:
     *            Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     *            Output: [8,9,9,9,0,0,0,1]
     */

    public static void main(String[] args) {
        ListNode l1 = buildList(2, 4, 3);
        ListNode l2 = buildList(5, 6, 4);
        ListNode result = addTwoNumbers(l1, l2);
        printList(result);

        ListNode l3= buildList(9,9,9,9,9,9,9);
        ListNode l4 = buildList(9,9,9,9);
        ListNode result2 = addTwoNumbers(l3, l4);
        printList(result2);
    }

    private static void printList(ListNode result) {
        while (result != null) {
            System.out.print(result.value);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
        System.out.println();
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.value : 0;
            int y = (q != null) ? q.value : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummyHead.next;
}
    static ListNode buildList(int... nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }
}

class ListNode {
    int value;
    ListNode next;
    ListNode(int value) {
        this.value = value;
    }

}

