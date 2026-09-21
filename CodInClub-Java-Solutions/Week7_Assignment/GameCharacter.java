/*
 * ASSIGNMENT PROBLEM 1: The Health Bar
 *
 * Scenario:
 * A game character has health that changes during battle.
 *
 * Problem Statement:
 * Design a Character class where health can never drop below 0 or rise
 * above its maximum, and can't be set directly from outside.
 *
 * (Named GameCharacter here instead of Character, since Character is a
 * built-in java.lang class - the behavior required by the problem is
 * otherwise implemented exactly as specified.)
 *
 * Requirements:
 * - Health must be private, changed only through takeDamage(int amount)
 *   and heal(int amount).
 * - Health must never go below 0 (extra damage is just wasted) or above
 *   the maximum (extra healing is just wasted).
 * - The maximum health must be final, fixed when the character is created.
 * - Provide a read-only way to check current health - no setter for it.
 *
 * Sample:
 *   GameCharacter c = new GameCharacter(100);
 *   c.takeDamage(30) -> health = 70
 *   c.heal(50)        -> health = 100 (capped)
 *   c.takeDamage(150)  -> health = 0 (floored)
 */
public class GameCharacter {

    private final int maxHealth;
    private int health;

    public GameCharacter(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth; // characters start at full health
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0; // floor at 0
        }
    }

    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth; // cap at maximum
        }
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        GameCharacter c = new GameCharacter(100);
        System.out.println("Starting health: " + c.getHealth() + " (expected 100)");

        c.takeDamage(30);
        System.out.println("After takeDamage(30): " + c.getHealth() + " (expected 70)");

        c.heal(50);
        System.out.println("After heal(50): " + c.getHealth() + " (expected 100, capped)");

        c.takeDamage(150);
        System.out.println("After takeDamage(150): " + c.getHealth() + " (expected 0, floored)");
    }
}
