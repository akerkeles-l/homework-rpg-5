package com.narxoz.rpg.hero;

public class HeroProfile {
    private final String name;
    private int health;
    private final int maxHealth; 

    public HeroProfile(String name, int health) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void takeDamage(int amount) {
        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    public boolean isAlive() {
        return health > 0;
    }
}