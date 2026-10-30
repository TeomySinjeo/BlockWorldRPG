
package rpg.equipment;

public class FreedomSword implements Weapon {

    @Override
    public String getName() {
        return "Меч Свободы";
    }

    @Override
    public int getDamage() {
        return 3;
    }

    @Override
    public String getFaction() {
        return "Freedom";
    }
}
