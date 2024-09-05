public class PatternMatching {
    public static void main(String[] args) {
        
        int ans = rabinKarpOneHash("ababcaababcaabc","ababcaabc");
        System.out.println(ans);
    }

    public static int rabinKarpOneHash(String haystack, String needle){
        int n = haystack.length();
        int m = needle.length();
        if(n < m) return -1;
        int RADIX = 26;
        int MOD = 1000000033;
        long MAX_WEIGHT = 1;

        for(int index = 0; index < m; index++) MAX_WEIGHT = (MAX_WEIGHT * RADIX)%MOD;

        long hashNeedle = hasValue(needle,RADIX,MOD,m), hashHay = 0;

        for(int windowStart = 0; windowStart <= n-m; windowStart++){
            if(windowStart == 0){
                hashHay = hasValue(haystack,RADIX,MOD,m);
            }else{
                hashHay = (((hashHay * RADIX) % MOD)
                        - (((int)(haystack.charAt(windowStart-1) - 'a') * MAX_WEIGHT)%MOD)
                        + (int)(haystack.charAt(windowStart+m-1) - 'a') + MOD)%MOD;

            }
            if(hashHay == hashNeedle){
                for (int i = 0; i < m; i++) {
                    if (needle.charAt(i) != haystack.charAt(i + windowStart)) {
                        break;
                    }
                    if (i == m - 1) {
                        return windowStart;
                    }
                }
            }
        }
        return -1;
    }

    public static int hasValue(String str, int RADIX,int MOD, int m){
        long ans = 0;
        long multiplyingFactor = 1;
        for (int i = m-1; i>=0;i--){
            ans = (ans + (str.charAt(i) - 'a') * multiplyingFactor) % MOD;
            multiplyingFactor = (multiplyingFactor * RADIX ) %MOD;
        }
        return (int)ans;
    }
}