public class KthGrammer {
    public static void main(String[] args) {
        // kthGrammarRec(5,new StringBuilder());
        System.out.println( kthGrammarRec(2,new StringBuilder()).toString().charAt(2-1));
    }

    private static StringBuilder kthGrammarRec(int n,StringBuilder str){
        if(n == 1) {
            return str.append('0');
        }
        str = kthGrammarRec(n-1,str);
        StringBuilder newStr = new StringBuilder(str);
        for(int index = 0;index < str.length();index++){
            if(str.charAt(index) == '0'){
                newStr.append('1');
            }else{
                newStr.append('0');
            }
        }
        
        return newStr;
    }
}