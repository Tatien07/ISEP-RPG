package com.isep.rpg;


public class Slime extends enemy{
    protected String name;

    public Slime(String name, int randlife) {
        super(randlife);
        this.name = name;
    }

    public void attaquer(int herosarmure, Heros heros){
        int degat = (int)Math.floor(Math.random()*(30-15+1)+15);
        herosarmure -= degat;
        if (heros.getArmure() <= 0) {
            heros.setArmure(0);
            System.out.println(heros.getname() + "n'a plus de vie, il est mort !");
        } else {
            System.out.println("Le Héros a pris " + degat + " de dégâts !");
            System.out.println("Il lui reste " + herosarmure + " de points de vie !\n");
            heros.setArmure(herosarmure);
        }

    }



    public String getname() {return name; }

    public int getPvenemy() { return pvenemy;}
    public int setPvenemy(int pvenemy) {this.pvenemy = pvenemy; return pvenemy; }

}

