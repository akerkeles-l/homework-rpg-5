package com.narxoz.rpg.enemy;

public class BossEnemy {
    private final String name;
    private int health;
    private final int attackPower;
    private final int maxHealth;

    public BossEnemy(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attackPower = attackPower;
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

    public int getAttackPower() {
        return attackPower;
    }

    public void takeDamage(int amount) {
        health = Math.max(0, health - amount);
    }

    public boolean isAlive() {
        return health > 0;
    }
    
    public double getHealthPercentage() {
        return (double) health / maxHealth * 100;
    }
}