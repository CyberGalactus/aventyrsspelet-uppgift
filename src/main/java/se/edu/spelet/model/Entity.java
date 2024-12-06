package se.edu.spelet.model;

public class Entity {
    String role;
    int health;
    int damage;

    public Entity(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;
    }

    public String getRole() {
        return role;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void punch(Entity toPunch) {
        toPunch.takeHit(this.damage);
    }

    public void takeHit(int damage) {
        this.health -= damage;
    }

    public boolean isConscious() {
        return this.health > 0;
    }

    public boolean isKnockedOut() {
        return this.health <= 0;
    }
}