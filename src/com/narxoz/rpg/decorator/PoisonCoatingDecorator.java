package com.narxoz.rpg.decorator;

public class PoisonCoatingDecorator extends ActionDecorator {
    
    public PoisonCoatingDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return "☠️ " + getWrappedAction().getActionName() + " with Poison Coating";
    }

    @Override
    public int getDamage() {
        return getWrappedAction().getDamage() + 5;
    }

    @Override
    public String getEffectSummary() {
        return getWrappedAction().getEffectSummary() + " + poison (5 damage over time)";
    }
}