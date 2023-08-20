public class PatternMatching28 {

    public static void main(String[] args) {
        findFirstIndexOfNeedleInHayStackByKMP("sadbutsad","sad");
    }

    private static int findFirstIndexOfNeedleInHayStackByKMP(String hayStack,String pattern){
        int indexOfFirstOccurrence = -1;
        if(hayStack.length() == 0 || pattern.length() == 0 || hayStack.length() < pattern.length()){
            return indexOfFirstOccurrence;
        }
        int[] longestPrefixSuffix = new int[pattern.length()];
        populateLongestPrefixSuffixList(longestPrefixSuffix,pattern);
        int indexOfHay = 0;
        int indexOfPattern = 0;
        while((hayStack.length()-indexOfHay) >= (pattern.length()-indexOfPattern)){
            if(hayStack.charAt(indexOfHay) == pattern.charAt(indexOfPattern)){
                indexOfPattern++;
                indexOfHay++;
            }
            if(indexOfPattern == pattern.length()){
                return indexOfHay-indexOfPattern;
            }
            else if(indexOfHay < hayStack.length() && pattern.charAt(indexOfPattern) != hayStack.charAt(indexOfHay)){
                if(indexOfPattern != 0){
                    indexOfPattern = longestPrefixSuffix[indexOfPattern-1];
                }else{
                    indexOfHay++;
                }
            }
        }
        return indexOfFirstOccurrence;
    }

    private static void populateLongestPrefixSuffixList(int[] longestPrefixSuffix,String pattern){
        int lpsLength = 0;
        int indexOfPattern = 1;
        longestPrefixSuffix[lpsLength] = 0;
        while(indexOfPattern < pattern.length()){
            if(pattern.charAt(indexOfPattern) == pattern.charAt(lpsLength)){
                lpsLength++;
                longestPrefixSuffix[indexOfPattern] = lpsLength;
                indexOfPattern++;
            }else{
                if(lpsLength != 0 ){
                    lpsLength = longestPrefixSuffix[lpsLength-1];
                }else{
                    longestPrefixSuffix[indexOfPattern] = lpsLength;
                    indexOfPattern++;
                }
            }
        }
    }
    
}
