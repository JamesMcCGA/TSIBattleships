package org.battleships;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AttackResultTest {

    @Test
    public void testIsHit() {
        // when hit = true
        AttackResult attackResult1 = new AttackResult(true, "N/A");
        assertTrue(attackResult1.isHit());

        // when hit = false
        AttackResult attackResult2 = new AttackResult(false, "N/A");
        assertFalse(attackResult2.isHit());
    }

    @Test
    public void testGetMessage() {
        String message1 = "You hit the target!";
        AttackResult attackResult1 = new AttackResult(true, message1);
        assertEquals(message1, attackResult1.getMessage());
    }
}