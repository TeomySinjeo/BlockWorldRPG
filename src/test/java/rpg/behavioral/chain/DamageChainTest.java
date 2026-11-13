
package rpg.behavioral.chain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DamageChainTest {

    @Test
    void shouldReduceDamageByArmorAndShield() {
        DamageChain chain = new DamageChain(5, 50);

        assertEquals(7, chain.calculateDamage(20));
    }

    @Test
    void shouldNotReturnNegativeDamage() {
        DamageChain chain = new DamageChain(50, 50);

        assertEquals(0, chain.calculateDamage(20));
    }

    @Test
    void shouldHandleFullShieldProtection() {
        DamageChain chain = new DamageChain(0, 100);

        assertEquals(0, chain.calculateDamage(100));
    }

    @Test
    void shouldHandleZeroDamage() {
        DamageChain chain = new DamageChain(0, 0);

        assertEquals(0, chain.calculateDamage(0));
    }

    @Test
    void shouldRejectNegativeDamage() {
        DamageChain chain = new DamageChain(5, 50);

        assertThrows(
                IllegalArgumentException.class,
                () -> chain.calculateDamage(-10)
        );
    }
}

