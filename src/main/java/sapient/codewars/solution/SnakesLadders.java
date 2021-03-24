package sapient.codewars.solution;

import java.util.*;

public class SnakesLadders {
    HashMap<Integer, Integer> snake = new HashMap<Integer, Integer>();
    Integer sc0 = 0, sc1 = 0, curr_p = 0, old_p = 1;
    public SnakesLadders() {
        this.addValues();
    }

    public void addValues() {
        snake.put(16, 6);
        snake.put(46, 25);
        snake.put(49, 11);
        snake.put(62, 19);
        snake.put(64, 60);
        snake.put(74, 53);
        snake.put(89, 68);
        snake.put(92, 88);
        snake.put(95, 75);
        snake.put(99, 80);
        snake.put(2, 38);
        snake.put(7, 14);
        snake.put(8, 31);
        snake.put(15, 26);
        snake.put(21, 42);
        snake.put(28, 84);
        snake.put(36, 44);
        snake.put(51, 67);
        snake.put(71, 91);
        snake.put(78, 98);
        snake.put(87, 94);
    }

    public int update(int die) {
        if(snake.containsKey(die)) {
            return snake.get(die);
        }
        return die;
    }
    public int manage(int score) {
        if(score > 100) score = 100 - (score - 100);
        return update(score);
    }

    public String play(int die1, int die2) {
        if(sc0 == 100) {
            sc0 = 0;
            sc1 = 0;
            if(curr_p == 1) {
                curr_p = 0;
                old_p = 0;
                return "Game Over";
            }
            else {
                curr_p = 0;
                old_p = 0;
            }
                
        }
        if(sc1 == 100) {
            sc0 = 0;
            sc1 = 0;
            if(curr_p == 0) {
                curr_p = 1;
                old_p = 1;
                return "Game Over";
            }
            else {
                curr_p = 1;
                old_p = 1;
            }
        }
        int die = update(die1 + die2 + (curr_p == 0? sc0 : sc1));
        if(curr_p == 0) sc0 = die;
        else sc1 = die;
        old_p = curr_p;
        if(die1 != die2) {
            curr_p = (curr_p + 1) % 2;
        }
        sc0 = manage(sc0);
        sc1 = manage(sc1);
        if(old_p == 0) {
            if(sc0 == 100) {
                return "Player "  + (old_p + 1) + " won";
            }
            else {
                return "Player " + (old_p + 1) + " is on square " + sc0;
            }
        }
        else if(old_p == 1) {
            if(sc1 == 100) {
                return "Player "  + (old_p + 1) + " won";
            }
            else {
                return "Player " + (old_p + 1) + " is on square " + sc1;
            }
        }

        return "";
    }
}