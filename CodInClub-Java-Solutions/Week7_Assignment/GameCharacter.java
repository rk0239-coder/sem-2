
public class GameCharacter {

    private final int maxHealth;
    private int health;

    public GameCharacter(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
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
