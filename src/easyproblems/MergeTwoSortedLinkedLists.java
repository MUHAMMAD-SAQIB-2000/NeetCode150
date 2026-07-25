package easyproblems;

public class MergeTwoSortedLinkedLists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, easyproblems.MergeTwoSortedLinkedLists.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode list1a = buildList(new int[]{1, 2, 4});
        ListNode list1b = buildList(new int[]{1, 3, 5});
        System.out.println("Test Case 1: " + toString(mergeTwoLists(list1a, list1b)) + ", Expected: [1,1,2,3,4,5]");

        System.out.println("\n========================");

        ListNode list2a = buildList(new int[]{});
        ListNode list2b = buildList(new int[]{1, 2});
        System.out.println("Test Case 2: " + toString(mergeTwoLists(list2a, list2b)) + ", Expected: [1,2]");

        System.out.println("\n========================");

        ListNode list3a = buildList(new int[]{});
        ListNode list3b = buildList(new int[]{});
        System.out.println("Test Case 3: " + toString(mergeTwoLists(list3a, list3b)) + ", Expected: []");
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

    // O(n+m) time, O(1) extra space
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if(list1 != null) tail.next = list1;
        if(list2 != null) tail.next = list2;
        return dummy.next;
    }
}
