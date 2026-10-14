import java.util.Scanner;

class UserInput {

    public static int getUserSlot() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter slot number (1-9): ");
        int slot = sc.nextInt();

        return slot;
    }

    public static void main(String[] args) {
        int userSlot = getUserSlot();

        System.out.println("You selected slot: " + userSlot);
    }
}