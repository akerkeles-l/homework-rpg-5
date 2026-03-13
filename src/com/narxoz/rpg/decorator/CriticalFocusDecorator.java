package com.narxoz.rpg.decorator;

public class CriticalFocusDecorator extends ActionDecorator {
    
    public CriticalFocusDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return "⚡ " + getWrappedAction().getActionName() + " with Critical Focus";
    }

    @Override
    public int getDamage() {
        return getWrappedAction().getDamage() * 2;
    }

    @Override
    public String getEffectSummary() {
        return getWrappedAction().getEffectSummary() + " + critical strike (2x damage)";
    }
}