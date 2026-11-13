
package rpg.behavioral.state;

public class DeadState implements CharacterState {

    @Override
    public void attack(CharacterStateContext character) {
        // Мертвый не может атаковать
    }

    @Override
    public void takeDamage(CharacterStateContext character, int damage) {
        // Мертвый персонаж больше не получает урон
    }
}
