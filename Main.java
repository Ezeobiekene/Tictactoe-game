

import java.util.Random;
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            char[][] board = {{'1', '2', '3'},
                              {'4', '5', '6'},
                              {'7', '8', '9'}};

            printBoard(board);

            while (true) {
                playerTurn(board, scanner);
                if (isGameFinished(board)){
                    break;
                }
                printBoard(board);

                computerTurn(board);
                if (isGameFinished(board)){
                    break;
                }
                printBoard(board);
            }
            scanner.close();
        }


        private static boolean isGameFinished(char[][] board) {

            if (didplayerWin(board, 'X')) {
                printBoard(board);
                System.out.println("Player wins!");
                return true;
            }

            if (didplayerWin(board, 'O')) {
                printBoard(board);
                System.out.println("Computer wins!");
                return true;
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if ((board[i][j] == '1')||
                          (board[i][j] == '2')||
                            (board[i][j] == '3')||
                            (board[i][j] == '4')||
                            (board[i][j] == '5')||
                            (board[i][j] == '6')||
                            (board[i][j] == '7')||
                            (board[i][j] == '8')||
                            (board[i][j] == '9')){
                        return false;
                    }
                }
            }
            printBoard(board);
            System.out.println("The game ended in a tie!");
            return true;
        }


        private static boolean didplayerWin(char[][] board, char symbol) {
            if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
                    (board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
                    (board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||

                    (board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
                    (board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
                    (board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||

                    (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
                    (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
                return true;
            }
            return false;
        }


        private static void computerTurn(char[][] board) {
            Random rand = new Random();
            int computer;
            while (true) {
                computer = rand.nextInt(9) + 1;
                if (isValidMove(board, Integer.toString(computer))) {
                    break;
                }
            }
            System.out.println("Computer chose " + computer);
            placeMove(board, Integer.toString(computer), 'O');
        }


        private static boolean isValidMove (char[][] board, String position) {
            switch(position) {
                case "1":
                    return (board[0][0] == '1');
                case "2":
                    return (board[0][1] == '2');
                case "3":
                    return (board[0][2] == '3');
                case "4":
                    return (board[1][0] == '4');
                case "5":
                    return (board[1][1] == '5');
                case "6":
                    return (board[1][2] == '6');
                case "7":
                    return (board[2][0] == '7');
                case "8":
                    return (board[2][1] == '8');
                case "9":
                    return (board[2][2] == '9');
                default:
                    return false;
            }
        }

        private static void playerTurn(char[][] board, Scanner scanner) {
            String userInput;
            while (true) {
                System.out.println("Where would you like to play? (1-9)");
                userInput = scanner.nextLine();
                if (isValidMove(board, userInput)){
                    break;
                } else {
                    System.out.println(userInput + " is not a valid move.");
                }
            }
            placeMove(board, userInput, 'X');
        }


        private static void placeMove(char[][] board, String position, char symbol) {
            switch(position) {
                case "1":
                    board[0][0] = symbol;
                    break;
                case "2":
                    board[0][1] = symbol;
                    break;
                case "3":
                    board[0][2] = symbol;
                    break;
                case "4":
                    board[1][0] = symbol;
                    break;
                case "5":
                    board[1][1] = symbol;
                    break;
                case "6":
                    board[1][2] = symbol;
                    break;
                case "7":
                    board[2][0] = symbol;
                    break;
                case "8":
                    board[2][1] = symbol;
                    break;
                case "9":
                    board[2][2] = symbol;
                    break;
                default:
                    System.out.println(":(");
            }
        }



        private static void printBoard(char[][] board) {
            System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
            System.out.println("-+-+-");
            System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
            System.out.println("-+-+-");
            System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
        }

    }

