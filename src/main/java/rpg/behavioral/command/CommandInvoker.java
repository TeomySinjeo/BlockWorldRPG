
package rpg.behavioral.command;

public class CommandInvoker {

    public void executeCommand(GameCommand command) {
        if (command == null) {
            throw new IllegalArgumentException("Команда должна существовать!");
        }

        command.execute();
    }
}
