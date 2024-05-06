package org.battleships.strategies.shipplacement;
import org.battleships.Board;

import java.util.Random;

public class AIShipPlacement implements ShipPlacementStrategy {
    private Random random = new Random();

    // AI will place 5 ships randomly
    @Override
    public void placeShips(char[][] grid) {
        for (int i = 0; i < 5; i++) {
            int x, y;
            do {
                x = random.nextInt(Board.SIZE);
                y = random.nextInt(Board.SIZE);
            } while (grid[x][y] == 'S');
            grid[x][y] = 'S';
        }
    }
}
