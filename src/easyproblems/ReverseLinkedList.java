package easyproblems;

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = buildList(new int[]{1, 2, 3, 4});
        System.out.println("Test Case 1: " + toString(reverseList(list1)) + ", Expected: [4,3,2,1]");

        System.out.println("\n========================");

        ListNode list2 = buildList(new int[]{1, 2});
        System.out.println("Test Case 2: " + toString(reverseList(list2)) + ", Expected: [2,1]");

        System.out.println("\n========================");

        ListNode list3 = buildList(new int[]{});
        System.out.println("Test Case 3: " + toString(reverseList(list3)) + ", Expected: []");
    }

    // Helper: builds a linked list from an int array
    public static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper: converts a linked list to a readable string like [1,2,3]
    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) sb.append(",");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // O(n) time and O(1) space
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        while(curr != null){

            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;

        }
        return prev;
    }

}
