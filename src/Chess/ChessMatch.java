package Chess;

import java.util.ArrayList;
import java.util.List;

import Chess.pieces.King;
import Chess.pieces.Rook;
import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public class ChessMatch {
	private int turn;
	private  Color currentPlayer ;
	private Board board;
	private List <Piece> piecesOnTheBoard = new ArrayList();
	private List <Piece> capturedPieces = new ArrayList();
	
	public ChessMatch() {
		board= new Board(8, 8 );
		initialSetup();	
		turn=1;
		currentPlayer = Color.WHITE;
	}
	public int getTurn() {
		return turn;
	}
	public Color getCurrentPlayer () {
		return currentPlayer ;
	}
	
    public ChessPiece[][] getpieces(){	 
    	ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()] ;
    	for (int i=0; i<board.getRows(); i++) {
    		for (int j=0; j<board.getColumns(); j++) {
    			 mat[i][j] = (ChessPiece) board.piece(i,j);
    	 }
    		
    	 }
    	 return mat; 
     }
    public boolean [][]posibleMoves(ChessPosition sourceposition){
    	Position position =  sourceposition.toPosition();
    	validateSourcePosition(position);
    	return board.piece(position).possibleMoves();
    }
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        ChessPiece capturedPiece = (ChessPiece) makeMove(source, target);
        nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private Piece  makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placepiece(p, target);   
        if (capturedPiece != null ) {
        	piecesOnTheBoard.remove(capturedPiece);
        	capturedPieces.add(capturedPiece);
        }
        return capturedPiece;
    }  

    private void validateSourcePosition(Position position) {
        if (!board.thereIApiece(position)) {
            throw new ChessException("There is no piece on the source position");
        } 
        if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
        	throw new ChessException("the chosen piece i not yours");
        }
        
        if (!board.piece(position).isThereAnyPossiblemove()) {
        	throw new  ChessException("there  is no possible moves for the  chosen piece");
        }	
        }
        private void nextTurn() {
        	turn++;
        	currentPlayer= (currentPlayer== Color.WHITE) ? Color.BLACK : Color.WHITE;
        }
        
        
        
    
    		
    	
    	
   
    
	private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placepiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece);	
    }

  
    


    private  void initialSetup() {
    	placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}

    	 
    
    }


 	