package rpg.behavioral.visitor;

public interface CharacterVisitor {

    void visit(WarriorUnit warrior);

    void visit(MageUnit mage);

    void visit(ArcherUnit archer);
}