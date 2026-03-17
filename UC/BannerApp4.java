package UC;

public class BannerApp4 {
    public static void main(String[] args) {
        String[] lines = new String[]{
            "...",
            String.join(" ", "   ***   ", "   ***   ", " ******  ", "  *****  "),
            String.join(" ", " **   ** ", " **   ** ", " **    **", " **   ** "),
            String.join(" ", "**     **", "**     **", " **    **", " **      "),
            String.join(" ", "**     **", "**     **", " ******  ", "  *****  "),
            String.join(" ", "**     **", "**     **", " **      ", "      ** "),
            String.join(" ", " **   ** ", " **   ** ", " **      ", " **   ** "),
            String.join(" ", "   ***   ", "   ***   ", " **      ", "  *****  ")
        };
        for (String line : lines) {
            System.out.println(line);
        }
    }
}