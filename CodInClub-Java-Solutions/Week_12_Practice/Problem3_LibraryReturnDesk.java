import java.util.Scanner;

class Pile {
    private final String[] items = new String[3];
    private int top = -1;

    String push(String book) {
        if (top == items.length - 1) return book + " rejected: pile is full";
        items[++top] = book;
        return book + " placed on pile";
    }

    String pop() {
        if (top == -1) return "pile is empty";
        return "shelved " + items[top--];
    }
}

class Line {
    private final String[] items = new String[3];
    private int front = 0, rear = -1, size = 0;

    String enqueue(String name) {
        if (size == items.length) return name + " rejected: line is full";
        rear = (rear + 1) % items.length;
        items[rear] = name;
        size++;
        return name + " joined the line";
    }

    String dequeue() {
        if (size == 0) return "no one waiting";
        String name = items[front];
        front = (front + 1) % items.length;
        size--;
        return "served " + name;
    }
}

public class Problem3_LibraryReturnDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pile pile = new Pile();
        Line line = new Line();
        while (sc.hasNext()) {
            String cmd = sc.next().replace(",", "");
            if (cmd.equals("RETURN")) {
                System.out.println(pile.push(sc.next().replace(",", "")));
            } else if (cmd.equals("SHELVE")) {
                System.out.println(pile.pop());
            } else if (cmd.equals("WAIT")) {
                System.out.println(line.enqueue(sc.next().replace(",", "")));
            } else if (cmd.equals("SERVE")) {
                System.out.println(line.dequeue());
            }
        }
    }
}
