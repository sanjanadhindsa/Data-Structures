import java.util.Scanner;


public class TicTacToeProject {
	static final int RED =1, BLUE=2;
	static int NUM_COLUMNS = 4;
	static int NUM_IN_ROW=4;
	static int firstplayer;
	static int p1=0,p2=0,ties=0;
	static long cnt=0;
	static int choice ; 
	public static void main(String[] args) { // red = x ; blue = y
		Scanner scan = new Scanner(System.in) ; 
		System.out.print("Choose 3x3 (press 3) or 4x4 (press 4): ");
		int choice = scan.nextInt() ; 
		scan.close() ; 
		if (choice == 4)
		{
		// 4x4 RUNS!! you just have to wait!!! 
		for (int i=0; i<4; i++) { //how many recursive calls to call
			int[ ][ ] list = new int[NUM_COLUMNS][NUM_COLUMNS];
			firstplayer = RED;
			p1=0;p2=0;cnt=0;ties=0;
		    switch(i) {
		    case 0: list[0][0]=RED; break; //  upper left hand corner
		    case 1: list[0][1]=RED; break; //  left side
		    case 2: list[0][2]=RED; break; //  middle 
		    case 3: list[0][3] = RED; break ;
		   
		    
		 
		    }
			Play(list , BLUE);
			System.out.println ("NetWins for column " + (i+1) + " "  + (p1-p2));
			System.out.println ("Number of Recursion calls: " + cnt);
			System.out.println("Red-wins: "+p1 +" Blue-Wins:"+p2);
			System.out.println("***************");
		
	}
		}
		else if (choice == 3)
		{
		
		NUM_COLUMNS = 3 ; 
		NUM_IN_ROW = 3 ; 
			for (int i=0; i<3; i++) { //how many recursive calls to call
				int[ ][ ] list = new int[NUM_COLUMNS][NUM_COLUMNS];
				firstplayer = RED;
				p1=0;p2=0;cnt=0;ties=0;
			    switch(i) {
			    case 0: list[0][0]=RED; break; //  upper left hand corner
			    case 1: list[0][1]=RED; break; //  left side
			    case 2: list[0][2]=RED; break; //  middle 
			    case 3: list[0][3] = RED; break ;
			   
			    
			 
			    }
				Play(list , BLUE);
				System.out.println ("NetWins for column " + (i+1) + " "  + (p1-p2));
				System.out.println ("Number of Recursion calls: " + cnt);
				System.out.println("Red-wins: "+p1 +" Blue-Wins:"+p2);
				System.out.println("***************");
			
		}
		}
	
	}
	
	
	public static int Play(int[][] inlist, int clr) {
		cnt++;
		int res=checkBoard(inlist,clr);
		// 0 - board full, 1- X wins  2 = O wins   3-keep playing
		if (res < 3) { 
			if (res == 0) {ties++;return 0;
			} else {
				if (res == firstplayer) {p1++; return 1;} else {p2++; return -1;}
			}
		}	
		res = 0; // move for tie

		// for each space that can be the next move
		//    make a copy of board (next lines)	
		//   update the board for this move
			for (int col = 0; col<NUM_COLUMNS;col++  ){
				int temp = 0 ; 
				while (temp < NUM_COLUMNS)
				{
				if (inlist[temp][col] == 0) {
					int[][] clonelist = new int[NUM_COLUMNS][NUM_COLUMNS];
					for (int x = 0;x <NUM_COLUMNS;x++  ){
						for (int y = 0; y<NUM_COLUMNS;y++  ){
							clonelist[x][y] = inlist[x][y] ;
						}
					}
					 
					clonelist[temp][col] = clr;
					Play(clonelist, 3- clr);
					temp = NUM_COLUMNS ; 
				}
				else
					temp++ ; 
			}
			}
		
		//  recursively call Play
		return res;
	}
	public static boolean isFull(int[][] inlist){
		boolean empty = true;
		for (int i = 0 ; i<NUM_COLUMNS ; i++ ) {
			for (int i2 = 0 ; i2<NUM_COLUMNS ; i2++ ) {
				if (inlist[i][i2] ==0   ) { empty = false; break;} 
			}
		}
		return empty;
	}
	public static int checkBoard(int[][] inlist ,int clr){
		int chkclr = 3-clr;
		for (int i = 0 ; i<NUM_COLUMNS; i++ ) {
			int colcnt = 0;
			for (int j=0; j<NUM_COLUMNS; j++) {
				if (inlist[i][j] == chkclr) {
					colcnt++;
					if (colcnt == NUM_IN_ROW)  { return chkclr;}	 
				}  else {
					colcnt =0;
				}
			}
		}
		for (int i = 0 ; i<NUM_COLUMNS; i++ ) {
			int colcnt = 0;
			for (int j=0; j<NUM_COLUMNS; j++) {
				if (inlist[j][i] == chkclr) {
					colcnt++;
					if (colcnt == NUM_IN_ROW)  { return chkclr;}	 
				}  else {
					colcnt =0;
				}
			}
		}
		int colcnt = 0;
		for (int i = 0 ; i<NUM_COLUMNS; i++ ) {
			if (inlist[i][i] == chkclr) {
				colcnt++;
				if (colcnt == NUM_IN_ROW)  {return chkclr;}	 
			}  else {
				colcnt =0;
			}
		}
		colcnt = 0;
		for (int i = 0 ; i<NUM_COLUMNS; i++ ) {
			if (inlist[NUM_COLUMNS-1-i][i] == chkclr) {
				colcnt++;
				if (colcnt == NUM_IN_ROW)  { return chkclr;}	 
			}  else {
				colcnt =0;
			}
		}
		if (isFull(inlist)) {  return 0; 
		} else {
			return 4;
		}


	}
	public static void printlist(int[][] inlist) {
		for (int i =0; i<inlist.length; i++) {
			for (int j =0; j<inlist.length; j++) {
				System.out.print(inlist[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
