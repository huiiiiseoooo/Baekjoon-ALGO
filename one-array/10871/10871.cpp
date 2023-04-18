#include <iostream>
using namespace std;

int main(){
    int x,y;
    cin>>x>>y;
    int *a= new int[x];
    for(int i=0; i<x; i++){
        cin>>a[i];
    }
    for(int i=0; i<x; i++){
        if(a[i]<y){
            cout<<a[i]<<" ";
        }
    }

    delete[] a;
}