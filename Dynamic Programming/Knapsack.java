
public class Knapsack {
    static int MaxNum = 100;
    
	public static void printarr(int[] array) {
	      int i;
	      for(i = 0 ; i < array[array.length-1] ; i++) {
	    	  System.out.print(array[i] + ",");
	      }
	      System.out.println("");
		}    
    
    public static int[] Pickup(int N,int Volume,int[] Weights,int[] Values){

        int i,j,k;
    	int[][] dp = new int[Volume+1][N];
        int[][][] paths = new int[Volume+1][N][N+1]; 
    	
        for(i = Weights[0]; i <= Volume;i++) {
           dp[i][0] = Values[0];
           paths[i][0][N]++;
        }
        
    	for(j = 1;j < N; j++) {
    		for(i = 0;i <= Volume ;i++) {
 			   dp[i][j] = dp[i][j-1];
 			   System.arraycopy(paths[i][j-1], 0, paths[i][j], 0, N+1);
    		   if (i >= Weights[j]) {
    			  for(k=0; k<=i-Weights[j];k++) {
     				 if(dp[k][j-1]+Values[j] > dp[i][j]) {
    					 dp[i][j] = dp[k][j-1]+Values[j];
    					 System.arraycopy(paths[k][j-1], 0, paths[i][j], 0, N+1);    					 
    					 paths[i][j][paths[i][j][N]] = j;
    					 paths[i][j][N]++;
    				 }     				  
    			  }
    		   }
    		}
    	}
  	
    	System.out.println(dp[Volume][N-1]);
    	return paths[Volume][N-1];
    }
    
    public static void main(String args[]) {
    	int[] weights = {2,7,3,4,8,5,8,6,4,16};
    	int[] values = {15,25,8,9,15,9,13,9,6,14};
    	int n = 10, volume = 34;
    	
    	printarr(Pickup(n,volume,weights,values));
    	
    }
  
}
