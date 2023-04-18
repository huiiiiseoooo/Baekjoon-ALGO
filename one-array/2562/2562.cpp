#include <iostream>
using namespace std;

int main(){
    int n[9];
    int max=0,count=0;
    for(int i=0; i<9; i++){
        cin>>n[i];
    }
    max=n[0];
    for(int i=0; i<9; i++){
        if(max<n[i]){
            max=n[i];
            count=i;
        }
    }
    cout<<max<<endl;
    cout<<count+1<<endl;
    return 0;
}