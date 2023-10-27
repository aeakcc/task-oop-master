package com.epam.knight.controller;

import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.view.ConsoleView;

public class KnightController {
    private final Knight knight = KnightGenerator.generateKnight();
    private final ConsoleView consoleView = new ConsoleView();

    void displayKnightStats() {
        consoleView.printKnightStatics(knight);
    }

    void displayAmmunition() {
        consoleView.showAmmunition(knight);
    }

    void displayEquip() {
        consoleView.equipAmmunition();
    }

    void equipSword(Ammunition ammunition) {
        knight.equip(ammunition);
    }

    void equipHelmet(Ammunition ammunition) {
        knight.equip(ammunition);
    }

    void sort(int choice) {
        knight.sortAmmunition(choice);
    }
    void displaySortedAmmunition(){
        consoleView.sortedAmmunition(knight);
    }

    void search(int choice) {
        knight.searchingAmmunition(choice);
    }
}
