package Application;

import java.util.Scanner;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;


public class Program {
  public static void main(String[] args) {
	  Scanner sc = new Scanner (System.in);
	ChessMatch chessMatch= new ChessMatch();
	while(true) {
	UI.PrintBoard(chessMatch.getpieces());
	System.out.println();
	System.out.println("source");
	ChessPosition source = UI.readChessPosition(sc);
	 System.out.println();
	 System.out.println("target ");
	 ChessPosition target = UI.readChessPosition(sc);
	 ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
 
	
}
  }
}
