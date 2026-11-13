
package rpg.behavioral.state;

public interface CharacterState {

    void attack(CharacterStateContext character);

    void takeDamage(CharacterStateContext character, int damage);
}
