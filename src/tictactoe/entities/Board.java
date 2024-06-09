package tictactoe.entities;

import tictactoe.entities.pieces.PlayingPiece;
import tictactoe.enums.PieceType;

public class Board {
    int size;
    PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public void setPiece(int x, int y, PlayingPiece playingPiece) {
        validateMove(x, y);
        board[x][y] = playingPiece;
    }

    private void validateMove(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            throw new IllegalArgumentException("Invalid move");
        }
    }

    public Boolean isWinner(int row, int column, PieceType pieceType) {
        boolean rowMatch = Boolean.TRUE;
        boolean columnMatch = Boolean.TRUE;
        boolean diagonalMatch = Boolean.TRUE;
        boolean antidagonalMatch = Boolean.TRUE;
        for (int i = 0; i < size; i++) {
            if (board[row][i] == null || board[row][i].getPieceType() != pieceType) {
                rowMatch = Boolean.FALSE;
                break;
            }
        }

        for (int i = 0; i < size; i++) {
            if (board[i][column] == null || board[i][column].getPieceType() != pieceType) {
                columnMatch = Boolean.FALSE;
                break;
            }
        }

        for (int i = 0; i < size; i++) {
            if (board[i][i] == null || board[i][i].getPieceType() != pieceType) {
                diagonalMatch = Boolean.FALSE;
                break;
            }
        }

        for (int i = 0 ; i < size; i++){
            if (board[i][size - i - 1] == null || board[i][size - i - 1].getPieceType() != pieceType) {
                antidagonalMatch = Boolean.FALSE;
                break;
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antidagonalMatch;
    }

    public void printBoard() {
        for (int i = 0 ; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] == null ? "_ " : (board[i][j].getPieceType()) + " ");
            }
            System.out.println();
        }
    }
}
