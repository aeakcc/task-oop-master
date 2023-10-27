package com.epam.knight.controller;

import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.armor.Helmet;
import com.epam.knight.model.ammunition.weapon.Sword;

public class KnightGenerator {

    /**
     * Use it to quickly generate knight
     *
     * @return knight
     */
    public static Knight generateKnight() {
        Knight knight = new Knight();
        knight.equip(generateSword());
        knight.equip(generateHelmet());
        return knight;
    }

    public static Sword generateSword() {
        return new Sword(10, 20, 30);
    }

    public static Helmet generateHelmet() {
        return new Helmet(30, 10, 20);
    }
}