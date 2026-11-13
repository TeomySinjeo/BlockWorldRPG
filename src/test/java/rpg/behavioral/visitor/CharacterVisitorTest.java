package rpg.behavioral.visitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterVisitorTest {

    @Test
    void shouldCalculateWarriorPower() {
        WarriorUnit warrior = new WarriorUnit(10, 5);
        CombatPowerVisitor visitor = new CombatPowerVisitor();

        warrior.accept(visitor);

        assertEquals(25, visitor.getResult());
    }

    @Test
    void shouldCalculateMagePower() {
        MageUnit mage = new MageUnit(15, 20);
        CombatPowerVisitor visitor = new CombatPowerVisitor();

        mage.accept(visitor);

        assertEquals(50, visitor.getResult());
    }

    @Test
    void shouldCalculateArcherPower() {
        ArcherUnit archer = new ArcherUnit(12, 8);
        CombatPowerVisitor visitor = new CombatPowerVisitor();

        archer.accept(visitor);

        assertEquals(32, visitor.getResult());
    }

    @Test
    void shouldDescribeWarrior() {
        WarriorUnit warrior = new WarriorUnit(10, 5);
        CharacterInfoVisitor visitor = new CharacterInfoVisitor();

        warrior.accept(visitor);

        assertEquals(
                "Воин: сила = 10, броня = 5",
                visitor.getResult()
        );
    }

    @Test
    void shouldDescribeMage() {
        MageUnit mage = new MageUnit(15, 20);
        CharacterInfoVisitor visitor = new CharacterInfoVisitor();

        mage.accept(visitor);

        assertEquals(
                "Маг: магическая сила = 15, мана = 20",
                visitor.getResult()
        );
    }

    @Test
    void shouldDescribeArcher() {
        ArcherUnit archer = new ArcherUnit(12, 8);
        CharacterInfoVisitor visitor = new CharacterInfoVisitor();

        archer.accept(visitor);

        assertEquals(
                "Лучник: ловкость = 12, сила = 8",
                visitor.getResult()
        );
    }

    @Test
    void shouldRejectNegativeWarriorStats() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new WarriorUnit(-1, 5)
        );
    }

    @Test
    void shouldRejectNegativeMageStats() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new MageUnit(10, -1)
        );
    }

    @Test
    void shouldRejectNegativeArcherStats() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ArcherUnit(10, -1)
        );
    }

    @Test
    void shouldAllowDifferentVisitorsForSameCharacter() {
        WarriorUnit warrior = new WarriorUnit(10, 5);

        CombatPowerVisitor powerVisitor = new CombatPowerVisitor();
        CharacterInfoVisitor infoVisitor = new CharacterInfoVisitor();

        warrior.accept(powerVisitor);
        warrior.accept(infoVisitor);

        assertEquals(25, powerVisitor.getResult());
        assertEquals(
                "Воин: сила = 10, броня = 5",
                infoVisitor.getResult()
        );
    }
}