package org.battleships;

import org.battleships.strategies.attacks.AIAttackStrategy;
import org.battleships.strategies.attacks.AttackStrategy;
import org.battleships.strategies.attacks.PlayerAttackStrategy;
import org.battleships.strategies.shipplacement.AIShipPlacement;
import org.battleships.strategies.shipplacement.PlayerShipPlacement;

import java.util.Scanner;

public class BattleshipGame {
    private Board playerBoard;
    private Board aiBoard;
    private AttackStrategy playerAttackStrategy;
    private AttackStrategy aiAttackStrategy;
    private Scanner scanner;

    public BattleshipGame() {
        scanner = new Scanner(System.in);
        playerBoard = new Board(new PlayerShipPlacement());
        aiBoard = new Board(new AIShipPlacement());
        playerAttackStrategy = new PlayerAttackStrategy();
        aiAttackStrategy = new AIAttackStrategy();
    }

    public void startGame() {
        System.out.println("Welcome to Battleship!");

        while (!gameOver()) {
            playerTurn();
            if (gameOver()) {
                break;
            }
            aiTurn();
        }

        System.out.println("Game over! " + (playerBoard.noShipsLeft() ? "AI Wins!" : "Player Wins!"));
        scanner.close();
    }

    private void playerTurn() {
        System.out.println("Player's turn");
        System.out.println("Your Board:");
        playerBoard.display();
        System.out.println("AI Board (masked):");
        aiBoard.displayMasked();

        System.out.println("Enter coordinates to attack (format: x y):");
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        AttackResult result = playerAttackStrategy.performAttack(aiBoard, x, y);
        System.out.println(result.getMessage());
    }

    private void aiTurn() {
        System.out.println("AI's turn");
        AttackResult result = aiAttackStrategy.performAttack(playerBoard, 0, 0);
        System.out.println("AI attacks: " + result.getMessage());
    }

    private boolean gameOver() {
        return playerBoard.noShipsLeft() || aiBoard.noShipsLeft();
    }

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.startGame();
    }
}

