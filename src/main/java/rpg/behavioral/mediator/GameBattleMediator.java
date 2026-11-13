
package rpg.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class GameBattleMediator implements BattleMediator {

    private final List<BattleParticipant> participants = new ArrayList<>();

    public void addParticipant(BattleParticipant participant) {
        if (participant == null) {
            throw new IllegalArgumentException("Участник сражения должен быть в бою!");
        }

        participants.add(participant);
    }

    @Override
    public void attack(BattleParticipant attacker, BattleParticipant target) {
        if (!participants.contains(attacker) || !participants.contains(target)) {
            throw new IllegalArgumentException(
                    "Оба участника должны находиться в сражении!"
            );
        }

        if (attacker == target) {
            throw new IllegalArgumentException("Нельзя атаковать самого себя!");
        }

        if (target.getHealth() <= 0) {
            throw new IllegalStateException("Цель уже убита");
        }

        int damage = 5;

        target.receiveDamage(damage);

        System.out.println(
                attacker.getName() + " атакует " + target.getName()
                        + " урон: " + damage
        );
    }

    @Override
    public void sendMessage(String message, BattleParticipant sender) {
        if (!participants.contains(sender)) {
            throw new IllegalArgumentException(
                    "Вы не участник!"
            );
        }

        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Сообщение обчзательно");
        }

        for (BattleParticipant participant : participants) {
            if (participant != sender) {
                participant.receiveMessage(message);
            }
        }
    }
}
