#include <iostream>
using namespace std;

int main(){
    int x,y,sum=0;
    cin>>x;
    int *v=new int[x];
    for(int i=0; i<x; i++){
        cin>>v[i];
    }
    cin>>y;

    for(int i=0; i<x; i++){
        if(v[i]==y){
            sum++;
        }
    }
    cout<<sum<<endl;
    delete[] v;
}