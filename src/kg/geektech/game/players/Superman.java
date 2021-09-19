package kg.geektech.game.players;

public class Superman extends Hero {

    public Superman(int health, int damage) {
        super(health, damage, SuperAbility.SHOOT_FROM_THE_EYES_AND_TAKE_SMALL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        setDamage(getDamage() + 95);
        System.out.println("Superman shoot from the eyes");

        setHealth(getHealth() - boss.getDamage() + 40);
        System.out.println("Take Small damage");
    }
}
