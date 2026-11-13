
package rpg.behavioral.templatemethod;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameChallengeTest {

    @Test
    void shouldPrepareCharacterBeforeChallenge() {
        DungeonChallenge challenge = new DungeonChallenge();

        challenge.completeChallenge();

        assertEquals(
                "Готовы войти в подземелье?",
                challenge.getLog().get(0)
        );
    }

    @Test
    void shouldCompleteDungeonChallenge() {
        DungeonChallenge challenge = new DungeonChallenge();

        challenge.completeChallenge();

        assertEquals(4, challenge.getLog().size());

        assertEquals(
                "Вы встретили мобов!",
                challenge.getLog().get(1)
        );

        assertEquals(
                "Вы убили всех мобов",
                challenge.getLog().get(2)
        );

        assertEquals(
                "Вы получили 100 злота",
                challenge.getLog().get(3)
        );
    }

    @Test
    void shouldCompleteBossChallenge() {
        BossChallenge challenge = new BossChallenge();

        challenge.completeChallenge();

        assertEquals(4, challenge.getLog().size());

        assertEquals(
                "Вы встретили Босса!",
                challenge.getLog().get(1)
        );

        assertEquals(
                "Вы убили Босса",
                challenge.getLog().get(2)
        );

        assertEquals(
                "Вы получили Алмазный меч!",
                challenge.getLog().get(3)
        );
    }

    @Test
    void shouldKeepSameOrderForDifferentChallenges() {
        GameChallenge dungeon = new DungeonChallenge();
        GameChallenge boss = new BossChallenge();

        dungeon.completeChallenge();
        boss.completeChallenge();

        assertTrue(
                dungeon.getLog().get(0).contains("Готовы войти в подземелье?")
        );

        assertTrue(
                boss.getLog().get(0).contains("Готовы войти в подземелье?")
        );

        assertTrue(
                dungeon.getLog().get(1).contains("встретил")
        );

        assertTrue(
                boss.getLog().get(1).contains("встретил")
        );
    }

    @Test
    void shouldReturnCopyOfLog() {
        DungeonChallenge challenge = new DungeonChallenge();

        challenge.completeChallenge();

        List<String> log = challenge.getLog();
        log.clear();

        assertEquals(4, challenge.getLog().size());
    }

    @Test
    void shouldClearOldLogBeforeNewChallenge() {
        DungeonChallenge challenge = new DungeonChallenge();

        challenge.completeChallenge();
        challenge.completeChallenge();

        assertEquals(4, challenge.getLog().size());
    }

    @Test
    void shouldNotAllowOverridingTemplateMethod() {
        assertTrue(
                java.lang.reflect.Modifier.isFinal(
                        getTemplateMethodModifiers()
                )
        );
    }

    private int getTemplateMethodModifiers() {
        try {
            return GameChallenge.class
                    .getDeclaredMethod("completeChallenge")
                    .getModifiers();
        } catch (NoSuchMethodException exception) {
            fail("Новые подземелья в разработке...");
            return 0;
        }
    }
}
