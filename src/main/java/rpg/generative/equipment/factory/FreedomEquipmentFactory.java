
package rpg.generative.equipment.factory;

import rpg.generative.equipment.armor.Armor;
import rpg.generative.equipment.armor.FreedomArmor;
import rpg.generative.equipment.weapon.FreedomSword;
import rpg.generative.equipment.weapon.Weapon;

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
