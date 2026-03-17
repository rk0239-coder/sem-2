package UC;

public class PrintBanner2 {
    public static void displayBanner() {
        String o1 = " ***** ";
        String o2 = "*     *";
        String o3 = "*     *";
        String o4 = "*     *";
        String o5 = "*     *";
        String o6 = "*     *";
        String o7 = " ***** ";
        String p1 = "*****  ";
        String p2 = "*    * ";
        String p3 = "*    * ";
        String p4 = "*****  ";
        String p5 = "*      ";
        String p6 = "*      ";
        String p7 = "*      ";
        String s1 = " ***** ";
        String s2 = "*      ";
        String s3 = "*      ";
        String s4 = " ***** ";
        String s5 = "      *";
        String s6 = "      *";
        String s7 = " ***** ";
        String sep = "  ";
        System.out.println(o1 + sep + o1 + sep + p1 + sep + s1);
        System.out.println(o2 + sep + o2 + sep + p2 + sep + s2);
        System.out.println(o3 + sep + o3 + sep + p3 + sep + s3);
        System.out.println(o4 + sep + o4 + sep + p4 + sep + s4);
        System.out.println(o5 + sep + o5 + sep + p5 + sep + s5);
        System.out.println(o6 + sep + o6 + sep + p6 + sep + s6);
        System.out.println(o7 + sep + o7 + sep + p7 + sep + s7);
    }

    public static void main(String[] args) {
        PrintBanner2.displayBanner();
    }
}