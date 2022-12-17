package com.isep.rpg;

public abstract class SpellCaster extends Heros{

    public SpellCaster(int armure, int maxarmure, int mana, int maxmana, int nbrlembas, int nbrpotion) {
        super(100,100,3, 2, 100, 100);


    }
    public abstract String getname();

    public abstract String setname(String name);

    public abstract void potion();

    public abstract void lembas();
}




