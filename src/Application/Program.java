package Application;

import Chess.ChessMatch;


public class Program {
  public static void main(String[] args) {
	 
	ChessMatch chessMatch= new ChessMatch();
	UI.PrintBoard(chessMatch.getpieces());
	
}
}
