import java.util.Scanner;

public class TreeBuilder {

    public static void main(String[] args){

    }

    public static ListNode buildTreeByUsingArrayElements(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter size of array.");
        int size = sc.nextInt();
        int[] treeElements = new int[size];
        System.out.println("Please enter elements of array.");
        for (int i = 0; i < size; i++) {
            treeElements[i] = sc.nextInt();
        }
        sc.close();
        return new ListNode();
    }
}
