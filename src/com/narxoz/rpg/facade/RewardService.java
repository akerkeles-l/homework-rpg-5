package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null) {
            return "No reward - Battle failed to initialize";
        }
        
        String winner = battleResult.getWinner();
        int heroHealth = battleResult.getHeroFinalHealth();
        
        boolean heroWon = winner != null && 
                         (winner.equals("Sir Lancelot") || 
                          winner.contains("Lancelot") ||
                          winner.equals("Hero") || 
                          (battleResult.getHeroFinalHealth() > 0 && battleResult.getBossFinalHealth() <= 0));
        
        if (heroWon) {
            if (heroHealth > 50) {
                return "🏆 Legendary Treasure Chest (5,000 gold + Epic Sword)";
            } else if (heroHealth > 20) {
                return "💰 Golden Treasure Chest (2,000 gold + Magic Ring)";
            } else {
                return "📦 Wooden Treasure Chest (500 gold + Health Potion)";
            }
        } else if (winner != null && winner.contains("Draw")) {
            return "🪙 Small Compensation (100 gold)";
        } else {
            return "💀 Nothing - You have been defeated!";
        }
    }
}