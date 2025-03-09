package hw1;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // Iterative approach to reverse a linked list
    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev; // New head of the reversed list
    }

    // Recursive approach to reverse a linked list
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // Helper method to print the list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        printList(head);

        // Test Iterative approach
        ListNode reversedIterative = reverseListIterative(head);
        System.out.println("Reversed list (Iterative):");
        printList(reversedIterative);

        // Reversing back to original for recursive test
        ListNode reversedBack = reverseListRecursive(reversedIterative);
        System.out.println("Reversed list (Recursive):");
        printList(reversedBack);
    }
}
