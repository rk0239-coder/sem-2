package UC;

public class BannerApp5 {
    public static void main(String[] args) {
        String[] lines = new String[]{
            "   ***       ***     ******       *****  ",
            " **   **   **   **   **    **   **       ",
            "**     ** **     **  **    **  **        ",
            "**     ** **     **  **    **   **       ",
            "**     ** **     **  ******       ***    ",
            "**     ** **     **  **              **  ",
            "**     ** **     **  **               ** ",
            " **   **   **   **   **              **  ",
            "   ***       ***     **         *****    "
        };
        for (String line : lines) {
            System.out.println(line);
        }
    }
}