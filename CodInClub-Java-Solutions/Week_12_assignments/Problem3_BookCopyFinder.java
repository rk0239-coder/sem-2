public class Problem3_BookCopyFinder {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static String find(Node head, String id) {
        int position = 0, copies = 0, first = -1;
        for (Node cur = head; cur != null; cur = cur.next) {
            position++;
            if (cur.data.equals(id)) {
                copies++;
                if (first == -1) first = position;
            }
        }
        if (copies == 0) return id + " not found";
        return id + " first at position " + first + ", copies: " + copies;
    }

    static Node build(String... ids) {
        Node head = null, tail = null;
        for (String s : ids) {
            Node node = new Node(s);
            if (head == null) head = node;
            else tail.next = node;
            tail = node;
        }
        return head;
    }

    public static void main(String[] args) {
        Node trolley = build("B12", "B07", "B30", "B07", "B45", "B07");
        System.out.println(find(trolley, "B07"));
        System.out.println(find(trolley, "B99"));
    }
}
