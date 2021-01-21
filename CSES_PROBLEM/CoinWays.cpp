#include<bits/stdc++.h>
using namespace std;

int main(){
    
    long long int mod = 1000000007;
    long long int n,sum;
    cin>>n>>sum;
    vector<long long> coin(n);
    for (int i = 0; i < n; i++)
        cin>>coin[i];
    vector<long long int> dp(sum+1,0);
    dp[0] = 1;
    for (int i = 1; i < sum+1; i++)
    {
       for (int j = 0; j < n; j++)
       {
           if(i >= coin[j])
                dp[i] = (dp[i] + dp[i-coin[j]])%mod;
       }
       
    }
    cout<<dp[sum]%mod<<endl;
    
    
}