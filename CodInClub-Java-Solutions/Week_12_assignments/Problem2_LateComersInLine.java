public class Problem2_LateComersInLine {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node addFirst(Node head, String name) {
        Node node = new Node(name);
        node.next = head;
        return node;
    }

    static Node addLast(Node head, String name) {
        Node node = new Node(name);
        if (head == null) return node;
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = node;
        return head;
    }

    static Node build(String... names) {
        Node head = null;
        for (String n : names) head = addLast(head, n);
        return head;
    }

    static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) sb.append(cur.data).append(" -> ");
        System.out.println(sb + "null");
    }

    public static void main(String[] args) {
        Node line = build("Asha", "Ravi");
        line = addFirst(line, "Neha");
        line = addLast(line, "Kiran");
        line = addFirst(line, "Mohan");
        print(line);

        Node line2 = build();
        line2 = addLast(line2, "Pooja");
        line2 = addFirst(line2, "Arun");
        print(line2);
    }
}
