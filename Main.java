/*
Tamara Bueno
11/30/2022
Assignment#5: BattleShip
Program: Battleship game, enter Letter first then number, case sensitive
goal is to hit all 4 ships shown as X, spots filled up are #.

*/
import java.util.*;
//import java.util.Random;

//looks like 41 rows.. but i s +--- (11 +)
//set to a final = then do .length, ex:matrix1 use index i of matrix

public class Main {
  public static void main(String[] args) { 
    final int SIZE =10; //sets size 10 final
    final int Ship_Size = 4; //sets ship size to 4 final
    int tries =0, //store the number of attempts the player has to hit ships.
        NumHits=0; // number of ships the player hit.
    
    int[][] board = new int[SIZE][SIZE]; // stores the game board.
    int[][] ships = new int[Ship_Size][Ship_Size]; //stores the position (row and column) 4 hidden ships on the board.
    int[] shoot = new int[4];//stores the position (row and column) of the shot that the player will take each round
    
    tenbyten(board); //calls board method, places 10 by 10 in
    RandomShips(ships); //calls ship, places 4 by 4 in
    
    // //tests for random
    //  for(int i=0;i<ships.length;i++){ //random ship #'s
    //     for(int j=0;j<ships[0].length;j++)
    //    System.out.print(ships[i][j]);
    //    //System.out.print(shoot(shoot));
      
    //    System.out.println();
    //  }
    // //ends here
    welcome();
    System.out.println();
    
    do{
        BattleBoard(board); //callcs board aka 10 by 10 in demBoard
        shoot(shoot); //shoot aka4, in shoot()
        
        tries++; //adds to tries
        
        if(goal(shoot,ships, board)) {
            NumHits++; }                
        else  
        btsboard(shoot,ships,board); //callcs 4, 10 by 10, 4 by 4 in btsboard
        //System.out.print(" ");
    }
      while(NumHits!=3); //as long as tries arent exceeded, aka 3 tries
    
    System.out.println("You finished!!! You hit the 4 ships!"); 
    System.out.println("Congrats !");
    
    BattleBoard(board); //board called and shown
}

public static void letters() { //match method to numbers when user types in info
  System.out.print("     "); 
  for (char c = 'A'; c <= 'J'; c++) { //A =1, b=2, c=3
    System.out.print(c + "   ");
  }
}

  
public static void tenbyten(int[][] board){ //set board to 10 by 10
    for(int row=0 ; row < 10 ; row++ )
        for(int column=0 ; column < 10 ; column++ )
            board[row][column]=-1; //for loop, rows + col all now = -1
}

public static void welcome() { //match method to numbers? when user types in info
  System.out.println();
  for (int i = 0; i < 45; i++){
    System.out.print("*");
  }
  System.out.println();
  System.out.println("Welcome to Battle Ship!"); 
  System.out.println();
  System.out.println("                                     "); 
  System.out.println("                                     "); 
  System.out.println("  L             -~               !   "); 
  System.out.println("    E        _~ )_)_~          Y     "); 
  System.out.println("      T'     )_))_))_)       A       "); 
  System.out.println("        S    _!__!__!_      L        "); 
  System.out.println("             \\_______/   P          "); 
  System.out.println("           ~~~~~~~~~~~~~~            "); 
  System.out.println("             ~~~~~~~~~~              "); 
  System.out.println();
  for (int i = 0; i < 45; i++){
    System.out.print("*");
  }
  System.out.println();
}
public static void BattleBoard(int[][] board) {
  //shows how the = -1 and = 1 and = 0 work 
  // for(int i=0;i<board.length;i++){
  //     for(int j=0;j<board[0].length;j++)
  //       System.out.print(board[i][j] + " ");
  //   System.out.println();
  // }
    
    letters(); //calls the top graph of board
    System.out.println();
    
    for(int row=0 ; row < 10 ; row++ ){
        //System.out.print(row + " ");
      System.out.print("   ");
        for(int boarder = 0; boarder < board[0].length; boarder++)
      {
        System.out.print("+---"); //prints out top row
      }
      System.out.print("+"); // adds to the last row
      System.out.println();
       
      int check = 0; //set check to 0
      //System.out.print("   "); //test
      System.out.print(row); //moves row down
      for(int column=0 ; column < 10 ; column++ ){ //inside
            if(board[row][column]==-1 && check == 0){ //10 by 10 in for loop, = " "
              //as in BattleBoard == -1, print empty space
                System.out.print("  |" + " ");
                check = 0;}//inside the squares 
            else if(board[row][column]==-1 && check!=0){ //if =-1 print empty space
                System.out.print(" |" + " "); //keep format |
                check = 0;//inside the squares + "\t"
            }else if(board[row][column]==0){ //if = 0 then # 
                //System.out.print("# |"); //if >1 <9, print |x|
                System.out.print("  | #");
                check = 1;//1,1
            }else if(board[row][column]==1){ //if = 1, then X shows
                System.out.print("  |"+" X");
                check = 2;//does not show
            }
        }
        System.out.print("  |"); //3 spaces
        System.out.println();
      
    }
  
      System.out.print("   ");
      for(int boarder = 0; boarder < board[0].length; boarder++) //loop variable has to be then peramiter 
      {
        
        System.out.print("+---"); //last line board
      }
      System.out.print("+"); //closing + of the last row
      System.out.println();

}

public static void RandomShips(int[][] ships){ //taking in 4 by 4 ships
    Random random = new Random();
    for(int ship=0 ; ship < 4 ; ship++){
        ships[ship][0]=random.nextInt(10); //the first 0 of ships random
        ships[ship][1]=random.nextInt(10); //the sec 1 of ships random
    //ships[ship][1] = (ships[ship][0]=random.nextInt(10) + 1);
    // for(int mep=0 ; mep < 4; mep++){ //added
    //   ships[mep][2] = random.nextInt(10); //added
    //   ships[mep][3] = random.nextInt(10); //added
    // } 
      
      //test run
      // for (int i = 0; i < ships.length; i++){
      //   for (int j = 0; j< ships[0].length;j++){
      //      //System.out.print(ships[i][j] + " ");
          
      //   }
      // }
      //System.out.print("??"+ships[0][0]+">>"); //more test
     // System.out.print(ships);
      
        for(int last=0 ; last < ship ; last++){
          //for(int mep=0 ; mep < 4; mep++){
            if( (ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]) )
                do{
                    ships[ship][0] = random.nextInt(10); //was 5
                    ships[ship][1]= random.nextInt(10);
                   // ships[mep][2] = random.nextInt(4); //added
                   // ships[mep][3] = random.nextInt(4);
                  
                }
                  while( (ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]) );
          //} //added
        } //
    }
}
//converts language into code
public static void shoot(int[] shoot){ //int[][] in method call parimeter
    Scanner input = new Scanner(System.in);
   // while (true) {
    System.out.print("Enter a coordiante to target (e.g. A1): ");
    
    String move = input.nextLine();
    //System.out.println(move.length());//f6 
    // if(move.length() > 2){ //
    //   System.out.println("Invalid, Enter input again");
    //     //take input again
    //     System.exit(0);
    // }
    shoot[0] = (int)move.charAt(1);
    // numbers //ALL CAPITAL //48
  //System.out.print(shoot[0]+ " ? ");
   
    //shoot[0]--;
    
    //System.out.print("Column: ");
    shoot[1] = (int)move.charAt(0);
  //System.out.println(shoot[0] +" "+ shoot[1]);//changes from letter to # ascii code 64
  //input.nextInt(); //nextInt();
    //System.out.print(shoot[1]+ " $? ");
    //shoot[1]--; //makes it into columns
  //Int letter = move.charAt(0); 
  System.out.println(); 
  //length of shoot[0[], shoot [1]
  // if (move.length() < 2) {
  // if(shoot[1]>=65 && shoot[1]<=90)
  //   //capital, number, if else, nested if,
  //   if (shoot[0] >= 0 && shoot[0]<= 9) 
  //     System.out.print("Valid");
  //     //valid , else 
  //     else //no ;
  //     System.out.print("Doesnt work");
  //   }
  // else
  //   System.out.print("Doesnt work");
  // }
  if(move.length() <= 2 && (shoot[1]>=65 && shoot[1]<=90) && (shoot[0]>=48 && shoot[0] <=57)){
    System.out.println("Valid");
    shoot[1] = shoot[1]-65;
    shoot[0] = shoot[0]-48; 
  }else{
    System.out.println("Invalid, Please Try Again"); //place back into code
    System.exit(0);
//start again a while loop? saved porgress ?
 
  } 
   // }
  
    
}

public static boolean goal(int[] shoot, int[][] ships, int[][] board){ //add , String [] args?
    
    for(int ship=0 ; ship<ships.length ; ship++){
        if( shoot[0]==ships[ship][0] && shoot[1]==ships[ship][1]){  //if shoot = to ran numb, means X, u hit a ship
            System.out.printf("You hit a ship! YAY!"); //where last shot //took out +
          board[shoot[0]][shoot[1]] = 1; // 1 = X, ship hit
            return true;
        }
    }
    return false;
    // return 1; to print out x 
}

//behind the scences board
public static void btsboard(int[] shoot, int[][] ships, int[][] board){ //delete this?
    if(goal(shoot,ships, board)) // 1 is X, 0 is #
       board[shoot[0]][shoot[1]]=1; // when = 1 then shows X
     else{
      // System.out.println(shoot[0]); 
      // System.out.println(shoot[1]);
       board[shoot[0]][shoot[1]]=0; //when = 0 then shows #
     }
      
}
  
}
  
