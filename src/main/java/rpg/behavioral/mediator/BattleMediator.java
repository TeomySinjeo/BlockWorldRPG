
package rpg.behavioral.mediator;

public interface BattleMediator {
    void attack(BattleParticipant attacker, BattleParticipant target);
    void sendMessage(String message, BattleParticipant sender);
}
