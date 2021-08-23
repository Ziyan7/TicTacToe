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
	
	//@parameter index to ask user where to mark X or O
	public static int index;
				
	/*method for initializing the board
	 * It will initialize the board values with space
	 */
	public static void TicTacToeBoard() { 
		for (int i=1; i<board.length ; i++) {
			board[i]= ' ';                      //Adding Space
		}
	}
	
	//@method to display the contents of board in table format
	public static void showBoard()
	{
		System.out.println("|---|---|---|");
		System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |"); //display first row
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |"); //display second row
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |"); //display third row
		System.out.println("|---|---|---|");
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
	
	public static void desiredLocation()
	{
		
		index=sc.nextInt();
		if(index<1 || index>9)					//To check if the index is between 1 and 9
		{
			System.out.println("Please enter the index value between 1 and 9");
			desiredLocation();
		}
		
	}
	
	//Main Function
	public static void main(String[] args) {
		System.out.println("Welcome"); //Welcome Message
		TicTacToeGame obj = new TicTacToeGame();
		obj.TicTacToeBoard(); //initializing the Board
		turn='p';	//assuming that its players turn to play
		inputChar();   //@method to enter input X or O
		showBoard(); // @method to display entire board
		System.out.println("Enter the index to move to desired cell");
		
		desiredLocation();          			//@method to get desired index from the player
		
	}

}