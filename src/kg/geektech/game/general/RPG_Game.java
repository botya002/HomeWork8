package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();

    public static void startGame(){
        Boss boss = new Boss(5500, 45);
        Warrior warrior = new Warrior(275, 20);
        Medic support = new Medic(235, 15, 25);
        Magic magic = new Magic(265, 25);
        Berserk berserk = new Berserk(275, 15);
        Medic assistant = new Medic(245, 10, 15);
        Thor thor = new Thor(210, 20);
        Witcher witcher = new Witcher(45, 0);
        Superman superman = new Superman(400, 55);
        TrickyBastard joker = new TrickyBastard(205, 40);
        Hero[] heroes = {warrior, magic, berserk, support, assistant, thor, joker, witcher, superman};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes, joker);
        }
    }

    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(boss, heroes);
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() -
                        heroes[i].getDamage());
            }
        }
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0)
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
        }
    }

    private static void round(Boss boss, Hero[] heroes, TrickyBastard joker) {
        bossHits(boss, heroes);
        heroesHit(boss, heroes);
        heroesApplySuperAbilities(boss, heroes);
        printStatistics(boss, heroes);
        bossGetDamage(boss);
        jokerGetDamageAndHealth(joker);
    }

    private static void bossGetDamage(Boss boss) {
        boss.setDamage(50);
    }

    private static void jokerGetDamageAndHealth(TrickyBastard joker) {
        joker.setDamage(35);
        joker.setHealth(joker.getHealth() + 180);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("___________");
        System.out.println("Boss health: " + boss.getHealth() +
                " [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName()
                    + " health: " + heroes[i].getHealth() +
                    " [" + heroes[i].getDamage() + "]");
        }
        System.out.println("___________");
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

}