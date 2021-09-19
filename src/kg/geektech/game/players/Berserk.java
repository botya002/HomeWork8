package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {
    public Berserk(int health, int damage){
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }
    @Override
    public void applySuperPower(Boss boss, Hero[] heroes){
        int pieceOfDamage = RPG_Game.random.nextInt(30);
        boss.setHealth(boss.getHealth() - (this.getDamage() + pieceOfDamage));
        System.out.println("Berserk activated SUPER");
    }
}
