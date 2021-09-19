package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero{
    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.BOSS_CANT_HIT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean superOfThorIsTrue = RPG_Game.random.nextBoolean();
        if(superOfThorIsTrue){
            boss.setDamage(0);
            System.out.println("Thor activated SUPER");
        }else if(!(superOfThorIsTrue) ){
            boss.setDamage(boss.getDamage());
        }

    }

}