public class Problem4_CancelBooking {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }
        if (head.data.equals(booking)) return head.next;
        Node cur = head;
        while (cur.next != null && !cur.next.data.equals(booking)) cur = cur.next;
        if (cur.next == null) {
            System.out.println(booking + " not found");
        } else {
            cur.next = cur.next.next;
        }
        return head;
    }

    static Node build(String... items) {
        Node head = null, tail = null;
        for (String s : items) {
            Node node = new Node(s);
            if (head == null) head = node;
            else tail.next = node;
            tail = node;
        }
        return head;
    }

    static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) sb.append(cur.data).append(" -> ");
        System.out.println(sb + "null");
    }

    public static void main(String[] args) {
        print(removeFirst(build("104", "101", "107", "101"), "101"));
        print(removeFirst(build("104", "101", "107"), "104"));
        print(removeFirst(build("104", "101"), "200"));
    }
}
