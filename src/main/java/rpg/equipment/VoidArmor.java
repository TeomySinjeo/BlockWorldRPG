
package rpg.equipment;

public class VoidArmor implements Armor {

    @Override
    public String getName() {
        return "Броня Бездны";
    }

    @Override
    public int getDefense() {
        return 2;
    }

    @Override
    public String getFaction() {
        return "Void";
    }
}

