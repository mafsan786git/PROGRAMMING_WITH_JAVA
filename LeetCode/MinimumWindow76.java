public class MinimumWindow76 {
    public static void main(String[] args) {
        String answer = minimumWindowFullOptimised("cabwefgewcwaefgcf","cae");
        System.out.println(answer);
    }

    public static String minimumWindowFullOptimised(String s,String t){
        if(t.length() > s.length()) return "";
        int[] countT = createCount(0,t.length(),t);
        int neededCount = uniqueCount(countT);
        int currentCount = 0;
        int[] countS = new int[58];
        // int matches = findMatches(countT,countS);
        int finalFirstIndex = -1;
        int finalLastIndex = -1;
        int lastIndex = 0;
        int minimumWindowSize = Integer.MAX_VALUE;
        for(int currentIndex = 0;currentIndex < s.length();currentIndex++){
            int countIndex = s.charAt(currentIndex)-'A';
            if(countT[countIndex] != 0){
                countS[countIndex]++;
                if(countT[countIndex] == countS[countIndex]){
                    currentCount++;
                }
            }
            while(currentCount == neededCount){
                if(minimumWindowSize > currentIndex-lastIndex+1){
                    finalFirstIndex =lastIndex;
                    finalLastIndex = currentIndex;
                    minimumWindowSize = currentIndex-lastIndex+1;
                }
                int lastCountIndex = s.charAt(lastIndex)-'A';
                if(countT[lastCountIndex] != 0){
                    countS[lastCountIndex]--;
                    if(countT[lastCountIndex] > countS[lastCountIndex]){
                        currentCount--;
                    }
                }
                lastIndex++;
            }
        }
        if(finalFirstIndex != -1){
            return s.substring(finalFirstIndex, finalLastIndex+1);
        }
        return "";
    }

    public static int[] createCount(int start,int end,String str){
        int[] count = new int[58];
        while(start < end){
            count[str.charAt(start)-'A']++;
            start++;
        }
        return count;
    }

    public static int uniqueCount(int[] count){
        int unique = 0;
        for(int value : count){
            if(value > 0){
                unique++;
            }
        }
        return unique;
    }


}
