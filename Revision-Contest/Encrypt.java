import java.util.*;
// import java.io.*;

public class Encrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        StringBuilder op = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            char c;
            if(Character.isLowerCase(str.charAt(i))){
                c = (char)((str.charAt(i)-'a' + k)%26 + 97);
                op.append(c);
            }else if(Character.isUpperCase(str.charAt(i))){
                c = (char)((str.charAt(i)-'A' + k )%26 + 65);
                op.append(c);
                
            }else if(Character.isDigit(str.charAt(i))){
                int x = (str.charAt(i)-'0' + k)%10;
                op.append(x);
            }else{
                op.append(str.charAt(i));
            }
        }
        System.out.println(op);
        sc.close();
    }
}
