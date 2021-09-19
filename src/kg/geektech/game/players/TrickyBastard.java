package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class TrickyBastard extends Hero{
    public TrickyBastard(int health, int damage) {
        super(health, damage, SuperAbility.MAKE_A_JOKE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean randomBoolean = RPG_Game.random.nextBoolean();
        if (randomBoolean){
            this.setHealth(0);
            this.setDamage(0);
            System.out.println("Joker joked");
        }else if(!(randomBoolean)){
            this.setHealth(this.getHealth());
            this.setDamage(this.getDamage());
        }
    }
}