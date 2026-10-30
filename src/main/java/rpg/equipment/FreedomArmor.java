
package rpg.equipment;

public class FreedomArmor implements Armor {

    @Override
    public String getName() {
        return "Броня Свободы";
    }

    @Override
    public int getDefense() {
        return 2;
    }

    @Override
    public String getFaction() {
        return "Freedom";
    }
}
