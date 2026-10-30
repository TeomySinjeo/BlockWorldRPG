
package rpg.character;

import java.util.List;

public class Mage extends Character {

    public Mage(String name) {
        super(name, 40, 10, 0,
                List.of("Фаербол", "Огненный магический щит"));
    }

    @Override
    public String getClassName() {
        return "Маг";
    }
}

