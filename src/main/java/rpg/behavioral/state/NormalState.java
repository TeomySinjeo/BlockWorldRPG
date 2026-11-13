
package rpg.behavioral.state;

public class NormalState implements CharacterState {

    @Override
    public void attack(CharacterStateContext character) {
        character.registerAttack();
    }

    @Override
    public void takeDamage(CharacterStateContext character, int damage) {
        character.applyDamage(damage);
    }
}
