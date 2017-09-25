package sortingPractice;

public class Main {
	public static void main(String[] args){
		int[] a = new int[] { 54, 3, 75, 23, 89, 1 };
		int[] b = new int[] { 54, 3, 75, 23, 89, 1 };
		int[] c = new int[] { 54, 3, 75, 23, 89, 1 };
		
		printArray(a);
		selectionSort(a);
		printArray(a);		
		bubbleSort(b);
		printArray(b);		
		
		System.out.println("** QUICK SORT **");
		quickSort(0, c.length - 1, c);		
	}
	
	public static void selectionSort(int[] a) {
		System.out.println("** SELECTION SORT **");
		
		//get length of array
		int n = a.length;
		
		//iterate through array
		for (int i = 0; i < n -1; i++) {

			//keep track of the lowest index (sorted)
			int lowestIndex = i;
			
			//start at the right of the lowest index
			for (int j = i + 1; j < n; j++) {
				//if the unsorted number is lower than our
				//lowest sorted number
				if (a[j] < a[lowestIndex]) {
					//swap the two
					swap(j, lowestIndex, a);
					//+1 sorted index. move over
					lowestIndex = i;
				}
			}
		}
	}
	
	public static void bubbleSort(int[] a) {
		System.out.println("** BUBBLE SORT **");
		//get length of array
		int n = a.length;
		
		//iterate through array
	    for (int i = 0; i < n; i++) {    
	    	//keep track of swaps for this iteration
	    	int swapCount = 0;
	    	
	    	// iterate the rest of array with i pointer
	        for (int j = 0; j < n - 1; j++) {
	        	// if the current index is larger than 1 ahead
	            if (a[j] > a[j+1]) {
	            	//swap higher to right side
	                swap(j, j+1, a);
	                //note we made swaps
	                swapCount++;
	            }
	        }
	        //if no swaps happened, the array is sorted
	        if (swapCount == 0) {
	            break;
	        }
	    }
	}
	
	public static void quickSort(int low, int high, int[] a){
		if (low < high) {
		
		// shift/sort array, get current pointer
		int pi = partition(low, high, a);
		
		// ?
		quickSort(low, pi - 1, a);
		// ?
		quickSort(pi + 1, high, a);
		}
		}
		
	public static int partition(int low, int high, int[] a) {
		   System.out.println("high " + high + " low " + low);
		   // grab righter most element
		   int pivot = a[high];
		   
		   //pointer: get the lowest element index and move behind 1
		   int i = low - 1;
		   
		   //iterate starting at the lowest index, stop 
		   //at the highest index
		   for (int j = low; j <= high - 1; j++){
			   // if the current index is less than the pivot
		       if (a[j] <= pivot){
		    	   //move our first pointer over one
		           i++;
		           //put the less than pivot element at pointer index
		           swap(i, j, a);
		       }
		   }
		   // put the pivot in front of the last lowest pointer
		   swap(i+1, high, a);

			printArray(a);
		   //return the new pointer position
		   return (i + 1);
		}
	
	static void swap(int firstIndex, int secondIndex, int[] a){
		int temp = a[firstIndex];
		a[firstIndex] = a[secondIndex];
		a[secondIndex] = temp;
	}
	
	static void printArray(int[] a) {
		System.out.print("[ ");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("]");
	}
}
