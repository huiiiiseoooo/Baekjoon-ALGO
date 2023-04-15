#include <iostream>
using namespace std;

int main(){
    int t;
    cin>>t;
    for(int i=1; i<t+1; i++){
        int a,b;
        cin>>a>>b;
        cout<<"Case #"<<i<<": "<<a<<" + "<<b<<" = "<<a+b<<endl;
    }
}