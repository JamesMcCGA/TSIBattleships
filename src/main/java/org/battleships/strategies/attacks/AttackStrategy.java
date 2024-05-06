package org.battleships.strategies.attacks;
import org.battleships.AttackResult;
import org.battleships.Board;

public interface AttackStrategy {
    AttackResult performAttack(Board board, int x, int y);
}
