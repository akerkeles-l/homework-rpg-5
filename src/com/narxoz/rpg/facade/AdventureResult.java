package com.narxoz.rpg.facade;

import java.util.ArrayList;
import java.util.List;

public class AdventureResult {
    private String winner;
    private int rounds;
    private String reward;
    private final List<String> log = new ArrayList<>();
    private int heroFinalHealth;
    private int bossFinalHealth;

    // Getters and Setters
    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public List<String> getLog() {
        return log;
    }

    public void addLine(String line) {
        log.add(line);
    }

    public int getHeroFinalHealth() {
        return heroFinalHealth;
    }

    public void setHeroFinalHealth(int heroFinalHealth) {
        this.heroFinalHealth = heroFinalHealth;
    }

    public int getBossFinalHealth() {
        return bossFinalHealth;
    }

    public void setBossFinalHealth(int bossFinalHealth) {
        this.bossFinalHealth = bossFinalHealth;
    }
}