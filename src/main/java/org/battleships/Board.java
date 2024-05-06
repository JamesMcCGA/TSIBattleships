package org.battleships;

import org.battleships.strategies.shipplacement.ShipPlacementStrategy;

public class Board {
    private char[][] grid;
    public static final int SIZE = 10;

    public Board(ShipPlacementStrategy strategy) {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = '~';  //
            }
        }
        strategy.placeShips(grid);  // delegate ship placement to the strategy
    }

    public AttackResult receiveAttack(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return new AttackResult(false,"Attack out of bounds!");
        }

        char result = grid[x][y];
        if (result == 'S') {
            grid[x][y] = 'X'; // Mark as hit and sunk
            return new AttackResult(true, "Hit and sunk at (" + (x+1) + ", " + (y+1) + ")");
        } else if (result == '~') {
            grid[x][y] = 'O'; // Mark as miss
            return new AttackResult(false, "Miss at (" + (x+1) + ", " + (y+1) + ")");
        } else {
            return new AttackResult(false, "Already attacked (" + (x+1) + ", " + (y+1) + ")");
        }
    }

    public boolean noShipsLeft() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == 'S') { // 'S' denotes an intact ship
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasShipAt(int x, int y) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
            return grid[x][y] == 'S';
        }
        return false;  // Return false if coordinates are out of bounds
    }


    // used to display a full board with all information
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    // used to display AIs board so that we can only see hits and misses and not their full board
    public void displayMasked() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == 'S') {  // ff there's a ship, show as water unless hit
                    System.out.print("~ ");
                } else {
                    System.out.print(grid[i][j] + " ");  // show hits and misses
                }
            }
            System.out.println();
        }
    }
}

