import java.util.*;

public class Main {
    static char[][] board = {
            {'1', '|', '2', '|', '3'},
            {'-', '+', '-', '+', '-'},
            {'4', '|', '5', '|', '6'},
            {'-', '+', '-', '+', '-'},
            {'7', '|', '8', '|', '9'},
    };
    static int moves = 0;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {

        Random random = new Random();
        Scanner in = new Scanner(System.in);

        System.out.println("*** Welcome ***");
        System.out.println("Play with:\n\t1)Friend:\n\t2)Computer:\n\t");
        int player = in.nextInt();

        if (player == 1){
            System.out.println("Enter player1 name: ");
            String player1 = in.next();
            System.out.println("Enter player2 name: ");
            String player2 = in.next();

            while (moves <= 9) {
                printBoard();

                System.out.println(player1 + " >>>");
                int loc = in.nextInt();
                while (set.contains(loc)){
                    System.out.println("\n'" + player1.toUpperCase() + "' Fill right box >>>");
                    loc = in.nextInt();
                }
                set.add(loc);
                play('P', loc);

                int win = win();

                if (win > 0){
                    printBoard();
                    winner(win, player1, player2);
                    break;
                }

                printBoard();
                System.out.println(player2 + " >>>");
                loc = in.nextInt();
                while (set.contains(loc)){
                    System.out.println("\n'" + player2.toUpperCase() + "' Fill right box >>>");
                    loc = in.nextInt();
                }
                set.add(loc);
                play('Q', loc);

                win = win();

                if (win > 0){
                    printBoard();
                    winner(win, player1, player2);
                    break;
                }
            }
        }

        else if (player == 2) {
            System.out.println("Enter your name: ");
            String user = in.next();
            String computer = "Computer";

            while (moves <= 9) {
                printBoard();

                System.out.println(user + " >>>");
                int loc = in.nextInt();

                while (set.contains(loc)){
                    System.out.println("\n'" + user.toUpperCase() + "' Fill right box >>>");
                    loc = in.nextInt();
                }
                set.add(loc);
                play('P', loc);

                loc = random.nextInt(9);
                while (set.contains(loc)){
//                System.out.println("\nFill right box >>>");
                    loc = random.nextInt(9);
                }
                set.add(loc);
                play('Q', loc);

                int win = win();

                if (win > 0){
                    printBoard();
                    winner(win, user, computer);
                    break;
                }
            }
        }
    }

    private static void winner(int win, String player1, String player2) {
        char winner = ' ';
        if (win == 1 || win == 4 || win == 7){
            winner = board[0][0];
        }
        else if (win == 2 || win == 5){
            winner = board[2][2];
        }
        else if (win == 3 || win == 8)
            winner = board[4][0];
        else if (win == 6)
            winner = board[0][4];

        if (winner == 'X') {
            System.out.println("Congratulations :) " + player1);
            System.out.println("Sorry :( " + player2);
        }
        if (winner == '0'){
            System.out.println("Congratulations :) " + player2);
            System.out.println("Sorry :( " + player1);
        }
    }

    private static int win() {
        if(board[0][0] == board[0][2] && board[0][0] == board[0][4])
            return 1;
        else if (board[2][0] == board[2][2] && board[2][0] == board[2][4])
            return 2;
        else if (board[4][0] == board[4][2] && board[4][0] == board[4][4])
            return 3;
        else if (board[0][0] == board[2][0] && board[0][0] == board[4][0])
            return 4;
        else if(board[0][2] == board[2][2] && board[0][2] == board[4][2])
            return 5;
        else if (board[0][4] == board[2][4] && board[0][4] == board[4][4])
            return 6;

        else if (board[0][0] == board[2][2] && board[0][0] == board[4][4])
            return 7;
        else if (board[0][4] == board[2][2] && board[0][4] == board[4][0])
            return 8;

        return -1;
    }

    private static void printBoard(){

        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void play(char player, int loc){
        int x = 0;
        int y = 0;

        if (loc != 1) {
            if (loc == 2){
                //            x = 0;
                y = 2;
            } else if (loc == 3){
                //            x = 0;
                y = 4;
            } else if (loc == 4){
                x = 2;
                //            y = 0;
            } else if (loc == 5){
                x = 2;
                y = 2;
            } else if (loc == 6){
                x = 2;
                y = 4;
            } else if (loc == 7){
                x = 4;
                //            y = 0;
            } else if (loc == 8){
                x = 4;
                y = 2;
            } else if (loc == 9){
                x = 4;
                y = 4;
            }
        }

        if (player == 'P')
            board[x][y] = 'X';
        else
            board[x][y] = '0';

        moves++;
    }
}