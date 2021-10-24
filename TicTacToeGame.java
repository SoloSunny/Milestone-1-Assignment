/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solomonkudus.milestone1assignment;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Solomon Kudus
 */

/*
Write an application which plays the game Tic-Tac-Toe which one human player and 
one computer player. The game should randomly choose who starts first, and 
the board should be stored in a 3x3 array and displayed to the user between moves. 
When someone wins, the user should be asked if they want to play again. 
If they choose yes, the board should reset and another game should be played, 
again randomly picking who starts first.
*/  

public class TicTacToeGame {
    
    static int playerScore = 0;
    static int computerScore = 0;
    static int tieScore = 0;
    static Scanner input = new Scanner(System.in);
    private static Object inputReader;


public static void main(String [] args){

    //The game board 3x3 array stored
    
    char [][] gameBoard = {{'_','|','_','|','_'},{'_', '|', '_','|','_'},{' ','|',' ','|',' '}};
    printBoard(gameBoard);
    
       
    boolean gameOver = false;
    boolean playAgain = true;

  while(playAgain) {
      while (!gameOver) {
          System.out.println("*~< TIC TAC TOE GAME >~*");
          playerMove(gameBoard);
          gameOver = isGameOver(gameBoard);
          if (gameOver) {
              break;
          }

          computerMove(gameBoard);
          gameOver = isGameOver(gameBoard);
          if (gameOver) {
              break;
          }
      }
      System.out.println("Player Score: " +playerScore);
      System.out.println("Computer Score: "+ computerScore);
      System.out.println("Tie Score: "+ tieScore);
      System.out.println("Would you like to play again? Y/N");
      input.nextLine();
      String result = input.nextLine();

      switch (result){
          case "y":
          case "Y":
              
              playAgain = true;
              System.out.println("Let's play again");
              resetBoard(gameBoard);
              gameOver = false;
              printBoard(gameBoard);
              break;

          case "n":
          case "N":
              playAgain = false;
              System.out.println("Thanks for playing, See you soon!");
              break;
          default:
              break;
      }

  }
}


public static void printBoard(char [][] gameBoard){

    for(char[] row : gameBoard){
        for( char c : row){
            System.out.print(c);
        }
        System.out.println();
    }
}

    //Positioning the character

public static void updateBoard( int position, int player, char [][] gameBoard){

        char character;

        if(player==1){
            character = 'X';
        }else{
            character = 'O';
        }

        switch (position){

            case 1:
                gameBoard[0][0] = character;
                printBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][2] = character;
                printBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][4] = character;
                printBoard(gameBoard);
                break;
            case 4:
                gameBoard[1][0] = character;
                printBoard(gameBoard);
                break;
            case 5:
                gameBoard[1][2] = character;
                printBoard(gameBoard);
                break;
            case 6:
                gameBoard[1][4] = character;
                printBoard(gameBoard);
                break;
            case 7:
                gameBoard[2][0] = character;
                printBoard(gameBoard);
                break;
            case 8:
                gameBoard[2][2] = character;
                printBoard(gameBoard);
                break;
            case 9:
                gameBoard[2][4] = character;
                printBoard(gameBoard);
                break;
            default:
                break;

        }

}


public static void playerMove(char[][] gameBoard){

    System.out.println("Please make a move. Choose from 1 to 9");


    int move = input.nextInt();

    boolean result = isValidMove(move,gameBoard);

    while(!result){
        System.out.println("Sorry! It's invalid move. Try again");
        move = input.nextInt();
        result = isValidMove(move,gameBoard);
    }

    System.out.println("Player moved at position " + move);
    updateBoard(move,1,gameBoard);


}


public static boolean isValidMove(int move, char[][] gameboard){

    switch (move){
        case 1:
        return gameboard[0][0] == '_';

        case 2:
        return gameboard[0][2] == '_';

        case 3:
        return gameboard[0][4] == '_';


        case 4:
        return gameboard[1][0] == '_';

        case 5:
        return gameboard[1][2] == '_';

        case 6:
        return gameboard[1][4] == '_';

        case 7:
        return gameboard[2][0] == ' ';

        case 8:
        return gameboard[2][2] == ' ';

        case 9:
        return gameboard[2][4] == ' ';


        default:
            return false;
    }

}

public static void computerMove(char [][] gameBoard){

    Random rand = new Random();
    int move = rand.nextInt(9)+1;

    boolean result = isValidMove(move,gameBoard);

    while(!result){
        move = rand.nextInt(9)+1;
        result = isValidMove(move, gameBoard);
    }

    System.out.println("Computer moved at position "+ move);
    updateBoard(move,2,gameBoard);
}


