public class SelectionSort {
	//Katrine Bjorner, Alan Shi, and Sunny Dhindsa!
	//REGRESSION EQUATION: 49.418x - 1552.4
	//O(N) = N^2 
	public static int selectionSort(int [] array )
	{
		int minIndex ; 
		int temp ; 
		int count = 0 ;  
		int n = array.length ; 
		for (int i = 1; i<=n-1;i++)
		{
			minIndex = i ; 
			for (int j = i+1; j<n; j++)
			{
				if (array[j] < array[minIndex])
				{
					count++ ; 
					minIndex = j; 
				}
				temp = array[i] ; 
				array[i] = array[minIndex] ; 
				array[minIndex] = temp ;
				
			}
		}
		return count ; 
	}

	public static void main(String[] args) {
		int array2[] = {10, 50, 1000, 5000, 10000, 20000} ; 
		for(int k = 0 ; k<array2.length; k++)
		{
			
		int array[] = new int[array2[k]] ; 
		
		
		for (int i = 0 ; i<array.length ; i++)
		{
			array[i] = (int)(Math.random()*50) ; 
		}
		
		int count = selectionSort(array) ; 
		System.out.println(array2[k] + " " + count);
		
		

	}

	}
}
