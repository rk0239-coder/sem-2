public class Problem5_PlateStack {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static class PlateStack {
        private Node top;
        private int size;

        void push(String plate) {
            Node node = new Node(plate);
            node.next = top;
            top = node;
            size++;
        }

        String pop() {
            if (isEmpty()) return null;
            String plate = top.data;
            top = top.next;
            size--;
            return plate;
        }

        String peek() {
            return isEmpty() ? null : top.data;
        }

        boolean isEmpty() {
            return top == null;
        }

        int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        String[] ops = {"push P1", "push P2", "peek", "pop", "push P3", "pop", "pop", "pop", "isEmpty"};
        PlateStack stack = new PlateStack();
        for (String op : ops) {
            String[] parts = op.split(" ");
            switch (parts[0]) {
                case "push":
                    stack.push(parts[1]);
                    System.out.println("push " + parts[1] + " -> top " + stack.peek() + ", size " + stack.size());
                    break;
                case "pop":
                    String p = stack.pop();
                    if (p == null) System.out.println("pop -> stack is empty");
                    else System.out.println("pop -> " + p + ", size " + stack.size());
                    break;
                case "peek":
                    String t = stack.peek();
                    System.out.println("peek -> " + (t == null ? "stack is empty" : t));
                    break;
                case "isEmpty":
                    System.out.println("isEmpty -> " + stack.isEmpty());
                    break;
            }
        }
    }
}
