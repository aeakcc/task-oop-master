package com.epam.knight.controller;

import com.epam.knight.model.ammunition.armor.Helmet;
import com.epam.knight.model.ammunition.weapon.Sword;
import com.epam.knight.view.ConsoleView;

import java.util.Scanner;

public class KnightApplication {
    private static final int DISPLAY_KNIGHT_STATS = 1;
    private static final int DISPLAY_AMMUNITION = 2;
    private static final int EQUIP_AMMUNITION = 3;
    private static final int MENU_FOR_SORTING = 4;
    private static final int EQUIP_SWORD = 1;
    private static final int EQUIP_HELMET = 2;
    private static final int SEARCH_WEAPON = 5;
    private static final int EXIT = 6;

    public static void main(String[] args) {
        KnightApplication application = new KnightApplication();
        application.start();
    }

    private void start() {
        KnightController knightController = new KnightController();
        ConsoleView consoleView = new ConsoleView();
        Scanner scanner = new Scanner(System.in);
        boolean isApplicationStarted = true;
        while (isApplicationStarted) {
            consoleView.printMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case DISPLAY_KNIGHT_STATS:
                    knightController.displayKnightStats();
                    break;
                case DISPLAY_AMMUNITION:
                    knightController.displayAmmunition();
                    break;
                case EQUIP_AMMUNITION:
                    knightController.displayEquip();
                    choice = scanner.nextInt();
                    if (choice == EQUIP_SWORD) {
                        consoleView.setNewSwordWeight();
                        int newSwordWeight = scanner.nextInt();
                        consoleView.setNewSwordCost();
                        int newSwordCost = scanner.nextInt();
                        consoleView.setNewSwordDamage();
                        int newSwordDamage = scanner.nextInt();
                        knightController.equipSword(new Sword(newSwordDamage, newSwordWeight, newSwordCost));
                    }
                    if (choice == EQUIP_HELMET) {
                        consoleView.setNewHelmetWeight();
                        int newHelmetWeight = scanner.nextInt();
                        consoleView.setNewHelmetCost();
                        int newHelmetCost = scanner.nextInt();
                        consoleView.setNewHelmetProtection();
                        int newHelmetProtection = scanner.nextInt();
                        knightController.equipHelmet(new Helmet(newHelmetProtection, newHelmetWeight, newHelmetCost));
                    }
                    break;
                case MENU_FOR_SORTING:
                    consoleView.sortType();
                    consoleView.optionSortByCost();
                    consoleView.optionSortByWeight();
                    int choiceSortOption = scanner.nextInt();
                    knightController.sort(choiceSortOption);
                    knightController.displaySortedAmmunition();
                    break;
                case SEARCH_WEAPON:
                    consoleView.menuSearchAmmunition();
                    int choiceForSearching = scanner.nextInt();
                    knightController.search(choiceForSearching);
                    break;
                case EXIT:
                    consoleView.printBye();
                    isApplicationStarted = false;
                    break;
                default:
                    consoleView.printErrorOption();
                    break;
            }
        }
    }
}
