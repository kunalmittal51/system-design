package tictactoe;

import tictactoe.entities.Board;
import tictactoe.entities.players.Player;
import tictactoe.entities.pieces.PlayingPiece;
import tictactoe.enums.PieceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        int totalPlayers = 2;
        List<Player> playerList = buildPlayers(totalPlayers);

        int boardSize = 3;
        Board board = new Board(boardSize);

        int maxMoves = boardSize*boardSize;

        board.printBoard();
        for (int i = 0 ; i < maxMoves; i++) {
            Player player = getPlayerToMove(i, playerList);
            PlayingPiece playingPiece = player.getPlayingPiece();
            System.out.print("Player:" + player.getName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            board.setPiece(Integer.parseInt(values[0]), Integer.parseInt(values[1]), playingPiece);
            board.printBoard();
            if (Boolean.TRUE.equals(board.isWinner( Integer.parseInt(values[0]) , Integer.parseInt(values[1]), playingPiece.getPieceType()))) {
                System.out.println(player.getName() + " wins!");
                break;
            }
        }
        System.out.println("Game over!");
    }

    public static List<Player> buildPlayers(int size) {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("Player1", new PlayingPiece(PieceType.X)));
        playerList.add(new Player("Player2", new PlayingPiece(PieceType.O)));
        return playerList;
    }

    public static Player getPlayerToMove(int moveNumber, List<Player> playerList) {
        return playerList.get(moveNumber % playerList.size());
    }
}
