#include <iostream>
using namespace std;

int main(){
    int x=0,n=0;
    int a=0,b=0,sum=0;
    cin>>x>>n;
    sum=x;
    for(int i=0; i<n; i++){
        cin>>a>>b;
        sum-=a*b;
        
    }
    if(sum==0){
            cout<<"Yes"<<endl;
        }
    else{
        cout<<"No"<<endl;
    }
}