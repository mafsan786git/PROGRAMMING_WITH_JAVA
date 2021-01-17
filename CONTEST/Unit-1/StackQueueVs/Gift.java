import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Gift {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        while(0 < t--){
            input = br.readLine().split(" ");
            String str = input[0];
            ArrayList<Character> output = new ArrayList<>();
            HashSet<Character> set = new HashSet<>();
            Queue<Character> queue = new LinkedList<>();
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                if(set.contains(str.charAt(i))){
                    if(queue.isEmpty()){
                        output.add('#');
                    }else{
                        if(queue.peek() != str.charAt(i)){
                            output.add(queue.peek());
                        }else{
                            queue.remove();
                            if(queue.isEmpty())
                                output.add('#');
                            else
                            {
                                char c = queue.peek();
                                while(arr[c-'a'] == 1 && !queue.isEmpty())
                                {
                                    queue.remove();
                                    if(!queue.isEmpty())
                                        c = queue.peek();
                                }
                                if(queue.isEmpty())
                                    output.add('#');
                                else
                                    output.add(queue.peek());
                            }
                                
                        }
                    }
                    arr[str.charAt(i)-'a'] = 1;

                }else{
                    if(queue.isEmpty()){
                            output.add(str.charAt(i));
                    }else{
                        if(queue.peek() != str.charAt(i)){
                            output.add(queue.peek());
                        }else{
                            queue.remove();
                            if(queue.isEmpty())
                                output.add('#');
                            else
                                output.add(queue.peek());
                        }
                    }
                    queue.add(str.charAt(i));
                    set.add(str.charAt(i));
                }
            }
            for (Character character : output) {
                System.out.print(character);
            }
            System.out.println();
        }
    }
}