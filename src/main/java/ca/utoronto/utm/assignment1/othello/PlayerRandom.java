package ca.utoronto.utm.assignment1.othello;

import java.util.*;

/**
 * PlayerRandom makes a move by first determining all possible moves that this
 * player can make, putting them in an ArrayList, and then randomly choosing one
 * of them.
 * 
 * @author arnold
 *
 */
public class PlayerRandom {

    private Othello othello;
    private char player;
    private Random rand = new Random();

    public PlayerRandom(Othello othello, char player) {
        this.othello = othello;
        this.player = player;
    }

	public Move getMove() {
        ArrayList<Move> moveRandom = new ArrayList<Move>();
        for (int row = 0; row < othello.DIMENSION; row++) {
            for (int col = 0; col < othello.DIMENSION; col++) {
                int flips = othello.getFlipCount(row, col, player);
                if (flips > 0) {
                    moveRandom.add(new Move(row, col));
                }
            }
        }
        return moveRandom.isEmpty()
                ? null
                : moveRandom.get(rand.nextInt(moveRandom.size()));
	}
}
