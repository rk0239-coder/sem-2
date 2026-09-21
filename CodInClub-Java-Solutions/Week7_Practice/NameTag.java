/*
 * PRACTICE PROBLEM 3: The Nickname Tag
 *
 * Scenario:
 * A chat app shows a friendly short nickname instead of your full name.
 *
 * Problem Statement:
 * Create an immutable NameTag class that takes a full name once and builds
 * a nickname from it - first name plus the last name's initial.
 *
 * Requirements:
 * - Take one full name string in the constructor (e.g., "Maria Gomez") and
 *   split it into first and last name.
 * - Store whatever you keep as final fields - nothing about the name
 *   should be changeable after creation.
 * - Provide a method that returns the nickname (e.g., "Maria G."), built
 *   from the stored parts.
 * - Assume the full name always has exactly one first name and one last
 *   name, separated by a single space.
 *
 * Sample:
 *   NameTag tag = new NameTag("Maria Gomez");
 *   tag.getNickname() -> "Maria G."
 */
public class NameTag {

    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname() + " (expected \"Maria G.\")");

        NameTag tag2 = new NameTag("John Smith");
        System.out.println(tag2.getNickname() + " (expected \"John S.\")");
    }
}
