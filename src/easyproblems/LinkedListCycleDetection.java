package easyproblems;


public class LinkedListCycleDetection {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = buildListWithCycle(new int[]{3, 2, 0, -4}, 1);
        System.out.println("Test Case 1: " + hasCycle(list1) + ", Expected: true");

        System.out.println("\n========================");

        ListNode list2 = buildListWithCycle(new int[]{1, 2}, 0);
        System.out.println("Test Case 2: " + hasCycle(list2) + ", Expected: true");

        System.out.println("\n========================");

        ListNode list3 = buildListWithCycle(new int[]{1}, -1);
        System.out.println("Test Case 3: " + hasCycle(list3) + ", Expected: false");

        System.out.println("\n========================");

        ListNode list4 = buildListWithCycle(new int[]{}, -1);
        System.out.println("Test Case 4: " + hasCycle(list4) + ", Expected: false");
    }

    // Helper: builds a linked list from an int array.
    // pos = index in the array that the last node's `next` should point back to (creates a cycle).
    // pos = -1 means no cycle (last node's next stays null).
    public static ListNode buildListWithCycle(int[] values, int pos) {
        if (values.length == 0) return null;

        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
        }
        for (int i = 0; i < values.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        if (pos != -1) {
            nodes[values.length - 1].next = nodes[pos];
        }
        return nodes[0];
    }

    // Solution - O(n) time, O(1) space
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }

}