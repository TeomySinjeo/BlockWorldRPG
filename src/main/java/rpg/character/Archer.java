
package rpg.character;

import java.util.List;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 20, 2, 0,
                List.of("Режим прицеливания", "Элементный выстрел"));
    }

    @Override
    public String getClassName() {
        return "Лучник";
    }
}
