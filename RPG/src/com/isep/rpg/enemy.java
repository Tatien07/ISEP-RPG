package com.isep.rpg;

public abstract class enemy extends Combattant{
    protected int pvenemy;

    public enemy(int pvenemy) {
        this.pvenemy = pvenemy;
    }

    public abstract String getname();

    public abstract void attaquer(int herosarmure, Heros heros);
    public abstract int getPvenemy();
    public abstract int setPvenemy(int pvenemy);




}
