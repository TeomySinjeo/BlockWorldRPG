
package rpg.behavioral.observer;

public class GameEvent {

    private final String type;
    private final String message;

    public GameEvent(String type, String message) {
        if (type == null || type.isBlank()
                || message == null || message.isBlank()) {
            throw new IllegalArgumentException(
                    "Тип события и сообщение не могут быть пустыми!"
            );
        }

        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}

