import net.datastructures.* ; 
import java.util.* ; 
public class PositionaListing {
	
	static int playerApos ; 
	static int playerBpos ; 
	static int aScore ; 
	static int bScore ; 
	static int aNumOfWins ; 
	static int bNumOfWins ; 
	
	public static void doStuff(PositionalList<Integer> list)
	{
		
		Position<Integer> markerA = list.first();   
		Position<Integer> markerB = list.first() ;
		while(true) 
		{
 
		int diceRollA = 1 + (int)(Math.random()*7) ; 
		for (int i = 0 ; i< diceRollA ; i++)
		{
			markerA = list.after(markerA) ; 
			if (markerA == null)
			{
				aScore+=3 ; 
				break ; 
			}
		}
		
		if (markerA != markerB)
			
		aScore+=markerA.getElement() ; 
		
		else
			aScore -= markerA.getElement() ; 
	
		int diceRollB = 1 + (int)(Math.random()*7) ; 
		for (int i = 0 ; i<diceRollB; i++)
		{
			markerB = list.after(markerB) ; 
			if (markerB == null)
			{
				bScore+=3 ; 
				break ; 
			}
		}
		if (markerB != markerA)
			bScore += markerB.getElement() ; 
		else
			bScore-= markerB.getElement() ; 
		
		} 
		
	
		
			
	}
		
	
	
	public static void main(String[] args) {
		//Ranti Adeniyi, Sanghoon Hwang, Alex Brzozowski, Sunny Dhindsa
		PositionalList<Integer> stuff = new LinkedPositionalList<Integer>() ; 
		for (int i = 0 ; i<50; i++)
		{
			stuff.addLast(1 + (int)(Math.random()*4)) ; 
			
		}
		
		for (int i = 0 ; i<100; i++)
		{
			doStuff(stuff) ; 
			if (aScore > bScore)
				aNumOfWins++ ; 
			else
				bNumOfWins++ ; 
			
		}
		System.out.println("A won: " + aNumOfWins) ; 
		System.out.println("B won: " + bNumOfWins) ;
		
		
	    int[][] tests = {
	       
	      {3, 5, 2, 4, 1, 9, 10, 12, 11, 8, 7, 6},
	    };

	    for (int[] raw : tests) {
	      PositionalList<Integer> data = new LinkedPositionalList<Integer>();
	      for (int c : raw)
	        data.addLast(c);
	      System.out.println("Before: " );
	    }
	}
	 
	       
	  public static void insertionSort(PositionalList<Integer> list) {
	    Position<Integer> marker = list.first();         // last position known to be sorted
	    while (marker != list.last()) {
	      Position<Integer> pivot = list.after(marker);
	      int value = pivot.getElement();                // number to be placed
	      if (value > marker.getElement())               // pivot is already sorted
	        marker = pivot;
	      else {                                         // must relocate pivot
	        Position<Integer> walk = marker;             // find leftmost item greater than value
	        while (walk != list.first() && list.before(walk).getElement() > value)
	        {
	          walk = list.before(walk);}
	        
	        list.remove(pivot);                          // remove pivot entry and
	        list.addBefore(walk, value);                 // reinsert value in front of walk
	      }
	    }
	  }
	    }