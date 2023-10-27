package com.epam.knight.model.ammunition.weapon;

public class Sword implements Weapon {
    private final int damage;
    private final int weight;
    private final int cost;

    public Sword(int damage, int weight, int cost) {
        this.damage = damage;
        this.weight = weight;
        this.cost = cost;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getCost() {
        return cost;
    }
}