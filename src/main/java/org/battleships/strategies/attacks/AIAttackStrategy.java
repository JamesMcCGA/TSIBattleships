package org.battleships.strategies.attacks;

import org.battleships.AttackResult;
import org.battleships.Board;

public class AIAttackStrategy implements AttackStrategy {
    @Override
    public AttackResult performAttack(Board board, int x, int y) {
        // if values are not provided
        if (x < 0 || y < 0) {
            x = generateRandomCoordinate();
            y = generateRandomCoordinate();
        }
        return board.receiveAttack(x, y);
    }

    private int generateRandomCoordinate() {
        return (int) (Math.random() * Board.SIZE);
    }
}
