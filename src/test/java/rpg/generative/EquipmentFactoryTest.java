
package rpg.generative;

import org.junit.jupiter.api.Test;
import rpg.generative.equipment.FreedomEquipmentFactory;
import rpg.generative.equipment.Armor;
import rpg.generative.equipment.EquipmentFactory;
import rpg.generative.equipment.VoidEquipmentFactory;
import rpg.generative.equipment.Weapon;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentFactoryTest {

    @Test
    void allianceShouldCreateItsOwnEquipment() {
        EquipmentFactory factory = new FreedomEquipmentFactory();

        Weapon weapon = factory.createWeapon();
        Armor armor = factory.createArmor();

        assertEquals("Freedom", weapon.getFaction());
        assertEquals("Freedom", armor.getFaction());

        assertEquals("Меч Свободы", weapon.getName());
        assertEquals("Броня Свободы", armor.getName());

        assertEquals(3, weapon.getDamage());
        assertEquals(2, armor.getDefense());
    }

    @Test
    void hordeShouldCreateItsOwnEquipment() {
        EquipmentFactory factory = new VoidEquipmentFactory();

        Weapon weapon = factory.createWeapon();
        Armor armor = factory.createArmor();

        assertEquals("Void", weapon.getFaction());
        assertEquals("Void", armor.getFaction());

        assertEquals("Топор Бездны", weapon.getName());
        assertEquals("Броня Бездны", armor.getName());

        assertEquals(3, weapon.getDamage());
        assertEquals(2, armor.getDefense());
    }

    @Test
    void factionsShouldHaveDifferentEquipment() {
        EquipmentFactory alliance = new FreedomEquipmentFactory();
        EquipmentFactory horde = new VoidEquipmentFactory();

        assertNotEquals(
                alliance.createWeapon().getName(),
                horde.createWeapon().getName()
        );

        assertNotEquals(
                alliance.createArmor().getName(),
                horde.createArmor().getName()
        );
    }

    @Test
    void factoryShouldCreateNewEquipmentObjects() {
        EquipmentFactory factory = new FreedomEquipmentFactory();

        Weapon first = factory.createWeapon();
        Weapon second = factory.createWeapon();

        assertNotSame(first, second);
    }
}
