import java.util.Arrays;

public class Testsort {
    
	
	public static void printarr(int[] array) {
      int i;
      for(i = 0 ; i < array.length ; i++) {
    	  System.out.print(array[i] + ",");
      }
      System.out.println("");
	}
	
	public static void insertSort(int[] array) {
	  int i;
	  int j;
	  int temp;
	  for (i = 1; i<array.length; i++) {
		  for (j = i-1; j>=0; j--) {
			  if (array[j+1]<array[j]) {
				  temp = array[j+1];
				  array[j+1] = array[j];
				  array[j] = temp;
			  }
		  }
	  }
	}
	
	public static int findmiddle(int L,int H,int[] array) {
	  int middle;
	  middle = array[L];
      while(L<H) {
    	  while (L<H && array[H]>=middle) {
    		  H--;
    	  }
    	  array[L] = array[H];
    	  while (L<H && array[L]<middle) {
    		  L++;
    	  }    	  
    	  array[H] = array[L];
      }
      array[L] = middle;
      return L;
	}
	
	public static void quickSort(int L,int H,int[] array) {
		int Middle;
		if (L<H) {
			Middle = findmiddle(L,H,array);
			quickSort(L,Middle-1,array);
			quickSort(Middle+1,H,array);
		}
	}
	
	public static int findMin(int[] array){
		if (array == null || array.length==0) {
			return -1;
		}
		int loc = 0;
		int min = array[0];
		for(int i = 1; i<array.length;i++) {
		   if(array[i]<min) {
			   min = array[i];
			   loc = i;
		   }
		}
		return loc;
	}
	
	public static void selectSort(int[] array) {
		int H;
		int temp;
		for (int i=0; i<array.length ;i++) {
		    H = findMin(Arrays.copyOfRange(array,i,array.length));
		    if (H>=0) {
		       temp = array[H+i];
		       array[i+H] = array[i];
		       array[i] = temp;
		    }
		}
		
	}
	
	public static int[] merge(int[] L,int[] R) {
		//following code is not the best way to realize it
		int[] Aimarray = new int[L.length+R.length]; 
		int i = 0,j = 0,k = 0;
		while((i<L.length || j<R.length) && k<Aimarray.length) {
			if (i>=L.length) {
				Aimarray[k] = R[j];
				k++;
				j++;
				continue;
			}
			if (j>=R.length) {
				Aimarray[k] = L[i];
				k++;
				i++;
				continue;
			}			
			if (L[i]<=R[j]) {
				Aimarray[k] = L[i];
				k++;
				i++;
			} else {
				Aimarray[k] = R[j];
				k++;
				j++;
			}
		}		
		return Aimarray;		
	}
	
	
	public static int[] mergeSort(int[] array) {
	   if (array == null || array.length <= 1) {
		   return array;
	   }	
	   int middle = array.length/2;
	   int[] L = Arrays.copyOfRange(array,0,middle);
	   int[] R = Arrays.copyOfRange(array,middle,array.length);
	   L = mergeSort(L);
	   R = mergeSort(R);
	   array =  merge(L,R);	   
	   return array;

	}
	
	public static void main(String args[]) {
		
      int[] sortarray = {54,56,12,76,10,-66,-98,-1,6,32,89,45};
//    int[] sortarray = {};
      
	  System.out.print("Before sort:");
	  printarr(sortarray);
	  
	  //quickSort(0,sortarray.length-1,sortarray);
	  //insertSort(sortarray);
	  //selectSort(sortarray);
	  sortarray = mergeSort(sortarray);

	  System.out.print("After sort:");
	  printarr(sortarray);
	}
}
