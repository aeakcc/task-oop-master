package com.epam.knight.view;

import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.armor.Helmet;
import com.epam.knight.model.ammunition.weapon.Sword;

public class ConsoleView {
    private static final String MAIN_MENU = "Main menu";
    private static final String KNIGHT_STATS = "1. Print knight stats";
    private static final String SHOW_AMMUNITION = "2. Show ammunition";
    private static final String EQUIP_AMMUNITION = "3. Equip ammunition";
    private static final String SORT_AMMUNITION = "4. Sort ammunition";
    private static final String SEARCH_AMMUNITION = "5. Search ammunition";
    private static final String EXIT = "6. Exit";
    private static final String CHOOSE_OPTION = "Choose option: ";
    private static final String AMMUNITION_COST = "Ammunition cost: ";
    private static final String AMMUNITION_WEIGHT = "Ammunition weight: ";
    private static final String AMMUNITION_DAMAGE = "Ammunition damage: ";
    private static final String AMMUNITION_PROTECTION = "Ammunition protection: ";
    private static final String EQUIP_AMMUNITION_QUESTION = "What kind of ammunition do you want to equip?";
    private static final String OPTION_OF_AMMUNITION_SWORD = "1. Sword";
    private static final String OPTION_OF_AMMUNITION_HELMET = "2. Helmet";
    private static final String NEW_SWORD_WEIGHT = "Input sword weight:";
    private static final String NEW_SWORD_COST = "Input sword cost:";
    private static final String NEW_SWORD_DAMAGE = "Input sword damage:";
    private static final String CHOOSE_SORT_TYPE = "Choose sort type:";
    private static final String NEW_HELMET_WEIGHT = "Input helmet weight:";
    private static final String NEW_HELMET_COST = "Input helmet cost:";
    private static final String NEW_HELMET_PROTECTION = "Input helmet protection:";
    private static final String COST = "1. Cost";
    private static final String WEIGHT = "2. Weight";
    private static final String SEARCH_FIELD = "Choose search field:";
    private static final String BYE = "Bye!";

    public void printMenu() {
        System.out.println(MAIN_MENU);
        System.out.println(KNIGHT_STATS);
        System.out.println(SHOW_AMMUNITION);
        System.out.println(EQUIP_AMMUNITION);
        System.out.println(SORT_AMMUNITION);
        System.out.println(SEARCH_AMMUNITION);
        System.out.println(EXIT);
        System.out.println(CHOOSE_OPTION);
    }

    public void printKnightStatics(Knight knight) {
        System.out.println(AMMUNITION_COST + knight.calculateAmmunitionCost());
        System.out.println(AMMUNITION_WEIGHT + knight.calculateAmmunitionWeight());
        System.out.println(AMMUNITION_DAMAGE + knight.calculateAmmunitionDamage());
        System.out.println(AMMUNITION_PROTECTION + knight.calculateAmmunitionProtection());
    }

    public void printBye() {
        System.out.println(BYE);
    }

    public void printErrorOption() {
        System.out.println("Enter the right option!");
    }

    public void showAmmunition(Knight knight) {
        Ammunition[] ammunitions = knight.getAmmunition();
        if (knight.getAmmunition() == null) {
            System.out.println("No ammunition found");
        } else {
            for (Ammunition ammunition : ammunitions) {
                if (ammunition != null) {
                    if (ammunition.getClass().equals(Sword.class)) {
                        System.out.println(
                                "Sword{damage=" + ((Sword) ammunition).getDamage() +
                                        ", weight=" + ammunition.getWeight() +
                                        ", cost=" + ammunition.getCost() + "}"
                        );
                    }

                    if (ammunition.getClass().equals(Helmet.class)) {
                        System.out.println(
                                "Helmet{protection=" + ((Helmet) ammunition).getProtection() +
                                        ", weight=" + ammunition.getWeight() +
                                        ", cost=" + ammunition.getCost() + "}"
                        );
                    }
                }
            }
        }
    }

    public void equipAmmunition() {
        System.out.println(EQUIP_AMMUNITION_QUESTION);
        System.out.println(OPTION_OF_AMMUNITION_SWORD);
        System.out.println(OPTION_OF_AMMUNITION_HELMET);
    }

    public void setNewSwordWeight() {
        System.out.println(NEW_SWORD_WEIGHT);
    }

    public void setNewSwordCost() {
        System.out.println(NEW_SWORD_COST);
    }

    public void setNewSwordDamage() {
        System.out.println(NEW_SWORD_DAMAGE);
    }

    public void setNewHelmetWeight() {
        System.out.println(NEW_HELMET_WEIGHT);
    }

    public void setNewHelmetCost() {
        System.out.println(NEW_HELMET_COST);
    }

    public void setNewHelmetProtection() {
        System.out.println(NEW_HELMET_PROTECTION);
    }

    public void sortType() {
        System.out.println(CHOOSE_SORT_TYPE);
    }

    public void optionSortByCost() {
        System.out.println(COST);
    }

    public void optionSortByWeight() {
        System.out.println(WEIGHT);
    }

    public void menuSearchAmmunition() {
        System.out.println(SEARCH_FIELD);
        System.out.println(COST);
        System.out.println(WEIGHT);
    }

    public void sortedAmmunition(Knight knight){
        for (int i = 0; i < knight.getSortedAmmunition().length; i++){
            if (knight.getSortedAmmunition()[i].getClass().equals(Sword.class)){
                System.out.println("Sword{damage=" + ((Sword)knight.getSortedAmmunition()[i]).getDamage() +
                        ", weight=" + knight.getAmmunition()[i].getWeight() + ", cost="
                        + knight.getSortedAmmunition()[i].getCost() + "}");
            }
            if (knight.getSortedAmmunition()[i].getClass().equals(Helmet.class)){
                System.out.println("Helmet{protection=" + ((Helmet)knight.getSortedAmmunition()[i]).getProtection() +
                        ", weight=" + knight.getAmmunition()[i].getWeight() + ", cost="
                        + knight.getSortedAmmunition()[i].getCost() + "}");
            }
        }
    }
}