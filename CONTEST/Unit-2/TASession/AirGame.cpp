#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;
    int height[n];
    int decentRate[n];
    for (int i = 0; i < n; i++)
        cin>>height[i];
    for (int i = 0; i < n; i++)
        cin>>decentRate[i];
    double ratio[n];
    for (int i = 0; i < n; i++)
        ratio[i] = height[i]/(double)decentRate[i];
    // for (int i = 0; i < n; i++)
    //     cout<<ratio[i]<<" ";
    int count=0;
    double time = 0.0;
    cout<<endl;
    for (int i = 0; i < n; i++)
    {
        cout<<time<<" ";
        if(time < ratio[i])
        {
            time = time+1.0;
            count++;
        }
        
    }
    cout<<endl;
    cout<<count<<endl;
    
    
}