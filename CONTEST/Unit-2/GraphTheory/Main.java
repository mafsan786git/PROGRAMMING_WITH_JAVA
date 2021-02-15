import java.util.*;
import java.io.*;
/**leftSum == rightSum in array at particular index,which means balanced index */
public class Main{
	public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i] = sc.nextInt(); 
    }
    System.out.println(balancedIndex(arr));
  }
  private static int balancedIndex(int[] arr){
  	if(arr.length == 0)
      	return -1;
  	if(arr.length == 1)
      return 0;
   	for(int i=1;i<arr.length;i++)
    	arr[i] += arr[i-1];
    int rightSum = 0;
    int leftSum = 0;
    for(int i=arr.length-1;i>=0;i--){
      	if(i == 0){
              if(leftSum == rightSum)
                return i;
        }
        else{
            if(arr[i-1] == rightSum)
          	    return i;
      	    rightSum += arr[i]-((i > 0) ? arr[i-1] : 0);
        }
    }
    return -1;
  }
  
}