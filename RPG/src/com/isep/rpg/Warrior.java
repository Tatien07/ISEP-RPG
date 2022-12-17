package com.isep.rpg;

import java.util.Scanner;

public class Warrior extends Heros{
    protected String name;

    protected String warrior;
    public Warrior(String name, String warrior){
        super(120, 120,3,0,0,0);
        this.name = name;
        this.warrior = warrior;

    }


    @Override
    public String getname(){
        return name;
    }
    @Override
    public String setname(String name) {this.name = name;
        return name;
    }
    @Override
    public int getArmure() { return armure; }

    @Override
    public int setArmure(int armure) {this.armure = armure; return armure; }
    @Override
    public String getclasse() {return warrior;}

    @Override
    public int setMaxArmure(int maxarmure) { this.maxarmure = maxarmure; return maxarmure;}

    @Override
    public int getMaxArmure() {return maxarmure;}

    @Override
    public int getNbrpotion() {
        return 0;
    }

    @Override
    public int setNbrpotion(int nbrpotion) {
        return 0;
    }

    @Override
    public int setNbrlembas(int nbrlembas) { this.nbrlembas = nbrlembas; return nbrlembas;}

    @Override
    public int getNbrlembas() {return nbrlembas;}


    public void attaquer(int enemypv, enemy enemy){
        int degat = (int)Math.floor(Math.random()*(25-15+1)+15);
        enemypv -= degat;
        if (enemy.getPvenemy() <= 0) {
            enemy.setPvenemy(0);
            System.out.println(enemy.getname() + " n'a plus de vie, il est mort !");
        } else {
            System.out.println("Le slime a pris " + degat + " de dégâts !");
            System.out.println("Il lui reste " + enemypv + " de points de vie !\n");
            enemy.setPvenemy(enemypv);
        }
    }

    @Override
    public void lembas(){
        if (nbrlembas == 0) {
            System.out.println("Votre héros n'a plus de lembas ! \n");
        } else {
            armure += 40;
            nbrlembas -= 1;
            if (armure > maxarmure) {
                armure = maxarmure;
            }
            System.out.println(" Votre héros a gagné 40 d'armure, il a maintenant " + armure + " d'armure !");
            System.out.println("Il reste " + nbrlembas + " lembas à votre héros\n");

        }

    }

    @Override
    public void potion() {
    }

    @Override
    public void sort(int enemypv, enemy enemy) {

    }
}
