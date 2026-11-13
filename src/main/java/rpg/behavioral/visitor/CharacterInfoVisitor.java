package rpg.behavioral.visitor;

public class CharacterInfoVisitor implements CharacterVisitor {

    private String result;

    @Override
    public void visit(WarriorUnit warrior) {
        result = "Воин: сила = " + warrior.getStrength()
                + ", броня = " + warrior.getArmor();
    }

    @Override
    public void visit(MageUnit mage) {
        result = "Маг: магическая сила = " + mage.getMagicPower()
                + ", мана = " + mage.getMana();
    }

    @Override
    public void visit(ArcherUnit archer) {
        result = "Лучник: ловкость = " + archer.getAgility()
                + ", сила = " + archer.getStrength();
    }

    public String getResult() {
        return result;
    }
}