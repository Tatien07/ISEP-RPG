package com.isep.rpg;

import java.awt.*;

public abstract class Heros extends Combattant {
    protected  int armure;
    protected int maxarmure;
    protected int nbrlembas;
    protected int nbrpotion;
    protected int mana;
    protected int maxmana;

    public Heros(int armure, int maxarmure, int nbrlembas, int nbrpotion, int mana, int maxmana) {
        this.armure = armure;
        this.maxarmure = maxarmure;
        this.nbrlembas = nbrlembas;
        this.nbrpotion = nbrpotion;
        this.mana = mana;
        this.maxmana = maxmana;



    }

    public abstract String getname();

    public abstract String setname(String name);

    public abstract void lembas();
    public abstract void attaquer(int enemypv, enemy enemy);
    public abstract void sort(int enemypv, enemy enemy);
    public abstract void potion();
    public abstract String getclasse();

    public abstract int getArmure();
    public abstract int setArmure(int armure);
    public abstract int setMaxArmure(int maxarmure);
    public abstract int getMaxArmure();
    public abstract int getNbrpotion();
    public abstract int setNbrpotion(int nbrpotion);

    public abstract int getNbrlembas();
    public abstract int setNbrlembas(int nbrlembas);
}


    

