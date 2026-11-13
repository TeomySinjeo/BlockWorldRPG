package rpg.behavioral.visitor;

public class CombatPowerVisitor implements CharacterVisitor {

    private int result;

    @Override
    public void visit(WarriorUnit warrior) {
        result = warrior.getStrength() * 2 + warrior.getArmor();
    }

    @Override
    public void visit(MageUnit mage) {
        result = mage.getMagicPower() * 2 + mage.getMana();
    }

    @Override
    public void visit(ArcherUnit archer) {
        result = archer.getAgility() * 2 + archer.getStrength();
    }

    public int getResult() {
        return result;
    }
}