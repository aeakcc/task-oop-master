package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.armor.Helmet;
import com.epam.knight.model.ammunition.weapon.Sword;

import java.util.Arrays;
import java.util.Scanner;

public class Knight {
    private int damage;
    private int protection;
    private int weight;
    private int cost;
    private Ammunition[] ammunition;
    private Ammunition[] sortedAmmunition;

    public Ammunition[] getSortedAmmunition() {
        return sortedAmmunition;
    }

    public void equip(Ammunition element) {
        if (ammunition == null) {
            ammunition = new Ammunition[1];
        } else {
            ammunition = Arrays.copyOf(ammunition, ammunition.length + 1);
        }

        ammunition[ammunition.length - 1] = element;
    }

    public int calculateAmmunitionWeight() {
        int totalWeight = 0;
        for (Ammunition allAmmunition : ammunition) {
            if (allAmmunition != null) {
                totalWeight += allAmmunition.getWeight();
            }
        }

        this.weight = totalWeight;
        return weight;
    }

    public int calculateAmmunitionCost() {
        int totalCost = 0;
        for (Ammunition allAmmunition : ammunition) {
            if (allAmmunition != null) {
                totalCost += allAmmunition.getCost();
            }
        }

        this.cost = totalCost;
        return cost;
    }

    public int calculateAmmunitionDamage() {
        int totalDamage = 0;
        for (Ammunition allAmmunition : ammunition) {
            if (allAmmunition != null && allAmmunition.getClass().equals(Sword.class)) {
                totalDamage += ((Sword) allAmmunition).getDamage();
            }
        }

        this.damage = totalDamage;
        return damage;
    }

    public int calculateAmmunitionProtection() {
        int totalProtection = 0;
        for (Ammunition allAmmunition : ammunition) {
            if (allAmmunition != null && allAmmunition.getClass().equals(Helmet.class)) {
                totalProtection += ((Helmet) allAmmunition).getProtection();
            }
        }

        this.protection = totalProtection;
        return protection;
    }

    public void sortAmmunition(int costOrWeight) {
        Ammunition temp;
        sortedAmmunition = ammunition;

        if (costOrWeight == 1) {
            for (int i = 0; i < sortedAmmunition.length; i++) {
                for (int j = 0; j < sortedAmmunition.length - 1; j++) {
                    if (sortedAmmunition[j] == null) break;

                    if (sortedAmmunition[j].getCost() < sortedAmmunition[j + 1].getCost()) {
                        temp = sortedAmmunition[j];
                        sortedAmmunition[j] = sortedAmmunition[j + 1];
                        sortedAmmunition[j + 1] = temp;
                    }
                }
            }
        }

        else if (costOrWeight == 2) {
            for (int i = 0; i < sortedAmmunition.length; i++) {
                for (int j = 0; j < sortedAmmunition.length - 1; j++) {
                    if (sortedAmmunition[j] == null) break;

                    if (sortedAmmunition[j].getWeight() < sortedAmmunition[j + 1].getWeight()) {
                        temp = sortedAmmunition[j];
                        sortedAmmunition[j] = sortedAmmunition[j + 1];
                        sortedAmmunition[j + 1] = temp;
                    }
                }
            }
        } else {
            System.out.println("There's no such option");
        }
    }

    public void searchingAmmunition(int costOrWeight) {
        Scanner scan = new Scanner(System.in);
        if (costOrWeight == 1) {
            System.out.println("Input minimum cost:");
            int minCost = scan.nextInt();
            System.out.println("Input maximum cost: ");
            int maxCost = scan.nextInt();

            for (Ammunition element : ammunition) {
                if (element == null) break;

                if (element.getCost() > minCost && element.getCost() < maxCost) {
                    if (element.getClass().equals(Sword.class)) {
                        System.out.println("Sword{damage= " + ((Sword) element).getDamage() + ", weight="
                                + element.getWeight() + ", cost=" + element.getCost() + "}");
                    }
                    if (element.getClass().equals(Helmet.class)) {
                        System.out.println("Helmet{protection= " + ((Helmet) element).getProtection() + ", weight="
                                + element.getWeight() + ", cost=" + element.getCost() + "}");
                    }
                }
            }
        }
        if (costOrWeight == 2) {
            System.out.println("Input minimum weight:");
            int minWeight = scan.nextInt();
            System.out.println("Input maximum weight: ");
            int maxwWeight = scan.nextInt();

            for (Ammunition element : ammunition) {
                if (element == null) break;

                if (element.getWeight() > minWeight && element.getWeight() < maxwWeight) {
                    if (element.getClass().equals(Sword.class)) {
                        System.out.println("Sword{damage= " + ((Sword) element).getDamage() + ", weight="
                                + element.getWeight() + ", cost=" + element.getCost() + "}");
                    }
                    if (element.getClass().equals(Helmet.class)) {
                        System.out.println("Helmet{protection= " + ((Helmet) element).getProtection() + ", weight="
                                + element.getWeight() + ", cost=" + element.getCost() + "}");
                    }
                }
            }
        }
    }

    public Ammunition[] getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(Ammunition[] ammunition) {
        this.ammunition = ammunition;
    }
}