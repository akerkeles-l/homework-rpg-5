package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class PreparationService {
    public String prepare(HeroProfile hero, BossEnemy boss, AttackAction action) {
        if (hero == null || boss == null || action == null) {
            return "❌ Invalid preparation state: Missing hero, boss, or action";
        }
        
        StringBuilder preparation = new StringBuilder();
        preparation.append("📋 Preparation Complete:\n");
        preparation.append("   - Hero: ").append(hero.getName()).append(" (HP: ").append(hero.getHealth());
        
        try {
            preparation.append("/").append(hero.getMaxHealth());
        } catch (Exception e) {
        }
        preparation.append(")\n");
        
        preparation.append("   - Boss: ").append(boss.getName()).append(" (HP: ").append(boss.getHealth());
        
        try {
            preparation.append("/").append(boss.getMaxHealth());
        } catch (Exception e) {
        }
        preparation.append(")\n");
        
        preparation.append("   - Attack: ").append(action.getActionName()).append("\n");
        preparation.append("   - Damage: ").append(action.getDamage()).append("\n");
        preparation.append("   - Effects: ").append(action.getEffectSummary());
        
        return preparation.toString();
    }
}