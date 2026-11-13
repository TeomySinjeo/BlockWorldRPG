
package rpg.behavioral.state;

public class CharacterStateContext {

    private int health;
    private int attackCount;
    private CharacterState state;

    public CharacterStateContext(int health) {
        if (health <= 0) {
            throw new IllegalArgumentException(
                    "Здоровье не может быть меньше 0, иначе вы мертвы!"
            );
        }

        this.health = health;
        this.state = new NormalState();
    }

    public void attack() {
        state.attack(this);
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException(
                    "Урон не может быть отрицательным, иначе вы не наносите урон!"
            );
        }

        state.takeDamage(this, damage);
    }

    public void stun() {
        if (!(state instanceof DeadState)) {
            state = new StunnedState();
        }
    }

    public void recover() {
        if (state instanceof StunnedState) {
            state = new NormalState();
        }
    }

    void registerAttack() {
        attackCount++;
    }

    void applyDamage(int damage) {
        health = Math.max(0, health - damage);

        if (health == 0) {
            state = new DeadState();
        }
    }

    public int getHealth() {
        return health;
    }

    public int getAttackCount() {
        return attackCount;
    }

    public CharacterState getState() {
        return state;
    }
}

