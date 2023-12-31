package Application;

import Chess.ChessPiece;


public class UI {
    public static void PrintBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces[i].length; j++) {
                PrintPiece(pieces[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void PrintPiece(ChessPiece piece) {
        if (piece == null) {
            System.out.print("- ");
        } else {
            System.out.print(piece + " ");
        }
    }
}
