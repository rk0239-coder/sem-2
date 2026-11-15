public class Problem1_BusRouteStops {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node build(String[] stops) {
        Node head = null, tail = null;
        for (String s : stops) {
            Node node = new Node(s);
            if (head == null) head = node;
            else tail.next = node;
            tail = node;
        }
        return head;
    }

    static void printRoute(Node head) {
        int count = 0;
        Node last = null;
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
            count++;
            last = cur;
        }
        sb.append("null");
        System.out.println(sb);
        if (head != null) {
            System.out.println("Stops: " + count + ", First: " + head.data + ", Last: " + last.data);
        }
    }

    public static void main(String[] args) {
        printRoute(build(new String[]{"Tambaram", "Guindy", "TNagar", "Central"}));
        printRoute(build(new String[]{"Potheri"}));
    }
}
