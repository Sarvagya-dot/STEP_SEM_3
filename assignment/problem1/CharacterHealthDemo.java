public class CharacterHealthDemo {

    public static void main(String[] args) {
        Character character = new Character(100);

        character.takeDamage(30);
        System.out.println("takeDamage(30) -> health = " + character.getHealth());

        character.heal(50);
        System.out.println("heal(50) -> health = " + character.getHealth());

        character.takeDamage(150);
        System.out.println("takeDamage(150) -> health = " + character.getHealth());
    }
}

class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        int newHealth = health - amount;
        health = Math.max(newHealth, 0);
    }

    public void heal(int amount) {
        int newHealth = health + amount;
        health = Math.min(newHealth, maxHealth);
    }

    public int getHealth() {
        return health;
    }
}
