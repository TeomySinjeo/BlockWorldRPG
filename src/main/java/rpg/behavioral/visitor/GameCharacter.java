package rpg.behavioral.visitor;

public interface GameCharacter {

    void accept(CharacterVisitor visitor);
}