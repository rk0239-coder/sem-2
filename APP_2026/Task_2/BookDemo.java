package Task_2;

class Book {
    String title;
    String author;
    double price;

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: Rs." + price);
    }
}

public class BookDemo {
    public static void main(String[] args) {

        Book b = new Book();

        b.title = "Java Programming";
        b.author = "James Gosling";
        b.price = 500;

        b.display();
    }
}