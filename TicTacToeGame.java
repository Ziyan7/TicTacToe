package TicTacToe;

import java.util.*;
public class TicTacToeGame {
	//To get input from the console
	public static Scanner sc=new Scanner(System.in);
	
	//to get a random value 
	public static Random rand=new Random();
	
	//@array to store board values
	public static char[] board= new char[10];  
	
	 //@parameter choice store whether the value is X or O
	public static char choice;     			  
	
	 /*@parameter turn to check whose turn to play
	  * turn can be player and computer
	  * turn=c means computer, turn=p means player 
	  */
	public static char turn; 
				
	/*method for initializing the board
	 * It will initialize the board values with space
	 * Use case 1 :create a new board game and initialize the values to ' '
	 */
	
	
	public static void TicTacToeBoard() { 
		char board[] = new char[10];
		for (int i=1; i<board.length ; i++) {
			board[i]= ' ';                      //Adding Space
		}
	}
	
	/*@method to get input value X or O from the player
	 * if its computers turn to play select a random number 0 or 1 
	 * 0 means input is X or else O
	 */
	
	public static void inputChar()
	{
		if(turn=='p')
		{
			System.out.println("Enter the input(X or O) ");
			choice=sc.next().charAt(0);
		}
		else
		{
			if (rand.nextInt(2)==0) {
				choice='X';
				System.out.println("X"); 
			}
			else {
				choice='O';
				System.out.println("O");
			}
		}
	}

	//Main Function
	public static void main(String[] args) {
		System.out.println("Welcome"); //Welcome Message
		TicTacToeGame obj = new TicTacToeGame();
		obj.TicTacToeBoard(); //initializing the Board
		turn='0';	//assuming that its players turn to play
		inputChar();   //@method to enter input X or O
	}

}