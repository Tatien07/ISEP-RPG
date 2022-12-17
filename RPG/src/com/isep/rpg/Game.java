package com.isep.rpg;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {

    private final List<Heros> heros = new ArrayList<>();
    private final List<enemy> enemies = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    public static final String red = "\u001B[31m";
    public static final String reset = "\u001B[0m";
    public static final String green = "\u001B[32m";
    public static final String blue = "\u001B[34m";
    public static final String yellow = "\u001B[33m";

    public void gameStarter() {
        System.out.println(red + "Bienvenue dans SHIMITSU" + reset);

        // choisir le nombre de héros et leurs noms
        System.out.println("Choisissez le nombre de héros : Vous pouvez en choisir entre 1 et 4"); // choisir le nombre de héros
        int nombreheros = scanner.nextInt();
        while (nombreheros < 1 || nombreheros > 4) {
            System.out.println("Numéro non valide, veuillez rentrer de nouveau");
            nombreheros = scanner.nextInt();
        }
        System.out.println("Choisissiez vos " + nombreheros + " héros : Warrior, Hunter, Healer, Mage"); // Choisir le nom des héros
        int i = 0;
        while (i < nombreheros) {
            i++;
            System.out.println("Choisir le héros numéro :" + i);
            String nomheros = scanner.nextLine();
            switch (nomheros) {
                case "Warrior" -> {
                    Warrior warrior = new Warrior("name", "warrior");
                    System.out.println("Comment s'appelle votre Warrior ?");
                    String warriorname = scanner.nextLine();
                    warrior.setname(warriorname);
                    heros.add(warrior);
                    System.out.println("Votre Warrior s'appelle " + warrior.getname() + "\n");
                    System.out.println("Il a " + warrior.armure + " de vie et " + warrior.nbrlembas + " lembas\n");
                }
                case "Hunter" -> {
                    Hunter hunter = new Hunter("name", "hunter");
                    System.out.println("Comment s'appelle votre Hunter ?");
                    String huntername = scanner.nextLine();
                    hunter.setname(huntername);
                    heros.add(hunter);
                    System.out.println("Votre hunter s'appelle " + hunter.getname() + "\n");
                    System.out.println("Il a " + hunter.armure + " de vie et " + hunter.nbrlembas + " lembas\n");
                }
                case "Healer" -> {
                    Healer healer = new Healer("name", "healer");
                    System.out.println("Comment s'appelle votre Healer ?");
                    String healername = scanner.nextLine();
                    healer.setname(healername);
                    heros.add(healer);
                    System.out.printf("Votre Healer s'appelle " + healer.getname() + "\n");
                    System.out.println("Il a " + healer.armure + " de vie, " + healer.nbrlembas + " lembas, " + healer.mana + " de mana et " + healer.nbrpotion + " de potions\n");
                }
                case "Mage" -> {
                    Mage mage = new Mage("name", "mage");
                    System.out.println("Commment s'appelle votre mage ?");
                    String magename = scanner.nextLine();
                    mage.setname(magename);
                    heros.add(mage);
                    System.out.printf("Votre Mage s'appelle " + mage.getname() + "\n");
                    System.out.println("Il a " + mage.armure + " de vie, " + mage.nbrlembas + " lembas, " + mage.mana + " de mana et " + mage.nbrpotion + " de potions\n");
                }
                default -> {
                    i--;
                    System.out.println("Ce héros n'existe pas\n");
                }
            }

        }

        // Boucle pour faire 5 combats
        for (int nbr = 1; nbr < 6; nbr++) {

            //Vie aléatoire des enemies
            int randlife = (int) Math.floor(Math.random() * (100 - 70 + 1) + 70); // vie aléatoire des slimes
            int rand = (int) Math.floor(Math.random() * (nombreheros - 1 + 1) + 1);

            // Définir le nombre de slimes en fonction du nombre de héros
            System.out.println("Pour le premier combat, vous allez affronter " + rand + " slimes");
            switch (rand) {
                case 1 -> enemies.add(new Slime("slime1", randlife));
                case 2 -> {
                    enemies.add(new Slime("slime1", randlife));
                    enemies.add(new Slime("slime2", randlife));
                }
                case 3 -> {
                    enemies.add(new Slime("slime1", randlife));
                    enemies.add(new Slime("slime2", randlife));
                    enemies.add(new Slime("slime3", randlife));
                }
                case 4 -> {
                    enemies.add(new Slime("slime1", randlife));
                    enemies.add(new Slime("slime2", randlife));
                    enemies.add(new Slime("slime3", randlife));
                    enemies.add(new Slime("slime4", randlife));
                }
            }

            // Commencer le combat
            while (heros.size() != 0 && enemies.size() != 0) {
                var numenemy = ThreadLocalRandom.current().nextInt(0, enemies.size());
                var numheros = ThreadLocalRandom.current().nextInt(0, heros.size());
                var randheros = heros.get(numheros);
                var randenemy = enemies.get(numenemy);

                System.out.println(randheros.getname() + " va affronter " + randenemy.getname() + ", il a " + randenemy.getPvenemy() + " points de vie !\n");
                System.out.println(yellow + "Que voulez vous faire ?" + reset);
                switch (randheros.getclasse()) {
                    case "mage" -> {
                        System.out.println(blue + "Choisissez entre les 4 propositions : Attaquer(1), Lembas(2), Sort(3), Potion(4)" + reset);
                        int numero1 = scanner.nextInt();
                        switch (numero1) {
                            case 1 -> randheros.attaquer(randenemy.getPvenemy(), randenemy);
                            case 2 -> randheros.lembas();
                            case 3 -> {
                                    for (enemy en : enemies)
                                        randheros.sort(en.getPvenemy(),en);
                            }
                            case 4 -> randheros.potion();
                        }
                    }
                    case "healer" -> {
                        System.out.println(blue + "Choisissez entre les 4 propositions : Attaquer(1), Lembas(2), Sort(3), Potion(4)" + reset);
                        int numero2 = scanner.nextInt();
                        switch (numero2) {
                            case 1 -> randheros.attaquer(randenemy.getPvenemy(), randenemy);
                            case 2 -> randheros.lembas();
                            case 3 -> {
                                for (enemy en : enemies)
                                    randheros.sort(en.getPvenemy(),en);
                            }
                            case 4 -> randheros.potion();
                        }
                    }
                    case "warrior" -> {
                        System.out.println(blue + "Choisissez entre les 2 propositions : Attaquer(1), Lembas(2)" + reset);
                        int numero3 = scanner.nextInt();
                        switch (numero3) {
                            case 1 -> randheros.attaquer(randenemy.getPvenemy(), randenemy);
                            case 2 -> randheros.lembas();
                        }
                    }
                    case "hunter" -> {
                        System.out.println(blue + "Choisissez entre les 2 propositions : Attaquer(1), Lembas(2)" + reset);
                        int numero4 = scanner.nextInt();
                        switch (numero4) {
                            case 1 -> randheros.attaquer(randenemy.getPvenemy(), randenemy);
                            case 2 -> randheros.lembas();
                        }
                    }
                }
                if (randenemy.getPvenemy() <= 0) {
                    enemies.remove(randenemy);
                    System.out.println(randenemy.getname() + " est mort !");
                } else {
                    randenemy.attaquer(randheros.getArmure(), randheros);
                }
                if (randheros.getArmure() <= 0) {
                    heros.remove(randheros);
                    System.out.println(randheros.getname() + " est mort !");
                }

            }
            if (heros.size() == 0) {
                System.out.println("Vous avez perdu, vous pouvez réessayer !");
                System.exit(0);
            } else if (enemies.size() == 0) {
                System.out.println("Vous avez gagné le combat!");
                System.out.println("Vous pouvez choisir entre plusieurs bonus pour chaque personnage !");
                for (Heros b : heros) {
                    switch (b.getclasse()) {
                        case "mage":
                            System.out.println("Choissez ce que vous voulez comme bonus pour " + b.getname());
                            System.out.println("Vous pouvez choisir, en rentrant un nombre, entre : augmenter le nombre de point de vie max de 10 (1), gagner 1 potion (2), gagner 1 lembas (3)");
                            int choix1 = scanner.nextInt();
                            switch (choix1) {
                                case 1 -> b.setMaxArmure(b.getMaxArmure() + 10);
                                case 2 -> b.setNbrpotion(b.getNbrpotion() + 1);
                                case 3 -> b.setNbrlembas(b.getNbrlembas() + 1);
                            }
                        case "healer":
                            System.out.println("Choissez ce que vous voulez comme bonus pour " + b.getname());
                            System.out.println("Vous pouvez choisir, en rentrant un nombre, entre : augmenter le nombre de point de vie max de 10 (1), gagner 1 potion (2), gagner 1 lembas (3)");
                            int choix2 = scanner.nextInt();
                            switch (choix2) {
                                case 1 -> b.setMaxArmure(b.getMaxArmure() + 10);
                                case 2 -> b.setNbrpotion(b.getNbrpotion() + 1);
                                case 3 -> b.setNbrlembas(b.getNbrlembas() + 1);
                            }
                        case "hunter":
                            System.out.println("Choissez ce que vous voulez comme bonus pour " + b.getname());
                            System.out.println("Vous pouvez choisir, en rentrant un nombre, entre : augmenter le nombre de point de vie max de 10 (1), gagner 1 lembas (2)");
                            int choix3 = scanner.nextInt();
                            switch (choix3) {
                                case 1 -> b.setMaxArmure(b.getMaxArmure() + 10);
                                case 2 -> b.setNbrlembas(b.getNbrlembas() + 1);
                            }
                        case "warrior":
                            System.out.println("Choissez ce que vous voulez comme bonus pour " + b.getname());
                            System.out.println("Vous pouvez choisir, en rentrant un nombre, entre : augmenter le nombre de point de vie max de 10 (1), gagner 1 lembas (2)");
                            int choix4 = scanner.nextInt();
                            switch (choix4) {
                                case 1 -> b.setMaxArmure(b.getMaxArmure() + 10);
                                case 2 -> b.setNbrlembas(b.getNbrlembas() + 1);
                            }
                    }

                }


            }


        }
        System.out.println("Vous avez réussi les 5 combats, Bravo !");

    }




}




