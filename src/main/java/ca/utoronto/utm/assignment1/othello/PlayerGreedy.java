package ca.utoronto.utm.assignment1.othello;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * PlayerGreedy makes a move by considering all possible moves that the player
 * can make. Each move leaves the player with a total number of tokens.
 * getMove() returns the first move which maximizes the number of
 * tokens owned by this player. In case of a tie, between two moves,
 * (row1,column1) and (row2,column2) the one with the smallest row wins. In case
 * both moves have the same row, then the smaller column wins.
 * 
 * Example: Say moves (2,7) and (3,1) result in the maximum number of tokens for
 * this player. Then (2,7) is returned since 2 is the smaller row.
 * 
 * Example: Say moves (2,7) and (2,4) result in the maximum number of tokens for
 * this player. Then (2,4) is returned, since the rows are tied, but (2,4) has
 * the smaller column.
 * 
 * See the examples supplied in the assignment handout.
 * 
 * @author arnold
 *
 */

public class PlayerGreedy {

    private Othello othello;
    private char player;

    public PlayerGreedy(Othello othello, char player) {

        this.othello = othello;
        this.player = player;
    }


    public Move getMove() {
        HashMap<Integer , Move> best = new HashMap<Integer , Move>();
        for (int row = 0; row < othello.DIMENSION; row++) {
            for (int col = 0; col < othello.DIMENSION; col++) {
                int flips = othello.getFlipCount(row, col, player);
                if (flips > 0) {
                    best.put(flips, new Move(row, col));
                }
            }
        }
        Map.Entry<Integer , Move> bestEntry =
                Collections.max(best.entrySet(), Map.Entry.comparingByKey());
        int maxFlips = bestEntry.getKey();
        Move moveWithMostFlips = bestEntry.getValue();
        return moveWithMostFlips;
    }
}

