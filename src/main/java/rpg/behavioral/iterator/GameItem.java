
package rpg.behavioral.iterator;

public class GameItem {

    private final String name;

    public GameItem(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "У всех предметов есть название!"
            );
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
