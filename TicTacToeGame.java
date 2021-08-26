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
	public static char choiceP;     	
	public static char choiceC;  
	
	 /*@parameter turn to check whose turn to play
	  * turn can be player and computer
	  * turn=c means computer, turn=p means player 
	  */
	public static char turn; 
	
	//@parameter index to ask user where to mark X or O
	public static int index;
	
	//@parameter winner to check the winner
	public static String winner="no"; 
				
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
		System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |"); //display first row
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |"); //display second row
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |"); //display third row
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
			choiceP=sc.next().charAt(0);
			if (choiceP=='X') {
				choiceC='O';
			}
		}
		else
		{
			
			if (rand.nextInt(2)==0) {
				choiceC='X';
				choiceP='0';
				System.out.println("X"); 
			}
			else {
				choiceC='O';
				choiceP='X';
				System.out.println("O");
			}
		}
	}
	
	public static void desiredLocation()
	{
		
		if(turn=='c') {
			index =rand.nextInt(9)+1;
			
		}
		else
		{	
			System.out.println("Enter the Cell location");
			index=sc.nextInt();
			if(index<1 || index>9)					//To check if the index is between 1 and 9
			{
				System.out.println("Please enter the index value between 1 and 9");
				desiredLocation();
			}
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
			if (turn=='p') {
				board[index]=choiceP;
			}
			else {
				
				board[index]=choiceC;
			}
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
	
	/*@method to check for winner
	 * Checks if there is XXX or OOO pattern in horizontal or vertical or diagonal direction
	 * if the pattern exists then there is a winner
	 * Then checks if all the values are filled and if yes, its a draw or else next person plays
	 */
	
	public	static void checkWinner()
    {
		
		//to check if there is a winning pattern
        for (int check = 1; check < 9; check++) 
        {
            String line = null;
  
            switch (check) {
            case 1:
                line = ""+board[1] + board[2] + board[3]; //Horizontal check for the pattern
                break;
            case 2:
                line = ""+board[4] + board[5] + board[6];
                break;
            case 3:
                line = ""+board[7] + board[8] + board[9];
                break;
            case 4:
                line = ""+board[1] + board[4] + board[7]; //Vertical check for the pattern
                break;
            case 5:
                line = ""+board[2] + board[5] + board[8];
                break;
            case 6:
                line = ""+board[3] + board[5] + board[9];
                break;
            case 7:
                line = ""+board[1] + board[5] + board[9]; //Diagonal check for the pattern
                break;
            case 8:
                line = ""+board[3] + board[5] + board[7];
                break;
            }
            //to check the winner winner
            if (line.equals("XXX")||line.equals("OOO")) {
                winner="yes";
            }
              
         }
        int i=1;
        for(i=1;i<board.length;i++)
        {
        	if(board[i]==' ')
        		break;
        }
        if(i==10)
        	winner="draw";
        if(winner=="yes")						//check for winner
		{
			if(turn=='p')
				System.out.println("Player has won the game");
			else
				System.out.println("Computer has won the game");
		}
		else if(winner=="draw")								//check for tie
		{
			System.out.println( "It's a draw! Thanks for playing.");
		}
		else													//change the turn
		{
			if(turn=='c')
			{
				turn='p';
				System.out.println("Players turn to play");
			}
			else
			{
				turn='c';
				System.out.println("Computers turn to play");
			}
				
		}
  
    }    
	
	public static void computerTry()
	{
   
		System.out.println("Computer is playing");	
		if((board[1]==' ')&&(board[2]==board[3]&&board[2]==choiceC)||(board[4]==board[7]&&board[4]==choiceC)||(board[5]==board[9]&&board[5]==choiceC))
		{
			board[1]=choiceC;			
		}
		else if((board[2]==' ')&&(board[1]==board[3]&&board[3]==choiceC)||(board[5]==board[8]&&board[8]==choiceC))
		{
			board[2]=choiceC;
		}
		else if((board[3]==' ')&&(board[1]==board[2]&&board[2]==choiceC)||(board[6]==board[9]&&board[9]==choiceC)||(board[5]==board[7]&&board[7]==choiceC))
		{
			board[3]=choiceC;
		}
		else if((board[4]==' ')&&(board[1]==board[7]&&board[1]==choiceC)||(board[5]==board[6]&&board[6]==choiceC))
		{
			board[4]=choiceC;
		}
		else if((board[5]==' ')&&(board[1]==board[9]&&board[2]==choiceC)||(board[7]==board[3]&&board[7]==choiceC)||(board[2]==board[8]&&board[8]==choiceC)||(board[4]==board[6]&&board[6]==choiceC))
		{
			board[5]=choiceC;
		}
		else if((board[6]==' ')&&(board[9]==board[3]&&board[3]==choiceC)||(board[5]==board[4]&&board[4]==choiceC))
		{
			board[6]=choiceC;
		}
		else if((board[7]==' ')&&(board[1]==board[4]&&board[4]==choiceC)||(board[3]==board[5]&&board[3]==choiceC)||(board[8]==board[9]&&board[8]==choiceC))
		{
			board[3]=choiceC;
		}
		else if((board[8]==' ')&&(board[9]==board[7]&&board[7]==choiceC)||(board[2]==board[5]&&board[2]==choiceC))
		{
			board[8]=choiceC;
		}
		else if((board[9]==' ')&&(board[1]==board[5]&&board[5]==choiceC)||(board[6]==board[3]&&board[3]==choiceC)||(board[8]==board[7]&&board[7]==choiceC))
		{
			board[9]=choiceC;
		}
		//blocking players victory condition
		else if((board[1]==' ')&&(board[2]==board[3]&&board[2]==choiceP)||(board[4]==board[7]&&board[4]==choiceP)||(board[5]==board[9]&&board[5]==choiceP))
		{
			board[1]=choiceC;	
		}
		else if((board[2]==' ')&&(board[1]==board[3]&&board[3]==choiceP)||(board[5]==board[8]&&board[8]==choiceP))
		{
			board[2]=choiceC;
		}
		else if((board[3]==' ')&&(board[1]==board[2]&&board[2]==choiceP)||(board[6]==board[9]&&board[9]==choiceP)||(board[5]==board[7]&&board[7]==choiceP))
		{
			board[3]=choiceC;
		}
		else  if((board[4]==' ')&&(board[1]==board[7]&&board[1]==choiceP)||(board[5]==board[6]&&board[6]==choiceP))
		{
			board[4]=choiceC;
		}	
		else if((board[5]==' ')&&(board[1]==board[9]&&board[2]==choiceP)||(board[7]==board[3]&&board[7]==choiceP)||(board[2]==board[8]&&board[8]==choiceP)||(board[4]==board[6]&&board[6]==choiceP))
		{
			board[5]=choiceC;
		}
		else if((board[6]==' ')&&(board[9]==board[3]&&board[3]==choiceP)||(board[5]==board[4]&&board[4]==choiceP))
		{
			board[6]=choiceC;
		}
		else 	if((board[7]==' ')&&(board[1]==board[4]&&board[4]==choiceP)||(board[6]==board[9]&&board[9]==choiceP)||(board[5]==board[7]&&board[7]==choiceP))
		{
			board[7]=choiceC;
		}
		else if((board[8]==' ')&&(board[9]==board[7]&&board[7]==choiceP)||(board[2]==board[5]&&board[2]==choiceP))
		{
			board[8]=choiceC;
		}
		else if((board[9]==' ')&&(board[1]==board[5]&&board[5]==choiceP)||(board[6]==board[3]&&board[3]==choiceP)||(board[8]==board[7]&&board[7]==choiceP))
		{	
			board[9]=choiceC;
		}
	   	else {
	   		desiredLocation();			
		}
		showBoard();
		;
	}
	
	//Main Function
	public static void main(String[] args) {
		System.out.println("Welcome"); //Welcome Message
		TicTacToeBoard(); //initializing the Board
		toss();
		inputChar();
		while(winner=="no" || winner=="draw")
		 {
			if(turn=='p') {
				  
				 
				desiredLocation(); 
				desiredMove(); 
				checkWinner();
				turn='c';
			}
			else {
				
				computerTry(); 
				desiredMove();
				checkWinner();
				turn='p';
			}
		}
		
	}

}