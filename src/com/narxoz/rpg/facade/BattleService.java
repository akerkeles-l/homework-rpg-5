package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;
import java.util.Random;

public class BattleService {
    private Random random = new Random();

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();
        StringBuilder battleLog = new StringBuilder();
        
        int round = 1;
        boolean heroTurn = random.nextBoolean(); 
        
        battleLog.append("⚔️ Battle Begins!\n");
        battleLog.append(heroTurn ? hero.getName() : boss.getName()).append(" attacks first!\n\n");
        
    
        while (hero.isAlive() && boss.isAlive() && round <= 20) {
            battleLog.append("Round ").append(round).append(":\n");
            
            if (heroTurn) {
                int damage = action.getDamage();
                
                double multiplier = 0.8 + (random.nextDouble() * 0.4);
                int finalDamage = (int)(damage * multiplier);
                
                boss.takeDamage(finalDamage);
                battleLog.append(String.format("   %s attacks with %s for %d damage! Boss HP: %d/%d (%.1f%%)\n",
                    hero.getName(), action.getActionName(), finalDamage, 
                    boss.getHealth(), boss.getMaxHealth(), 
                    (double)boss.getHealth() / boss.getMaxHealth() * 100));
            } else {
                int bossDamage = boss.getAttackPower();
                double multiplier = 0.7 + (random.nextDouble() * 0.6);
                int finalDamage = (int)(bossDamage * multiplier);
                
                hero.takeDamage(finalDamage);
                battleLog.append(String.format("   %s attacks for %d damage! Hero HP: %d/%d\n",
                    boss.getName(), finalDamage, hero.getHealth(), hero.getMaxHealth()));
            }
            
            heroTurn = !heroTurn; 
            round++;
        }
        if (!hero.isAlive()) {
            result.setWinner(boss.getName());
            battleLog.append("\n💀 ").append(hero.getName()).append(" has been defeated!");
        } else if (!boss.isAlive()) {
            result.setWinner(hero.getName());
            battleLog.append("\n🎉 ").append(boss.getName()).append(" has been defeated!");
        } else {
            result.setWinner("Draw (Max rounds reached)");
            battleLog.append("\n⏰ Battle reached maximum rounds!");
        }
        
        result.setRounds(round - 1);
        result.setHeroFinalHealth(hero.getHealth());
        result.setBossFinalHealth(boss.getHealth());
        
        for (String line : battleLog.toString().split("\n")) {
            result.addLine(line);
        }
        
        return result;
    }
}