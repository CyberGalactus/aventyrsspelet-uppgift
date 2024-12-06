package se.edu.spelet.model;

public class Resident extends Entity {
    //Resident: Representerar spelaren (den boende i huset).
    public Resident(String role, int health, int damage) {
        super(role, health, damage);
    }

    public void setDamage(int damage) {
        this.damage += damage; // förut var det -=

    }

}
