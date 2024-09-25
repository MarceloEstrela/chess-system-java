package Application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
import Chess.Color;

public class UI {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine().trim(); // Remove espaços extras
            if (s.length() < 2) {
                throw new InputMismatchException("Error reading chess position. Valid values are from a1 to h8");
            }

            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));

            if (column < 'a' || column > 'h' || row < 1 || row > 8) {
                throw new InputMismatchException("Error reading chess position. Valid values are from a1 to h8");
            }

            return new ChessPosition(column, row);
        } catch (NumberFormatException e) {
            throw new InputMismatchException("Error reading chess position. The row must be a number between 1 and 8");
        } catch (StringIndexOutOfBoundsException e) {
            throw new InputMismatchException("Error reading chess position. The position must be in the format 'a1' to 'h8'");
        }
    }
	    public static void  prinMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
	    	PrintBoard(chessMatch.getpieces());
	    	System.out.println();
	    	printCpturedPieces(captured);
	    	System.out.println();
	    	System.out.println("turn : "  + chessMatch.getTurn());
	    	System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
	    	
	    	
	    	
	    }

    public static void PrintBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces[i].length; j++) {
                printPiece(pieces[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    public static void PrintBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces[i].length; j++) {
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece, boolean background) {
        if (background) {
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        } else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" " + ANSI_RESET); // Ensure the background and text color are reset
    }
    private static void printCpturedPieces(List<ChessPiece> captured) {
    	List<ChessPiece> whit = captured.stream().filter(x -> x.getColor()== Color.WHITE).collect(Collectors.toList());
    	List<ChessPiece> black = captured.stream().filter(x -> x.getColor()== Color.BLACK).collect(Collectors.toList());
    	System.out.println("Captured piece");
    	System.out.print("White: " );
    	System.out.print(ANSI_WHITE);
    	System.out.println(Arrays.toString(whit.toArray()));
    	System.out.println(ANSI_RESET);
    	System.out.print("Black: " );
    	System.out.print(ANSI_YELLOW	);
    	System.out.println(Arrays.toString(black.toArray()));
    	System.out.println(ANSI_RESET);
    	
    	
    	
    	
    	
    	 
    	
    	
    	
    	
    	
    	
    	
    	
    }
}

