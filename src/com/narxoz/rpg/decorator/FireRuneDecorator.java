package com.narxoz.rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {
    
    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return "🔥 " + getWrappedAction().getActionName() + " with Fire Rune";
    }

    @Override
    public int getDamage() {
        // Fire adds 8 bonus damage
        return getWrappedAction().getDamage() + 8;
    }

    @Override
    public String getEffectSummary() {
        return getWrappedAction().getEffectSummary() + " + burning (8 fire damage)";
    }
}