public static boolean isGameOver(char [][] gameboard){

    //Horizontal Wins
    
    if(gameboard[0][0] == 'X'&& gameboard[0][2] == 'X' && gameboard [0][4] == 'X' ){
        System.out.println("PLAYER WINS");
        playerScore++;
        return true;
    }
    if(gameboard[0][0] == 'O'&& gameboard[0][2] == 'O' && gameboard [0][4] == 'O' ){
        System.out.println("COMPUTER WINS");
        computerScore++;
        return true;
    }
    if(gameboard[1][0] == 'X'&& gameboard[1][2] == 'X' && gameboard [1][4] == 'X' ){
        System.out.println("PLAYER WINS");
        playerScore++;
        return true;
    }
    if(gameboard[1][0] == 'O'&& gameboard[1][2] == 'O' && gameboard [1][4] == 'O' ){
        System.out.println("COMPUTER WINS");
        computerScore++;
        return true;
    }
    if(gameboard[2][0] == 'X'&& gameboard[2][2] == 'X' && gameboard [2][4] == 'X' ){
        System.out.println("PLAYER WINS");
        playerScore++;
        return true;
    }
    if(gameboard[2][0] == 'O'&& gameboard[2][2] == 'O' && gameboard [2][4] == 'O' ) {
        System.out.println("COMPUTER WINS");
        computerScore++;
        return true;
    }

    //Vertical Wins

        if(gameboard[0][0] == 'X'&& gameboard[1][0] == 'X' && gameboard [2][0] == 'X' ){
            System.out.println("PLAYER WINS");
            playerScore++;
            return true;
        }
        if(gameboard[0][0] == 'O'&& gameboard[1][0] == 'O' && gameboard [2][0] == 'O' ){
            System.out.println("COMPUTER WINS");
            computerScore++;
            return true;
        }

        if(gameboard[0][2] == 'X'&& gameboard[1][2] == 'X' && gameboard [2][2] == 'X' ){
            System.out.println("PLAYER WINS");
            playerScore++;
            return true;
        }
        if(gameboard[0][2] == 'O'&& gameboard[1][2] == 'O' && gameboard [2][2] == 'O' ){
            System.out.println("COMPUTER WINS");
            computerScore++;
            return true;
        }

        if(gameboard[0][4] == 'X'&& gameboard[1][4] == 'X' && gameboard [2][4] == 'X' ){
            System.out.println("PLAYER WINS");
            playerScore++;
            return true;
        }
        if(gameboard[0][4] == 'O'&& gameboard[1][4] == 'O' && gameboard [2][4] == 'O' ){
            System.out.println("COMPUTER WINS");
            computerScore++;
            return true;
        }

    //Diagonal Wins
    
        if(gameboard[0][0] == 'X'&& gameboard[1][2] == 'X' && gameboard [2][4] == 'X' ){
            System.out.println("PLAYER WINS");
            playerScore++;
            return true;
        }
        if(gameboard[0][0] == 'O'&& gameboard[1][2] == 'O' && gameboard [2][4] == 'O' ){
            System.out.println("COMPUTER WINS");
            computerScore++;
            return true;
        }

        if(gameboard[2][0] == 'X'&& gameboard[1][2] == 'X' && gameboard [0][4] == 'X' ){
            System.out.println("PLAYER WINS");
            playerScore++;
            return true;
        }
        if(gameboard[2][0] == 'O'&& gameboard[1][2] == 'O' && gameboard [0][4] == 'O' ){
            System.out.println("COMPUTER WINS");
            computerScore++;
            return true;
        }

        if(gameboard[0][0] != '_' && gameboard[0][2] != '_' && gameboard[0][4] != '_' && gameboard[1][0] !='_'&&
            gameboard[1][2] != '_' && gameboard[1][4] != '_' && gameboard[2][0] != ' ' && gameboard[2][2] != ' ' && gameboard[2][4] != ' '){
            System.out.println("IT'S A TIE");
            return true;
        }

return false;}

//If they choose yes, the board should reset

public static void resetBoard(char [][] gameBoard){
    gameBoard[0][0] = '_';
    gameBoard[0][2] = '_';
    gameBoard[0][4] = '_';
    gameBoard[1][0] = '_';
    gameBoard[1][2] = '_';
    gameBoard[1][4] = '_';
    gameBoard[2][0] = ' ';
    gameBoard[2][2] = ' ';
    gameBoard[2][4] = ' ';

}
}
               
        

