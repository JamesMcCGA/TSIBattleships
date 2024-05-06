package org.battleships.strategies.attacks;

import org.battleships.AttackResult;
import org.battleships.Board;

public class FakeAttackStrategy implements AttackStrategy {
    private int fixedX, fixedY;
    private boolean willHit;

    public FakeAttackStrategy(int x, int y, boolean willHit) {
        this.fixedX = x;
        this.fixedY = y;
        this.willHit = willHit;
    }

    @Override
    public AttackResult performAttack(Board board, int x, int y) {
        if (willHit) {
            return new AttackResult(true, "Fake hit at (" + (fixedX) + ", " + (fixedY) + ")");
        } else {
            return new AttackResult(false, "Fake miss at (" + (fixedX) + ", " + (fixedY) + ")");
        }
    }

}

