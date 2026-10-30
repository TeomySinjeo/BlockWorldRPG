
package rpg.equipment;

public class VoidEquipmentFactory implements EquipmentFactory {

    @Override
    public Weapon createWeapon() {
        return new VoidAxe();
    }

    @Override
    public Armor createArmor() {
        return new VoidArmor();
    }
}
