
package rpg.generative.equipment.factory;

import rpg.generative.equipment.armor.Armor;
import rpg.generative.equipment.armor.VoidArmor;
import rpg.generative.equipment.weapon.VoidAxe;
import rpg.generative.equipment.weapon.Weapon;

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
