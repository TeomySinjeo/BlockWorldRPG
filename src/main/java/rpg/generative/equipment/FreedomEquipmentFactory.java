
package rpg.generative.equipment;

public class FreedomEquipmentFactory implements EquipmentFactory {

    @Override
    public Weapon createWeapon() {
        return new FreedomSword();
    }

    @Override
    public Armor createArmor() {
        return new FreedomArmor();
    }
}
