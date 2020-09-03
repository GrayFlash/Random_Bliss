#include <math.h>
#include <iostream>
using namespace std;
int main(){
    int t;
    long n,a,b,c,d;
    long l[1000000];
    long h[1000000];
    bool sep[1000000];
    long per[1000000];
    long mod = 1000000007;
    int w,k;
    cin>>t;
    for(int o=1;o<=t;o++){
        cin>>n>>k>>w;
        for(int i=0;i<k;i++)cin>>l[i];
        cin>>a>>b>>c>>d;
        for(int i=k;i<n;i++)l[i] = (a*l[i-2] + b*l[i-1] +c)%d + 1;
        for(int i=0;i<k;i++)cin>>h[i];
        cin>>a>>b>>c>>d;
        for(int i=k;i<n;i++)h[i] = (a*h[i-2] + b*h[i-1] +c)%d + 1;
        sep[0]=1;
        for(int i=1;i<n;i++)sep[i] = ((l[i]-l[i-1])>w);
        per[0] = 2*(w + h[0]);
        for(int i=1;i<n;i++){
            if(sep[i]){
                per[i] = per[i-1] + 2*(w+h[i]);
            }else{
                per[i] = per[i-1] + abs(h[i]-h[i-1]) + h[i] + 2 * (w - (l[i]-l[i-1]));
            }
        }
        for(int i=1;i<n;i++)per[i] = (per[i] * per[i-1])%mod;
        cout<<"Case #"<<o<<": "<<per[n-1]<<endl;
    }
    return 0;
}