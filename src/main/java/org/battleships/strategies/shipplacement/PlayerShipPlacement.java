package org.battleships.strategies.shipplacement;
import org.battleships.Board;

import java.util.Scanner;

public class PlayerShipPlacement implements ShipPlacementStrategy {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void placeShips(char[][] grid) {
        System.out.println("Enter coordinates for your ships (format: x y):");
        for (int i = 0; i < 5; i++) {
            int x, y;
            do {
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } while (x < 0 || x >= Board.SIZE || y < 0 || y >= Board.SIZE || grid[x][y] == 'S');
            grid[x][y] = 'S';
        }
    }
}
