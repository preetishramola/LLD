package TicTacToe;

import TicTacToe.model.*;
//import org.antlr.v4.runtime.misc.Pair;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class TicTacToeGame {
    
        Deque<Player> players;
        Board gameBoard;
        Player winner;
    
    
        public void initializeGame() {
    
            // Creating 2 Players
            players = new LinkedList<>();
            PlayingPieceX crossPiece = new PlayingPieceX();
            Player player1 = new Player("Player1", crossPiece);
    
            PlayingPieceO noughtsPiece = new PlayingPieceO();
            Player player2 = new Player("Player2", noughtsPiece);
    
            players.add(player1);
            players.add(player2);
    
            // Initialize Board of size 3
            gameBoard = new Board(3);
        }
    
        @SuppressWarnings("resource")
        public GameStatus startGame() {
    
            boolean noWinner = true;
            while (noWinner) {
    
                // Remove the player whose turn is and also put the player in the list back
                Player currentPlayer = players.removeFirst();
    
                // Get the free space from the board
                gameBoard.printBoard();
                List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();
                if (freeSpaces.isEmpty()) {
                    noWinner = false;
                    continue;
                }
    
                // Read the user input
                System.out.print("Player: " + currentPlayer.getName() + " - Please enter [row, column]: ");
                @SuppressWarnings("resource")
                Scanner inputScanner = new Scanner(System.in);
                String s = inputScanner.nextLine();
                String[] values = s.split(",");
                int inputRow = Integer.valueOf(values[0]);
                int inputColumn = Integer.valueOf(values[1]);
    
    
                // Place the piece in the board
                boolean validMove = gameBoard.addPiece(inputRow, inputColumn, currentPlayer.getPlayingPiece());
                if (!validMove) {
                    // Invalid Move: Player can not insert the piece into this cell, player has to choose another cell
                    System.out.println("Incorrect position chosen, try again!");
                    players.addFirst(currentPlayer); // Add the player back to the queue(in the front)
                    continue;
                }
                players.addLast(currentPlayer); // Add the player to the end of the queue

                // Check if the valid move is a winning move or not
                boolean isWinner = checkForWinner(inputRow, inputColumn, currentPlayer.getPlayingPiece().getPieceType());
                if (isWinner) {
                    gameBoard.printBoard();
                    winner = currentPlayer;
                    return GameStatus.WIN;
                }
            }
    
            return GameStatus.DRAW;
        }
    
        public boolean checkForWinner(int row, int column, PieceType pieceType) {
    
            boolean rowMatch = true;
            boolean columnMatch = true;
            boolean diagonalMatch = true;
            boolean antiDiagonalMatch = true;
    
            // Check Row
for (int i = 0; i < gameBoard.getSize(); i++) {
                if (gameBoard.getPiece(row, i) == null || gameBoard.getPiece(row, i).getPieceType() != pieceType) {
                    rowMatch = false;
                    break;
                }
            }

            // Check Column
            for (int i = 0; i < gameBoard.getSize(); i++) {
                if (gameBoard.getPiece(i, column) == null || gameBoard.getPiece(i, column).getPieceType() != pieceType) {
                    columnMatch = false;
                    break;
                }
            }

            // Check Diagonally
            for (int i = 0, j = 0; i < gameBoard.getSize(); i++, j++) {
                if (gameBoard.getPiece(i, j) == null || gameBoard.getPiece(i, j).getPieceType() != pieceType) {
                    diagonalMatch = false;
                    break;
                }
            }

            // Check Anti-Diagonally
            for (int i = 0, j = gameBoard.getSize() - 1; i < gameBoard.getSize(); i++, j--) {
                if (gameBoard.getPiece(i, j) == null || gameBoard.getPiece(i, j).getPieceType() != pieceType) {
                    antiDiagonalMatch = false;
                    break;
                }
            }
    
            return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
        }
    
}


