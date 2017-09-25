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
		quickSort(0, c.length - 1, c);
		printArray(c);		
	}
	
	public static void selectionSort(int[] a) {
		System.out.println("** SELECTION SORT **");
		int n = a.length;
		
		for (int i = 0; i < n -1; i++) {
			int lowestIndex = i;
			
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[lowestIndex]) {
					swap(j, lowestIndex, a);
					lowestIndex = i;
				}
			}
		}
	}
	
	public static void bubbleSort(int[] a) {
		System.out.println("** BUBBLE SORT **");
		int n = a.length;
	    for (int i = 0; i < n; i++) {    
	    int swapCount = 0;
	        for (int j = 0; j < n - 1; j++) {
	            if (a[j] > a[j+1]) {
	                swap(j, j+1, a);
	                swapCount++;
	            }
	        }
	        if (swapCount == 0) {
	            break;
	        }
	    }
	}
	
	public static void quickSort(int low, int high, int[] a){
		   int pi = partition(low, high, a);
		   
		   quickSort(low, pi - 1, a);
		   quickSort(pi + 1, high, a);
		}
		
	public static int partition(int low, int high, int[] a) {
		   System.out.println("high " + high);
			int pivot = a[high];
		   
		   int i = low - 1;
		   
		   for (int j = low; j < high - 1; j++){
		       if (a[j] <= pivot){
		           i++;
		           swap(i, j, a);
		       }
		   }
		   swap(i+1, high, a);
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
		System.out.println(" ]");
	}
}
