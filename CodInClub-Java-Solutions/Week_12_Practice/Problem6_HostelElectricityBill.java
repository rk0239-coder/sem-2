import java.util.Scanner;

public class Problem6_HostelElectricityBill {
    static long bill(long units) {
        long amount;
        if (units <= 100) amount = units * 3;
        else if (units <= 200) amount = 300 + (units - 100) * 5;
        else amount = 800 + (units - 200) * 8;
        return amount + 50;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int billed = 0;
        long total = 0;
        for (int i = 0; i < n; i++) {
            String room = sc.next();
            long units = sc.nextLong();
            if (units < 0) {
                System.out.println(room + ": invalid reading");
            } else {
                long b = bill(units);
                System.out.println(room + ": " + units + " units, bill " + b);
                billed++;
                total += b;
            }
        }
        System.out.println("Rooms billed " + billed + ", total " + total);
    }
}
