package com.narxoz.rpg;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        HeroProfile hero = new HeroProfile("Sir Lancelot", 100);
        BossEnemy boss = new BossEnemy("Dragonlord Malefor", 120, 15);

        System.out.println("--- DECORATOR PATTERN DEMO ---");
        System.out.println("Showing runtime attack composition:\n");

        AttackAction basic = new BasicAttack("Strike", 10);
        
        AttackAction fireAttack = new FireRuneDecorator(basic);
        AttackAction poisonAttack = new PoisonCoatingDecorator(basic);
        AttackAction criticalAttack = new CriticalFocusDecorator(basic);
        
        AttackAction firePoison = new FireRuneDecorator(new PoisonCoatingDecorator(basic));
        AttackAction fullCombo = new CriticalFocusDecorator(
                new FireRuneDecorator(
                        new PoisonCoatingDecorator(basic)
                )
        );
        
        AttackAction fireCritical = new FireRuneDecorator(new CriticalFocusDecorator(basic));
        AttackAction poisonCritical = new PoisonCoatingDecorator(new CriticalFocusDecorator(basic));

        AttackAction[] attacks = {basic, fireAttack, poisonAttack, criticalAttack, 
                                  firePoison, fireCritical, poisonCritical, fullCombo};
        String[] names = {"Basic", "Fire", "Poison", "Critical", 
                         "Fire+Poison", "Fire+Critical", "Poison+Critical", "Full Combo"};
        
        for (int i = 0; i < attacks.length; i++) {
            System.out.printf("%-15s: %-45s | Damage: %-3d | %s%n",
                names[i],
                attacks[i].getActionName(),
                attacks[i].getDamage(),
                attacks[i].getEffectSummary());
        }
        
        System.out.println("\n✓ Decorator Pattern Verified: Multiple runtime combinations created without creating separate classes");
        System.out.println("  Order matters: Critical Focus doubles ALL damage including elemental effects!\n");

        System.out.println("--- FACADE PATTERN DEMO ---");
        System.out.println("Running dungeon adventure with Full Combo attack:\n");

        DungeonFacade facade = new DungeonFacade().setRandomSeed(42L);
        AdventureResult result = facade.runAdventure(hero, boss, fullCombo);

        
        System.out.println("=== ADVENTURE SUMMARY ===");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Final Hero HP: " + result.getHeroFinalHealth() + "/100");
        System.out.println("Final Boss HP: " + result.getBossFinalHealth() + "/120");
        System.out.println("Reward: " + result.getReward());
        
        System.out.println("\n=== DETAILED LOG ===");
        for (String line : result.getLog()) {
            System.out.println(line);
        }

        System.out.println("\n--- SECOND RUN: Different Attack Combination ---");
        
        HeroProfile hero2 = new HeroProfile("Sir Lancelot", 100);
        BossEnemy boss2 = new BossEnemy("Dragonlord Malefor", 120, 15);
        
        System.out.println("Using Fire + Critical attack:\n");
        AdventureResult result2 = facade.runAdventure(hero2, boss2, fireCritical);
        
        System.out.println("Winner: " + result2.getWinner());
        System.out.println("Rounds: " + result2.getRounds());
        System.out.println("Final Hero HP: " + result2.getHeroFinalHealth() + "/100");
        System.out.println("Final Boss HP: " + result2.getBossFinalHealth() + "/120");
        System.out.println("Reward: " + result2.getReward());

        System.out.println("\n=== VERIFICATION ===");
        System.out.println("✓ Decorator Pattern: Demonstrated " + attacks.length + " runtime combinations");
        System.out.println("✓ Facade Pattern: DungeonFacade hid complexity of Preparation, Battle, and Reward services");
        System.out.println("✓ Both patterns working together seamlessly");
        
        System.out.println("\n=== Demo Complete ===");
    }
}