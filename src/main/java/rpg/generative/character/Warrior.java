
package rpg.generative.character;

import java.util.List;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 20, 4, 20,
                List.of("Сплэш мечом", "Защита щитом"));
    }

    @Override
    public String getClassName() {
        return "Воин";
    }
}
