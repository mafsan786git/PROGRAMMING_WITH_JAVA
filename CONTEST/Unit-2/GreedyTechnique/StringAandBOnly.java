import java.io.*;
import java.util.*;
/*
PROBLEM STATEMENT---
    You are given a string S that contains 3 characters: 'a', 'b', and '?'. Your task is to convert it to a string which contains only 2 characters: 'a', 'b'. The converted string must follow following conditions:
    1. It should not contains two letters 'a' in a row.
    2. if there are many strings possible, the answer should be one which is the first in alphabetical order
TIME COMPLEXITY------
    O(N)
*/
public class StringAandBOnly {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        StringBuffer str = new StringBuffer(input.nextToken());
        for (int i = 0; i < str.length(); i++) {
            if(i == 0 && str.charAt(i) == '?'){
                if(str.length() > 1){
                    if(str.charAt(i+1) == 'a')
                        str.replace(i, i+1, "b");
                    else
                        str.replace(i,i+1,"a");
                }
            }else{
                if(str.charAt(i) == '?'){
                    if(i != str.length()-1){
                        if(str.charAt(i-1) != 'a' && str.charAt(i+1) != 'a')
                            str.replace(i,i+1,"a");
                        else
                            str.replace(i,i+1,"b");
                    }else{
                        if(str.charAt(i-1) != 'a')
                            str.replace(i,i+1,"a");
                        else
                            str.replace(i,i+1,"b");
                    }
                }
            }
        }
        System.out.println(str);
    }
    
}
