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
	
	/*@method moves to desired location
	 * checks if the space is free
	 * ability to make a move to desired location
	 */
	public static void desiredMove()
	{
		if(board[index]==' ')					//check if the index is free
		{
			board[index]=choice;
		}
		else
		{
			System.out.println("Current cell is already Filled. Please enter different index No.");
			desiredLocation();					//@call desired location method
			desiredMove();
		}
		showBoard();
	}
	public static void toss()
	{
		System.out.println("Player select head(0) or tail(1)");
		int selected=sc.nextInt();							//class member for storing choice of the player
		/* a random number is chosen between 1 or 0
		 * if its 0 then head or if it is 1 its tail
		 */
		int randnum=rand.nextInt(2);						
		if(selected==randnum)
		{
			System.out.println("Its player's turn");
			turn='p';
			
		}
		else
		{
			System.out.println("Its computer's turn");
			turn='c';
		}
	}
	
	//Main Function
	public static void main(String[] args) {
		System.out.println("Welcome"); //Welcome Message
		TicTacToeGame obj = new TicTacToeGame();
		obj.TicTacToeBoard(); //initializing the Board
		toss();									 //@method to perform toss
		inputChar();   //@method to enter input X or O
		showBoard(); // @method to display entire board
		System.out.println("Enter the index to move to desired cell");
		
		desiredLocation();          			//@method to get desired index from the player
		desiredMove();     						//@method to move to the desired cell
		
	}

}