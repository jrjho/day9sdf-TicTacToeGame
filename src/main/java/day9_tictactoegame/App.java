package day9_tictactoegame;

import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        String[] tttBoard = new String[9];
        String player = "X";
        String winner = "";

        for (int i = 0; i < 9; i++) {
            tttBoard[i] = String.valueOf(i + 1);
        }
        tictactoe ttt = new tictactoe();
        ttt.printBoard(tttBoard);

        System.out.println("Tic-Tac-Toe game");
        System.out.println("----------------");
        System.out.println("X will play first");

        Scanner scanner = new Scanner(System.in);

        while (winner == "") {
            Integer input;
            input = scanner.nextInt();

            // check if input is 1 ~ 10
            if ((input > 0) && (input < 10)) {

            } else {
                System.out.println("Invalid input!");
                continue;
            }

            // detect the next player turn
            if (tttBoard[input - 1].equals(String.valueOf(input))) {
                tttBoard[input - 1] = player;

                if (player.equals("X"))
                    player = "O";
                else
                    player = "X";

                ttt.printBoard(tttBoard);
                winner = ttt.checkWinner(tttBoard);
            } else
                System.out.println("Slot already taken; re-enter slot number:");

        }
        
        if(winner!=null){
        if (winner.equalsIgnoreCase("X"))
            System.out.println("Player X is the winner!");
        else
            System.out.println("Player O is the winner!");
        }
        scanner.close();

    }

}
