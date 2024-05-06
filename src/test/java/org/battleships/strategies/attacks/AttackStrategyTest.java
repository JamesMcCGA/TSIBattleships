package org.battleships.strategies.attacks;

import org.battleships.AttackResult;
import org.battleships.Board;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AttackStrategyTest {
    @Test
    public void testPerformAttackWhenAttackHits() {
        // paramters to be used in test
        int x = 5;
        int y = 5;
        boolean willHit = true;
        String expectedMessage = "Fake hit at " + "(" + x + ", " + y + ")";

        // mocking the board class
        Board mockBoard = mock(Board.class);

        // creating instance of fake
        FakeAttackStrategy strategy = new FakeAttackStrategy(x, y, willHit);

        // setup parameters and stub
        when(mockBoard.receiveAttack(x, y)).thenReturn(new AttackResult(willHit, expectedMessage));

        // perform attack
        AttackResult result = strategy.performAttack(mockBoard, x, y);

        // unit test assertions
        assertEquals(expectedMessage, result.getMessage());
        assertTrue(result.isHit());
    }

    @Test
    public void testPerformAttackWhenAttackMisses() {
        // paramters to be used in test
        int x = 5;
        int y = 5;
        boolean willHit = false;
        String expectedMessage = "Fake miss at " + "(" + x + ", " + y + ")";

        // mocking the board class
        Board mockBoard = mock(Board.class);

        // creating instance of fake
        FakeAttackStrategy strategy = new FakeAttackStrategy(x, y, willHit);

        // setup parameters and stub
        when(mockBoard.receiveAttack(x, y)).thenReturn(new AttackResult(willHit, expectedMessage));

        // perform attack
        AttackResult result = strategy.performAttack(mockBoard, x, y);

        // unit test assertions
        assertEquals(expectedMessage, result.getMessage());
        assertFalse(result.isHit());
    }
}
