
package rpg.equipment;

public class VoidAxe implements Weapon {

    @Override
    public String getName() {
        return "Топор Бездны";
    }

    @Override
    public int getDamage() {
        return 3;
    }

    @Override
    public String getFaction() {
        return "Void";
    }
}
