package TicTacToe;


public class TicTacToeGame {
	
	public static void TicTacToeBoard() {
		char board[] = new char[10];
		for (int i=1; i<board.length ; i++) {
			board[i]= ' ';                      //Adding Space
		}
	}
	
	//Main Function
	public static void main(String[] args) {
		System.out.println("Welcome");             //Welcome Message
		
		TicTacToeGame obj= new TicTacToeGame();    //object creation
		obj.TicTacToeBoard();
	}

}