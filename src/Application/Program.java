package Application;

import java.util.InputMismatchException;
import java.util.Scanner;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;


public class Program {
  public static void main(String[] args) {
	  Scanner sc = new Scanner (System.in);
	ChessMatch chessMatch= new ChessMatch();
		while(true) {
	try {
		UI.clearScreen();
		UI.PrintBoard(chessMatch.getpieces());
		System.out.println();
		System.out.println("source");	
		ChessPosition source = UI.readChessPosition(sc);
		
		boolean [][] possibleMoves = chessMatch.posibleMoves(source);
		UI.clearScreen();
		UI.PrintBoard(chessMatch.getpieces(), possibleMoves);
		
				
		
		 System.out.println();
		 System.out.println("target ");
		 ChessPosition target = UI.readChessPosition(sc);
		 
		 ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
	}
		 catch  (ChessException e) {
			 System.out.println(e.getMessage());
			 sc.nextLine();
		 }
	     catch  (InputMismatchException   e) {
		 System.out.println(e.getMessage());
		 sc.nextLine();
	}
	
	
}
  }
}
