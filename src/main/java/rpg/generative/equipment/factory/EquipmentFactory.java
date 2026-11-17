
package rpg.generative.equipment.factory;

import rpg.generative.equipment.armor.Armor;
import rpg.generative.equipment.weapon.Weapon;

public interface EquipmentFactory {

    Weapon createWeapon();

    Armor createArmor();
}

