
package rpg.behavioral.state;

public class StunnedState implements CharacterState {

    @Override
    public void attack(CharacterStateContext character) {
        // Оглушённый персонаж не может атаковать
    }

    @Override
    public void takeDamage(CharacterStateContext character, int damage) {
        character.applyDamage(damage);
    }
}

