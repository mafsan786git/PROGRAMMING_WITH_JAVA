import java.util.Stack;

public class LargestHistogram84 {
    public static void main(String[] args) {
        int answer = largestHistogram(new int[]{2,1,5,6,2,3});
        System.out.println(answer);
    }

    private static int largestHistogram(int[] heights){
        int maxArea = 0;
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        for(int i = 0; i < heights.length;i++){
            int start = i;
            while(!stack.empty() && stack.peek().getValue() > heights[i] ){
                Pair<Integer,Integer> pair = stack.pop();
                int index = pair.getKey();
                int lastHeight = pair.getValue();
                maxArea = Math.max(maxArea, lastHeight * (i-index));
                start = index;
            }
            stack.push(new Pair<Integer,Integer>(start,heights[i]));
        }
        while(!stack.empty()){
            Pair<Integer,Integer> pair = stack.pop();
            int index = pair.getKey();
            int lastHeight = pair.getValue();
            maxArea = Math.max(maxArea, lastHeight * (heights.length-index));
        }
        return maxArea;
    }


    public static class Pair<A,B>{
        private A key;
        private B value;

        public Pair(A key,B value){
            this.key = key;
            this.value = value;
        }

        public A getKey() {
            return this.key;
        }
        public void setKey(A key) {
            this.key = key;
        }
        public B getValue() {
            return this.value;
        }
        public void setValue(B value) {
            this.value = value;
        }
        
    } 

}
