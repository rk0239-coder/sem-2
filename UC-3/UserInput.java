import java.util.Scanner;

class UserInput {

    // Method to get slot input from user
    public static int getUserSlot() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter slot number (1-9): ");
        int slot = sc.nextInt();   // Read integer input

        return slot; // Return the entered value
    }

    public static void main(String[] args) {
        int userSlot = getUserSlot();  // Method call

        System.out.println("You selected slot: " + userSlot);
    }
}