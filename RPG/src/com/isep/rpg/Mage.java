package com.isep.rpg;

public class Mage extends SpellCaster{
    protected String name;
    protected  String mage;
    public Mage( String name, String mage){
        super(100,100,100,100,3,2);
        this.name = name;
        this.mage = mage;


    }
    @Override
    public String getname(){
        return name;
    }

    @Override
    public String getclasse() {return mage;}

    @Override
    public String setname(String name) {this.name = name;
        return name;
    }

    @Override
    public int getArmure() { return armure; }

    @Override
    public int setArmure(int armure) {this.armure = armure; return armure; }

    @Override
    public int setMaxArmure(int maxarmure) { this.maxarmure = maxarmure; return maxarmure;}

    @Override
    public int getMaxArmure() {return maxarmure;}

    @Override
    public int setNbrpotion(int nbrpotion) { this.nbrpotion = nbrpotion; return nbrpotion;}

    @Override
    public int getNbrpotion() {return nbrpotion;}

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
    public void sort(int enemypv, enemy enemy){
        int degat = (int)Math.floor(Math.random()*(20-15+1)+15);
        enemypv -= degat;
        mana -= 40;
        if (mana < 0) {
            mana = 0;
        }
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
    public void potion(){
        if (nbrpotion == 0) {
            System.out.println(" Votre héros n'a plus de potion ! \n");
        } else {
            nbrpotion -= 1;
            mana += 40;
            if (mana > maxmana) {
                mana = maxmana;

            }

            System.out.println(" Votre Héros a gagné 40 de mana !\n");

        }

    }

    @Override
    public void lembas() {
        if (nbrlembas == 0) {
            System.out.println("Votre héros n'a plus de lembas ! ");
        } else {
            armure += 40;
            nbrlembas -= 1;
            if (armure > maxarmure) {
                armure = maxarmure;
            }
            System.out.println(" Votre héros a gagné 40 d'armure, il a maintenant " + armure + " d'armure !");
            System.out.println("Il reste " + nbrlembas + " lembas à votre héros");

        }

    }


}


