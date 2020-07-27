#include<bits/stdc++.h>
#define intt long long
#define fast ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
using namespace std;
intt comb(int count; int i){
    if(i==0 || i==count) return 1;
    intt ans = 1;
    for(int a=0; a<i; a++){
        ans *=(count-a);
        ans /=(a+1);
    }
    return ans;
}
int main(){
fast;
int N, x;
cin>>N;
int A[101];
int i;
for(i=0; i<N; i++){
    cin>>x;
    A[x]++;
}

int ans = 0, count=0;
for(i=0; i<101; i++){
    if(A[i]>0) count++;
}
intt sum = 0;
int start =0;
if(count%2==0) start = 1;
for(i=start; i<=count; i++){
    sum += comb(count, i);
}
cout<<sum<<"\n";
}