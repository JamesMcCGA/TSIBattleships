package org.battleships.strategies.attacks;
import org.battleships.AttackResult;
import org.battleships.Board;
import java.util.Scanner;

public class PlayerAttackStrategy implements AttackStrategy {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public AttackResult performAttack(Board board, int x, int y) {
        return board.receiveAttack(x, y);
    }
}
